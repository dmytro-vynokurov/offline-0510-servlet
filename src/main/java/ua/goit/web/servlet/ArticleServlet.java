package ua.goit.web.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArticleServlet extends HttpServlet {

    List<String> topics = Collections.synchronizedList(new ArrayList<String>());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String topic = req.getParameter("topic");
        System.out.println(topic);
        topics.add(topic);
        req.setAttribute("topics", topics);
        forward(req, resp);
    }

    private void forward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }

}
