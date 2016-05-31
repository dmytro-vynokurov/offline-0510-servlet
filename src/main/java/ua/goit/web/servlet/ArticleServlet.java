package ua.goit.web.servlet;

import ua.goit.service.TopicService;
import ua.goit.web.template.TemplateManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ArticleServlet extends HttpServlet {

    TopicService topicService = new TopicService();
    TemplateManager templateManager = new TemplateManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String topic = req.getParameter("topic");
        System.out.println(topic);
        List<String> topics = topicService.addTopic(topic);
        req.setAttribute("topics", topics);
//        forward(req, resp);
        String template = templateManager.loadTemplate("test.ftl");
        resp.getWriter().print(template);
    }

    private void forward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }

}
