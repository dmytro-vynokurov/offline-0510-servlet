package ua.goit.web.servlet;

import ua.goit.service.TopicService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class NavigationServlet extends HttpServlet {

    TopicService topicService = new TopicService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String someImportantData = req.getParameter("someImportantData");
        System.out.println(someImportantData);
        List<String> topics = topicService.addTopic(someImportantData);
        req.setAttribute("topics", topics);
        String pageName = req.getParameter("pageName");
        resp.sendRedirect(pageName+".jsp?topics=guigurihgr");
    }
}
