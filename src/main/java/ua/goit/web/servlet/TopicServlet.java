package ua.goit.web.servlet;

import ua.goit.service.TopicService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TopicServlet extends HttpServlet {

    TopicService topicService = new TopicService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String topics = topicService.getTopics().toString();


        resp.addHeader("Content-Type","application/json");
        resp.setHeader("Character-Encoding", "UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.append(topics);
        writer.flush();
    }
}
