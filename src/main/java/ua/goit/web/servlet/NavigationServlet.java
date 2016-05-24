package ua.goit.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NavigationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String someImportantData = req.getParameter("someImportantData");
        System.out.println(someImportantData);
        String pageName = req.getParameter("pageName");
        resp.sendRedirect(pageName+".jsp");
    }
}
