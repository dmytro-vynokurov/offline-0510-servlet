package ua.goit.web.template;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;

public class TemplateManager {
    private static Configuration cfg;
    static{
        // Create your Configuration instance, and specify if up to what FreeMarker
// version (here 2.3.24) do you want to apply the fixes that are not 100%
// backward-compatible. See the Configuration JavaDoc for details.
         cfg = new Configuration();

// Specify the source where the template files come from. Here I set a
// plain directory for it, but non-file-system sources are possible too:
        try {
            File templatesDirectory = new File(".");
            System.out.println(templatesDirectory);
            cfg.setDirectoryForTemplateLoading(templatesDirectory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

// Set the preferred charset template files are stored in. UTF-8 is
// a good choice in most applications:
        cfg.setDefaultEncoding("UTF-8");

// Sets how errors will appear.
// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

    }

    public String loadTemplate(String templateName) {
        try {
            Template template = cfg.getTemplate(templateName);
            return template.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
