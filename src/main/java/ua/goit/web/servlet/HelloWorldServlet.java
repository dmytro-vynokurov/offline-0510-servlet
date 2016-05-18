package ua.goit.web.servlet;

import ua.goit.service.SearchingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class HelloWorldServlet extends HttpServlet {

    SearchingService searchingService = new SearchingService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("q");

        List<String> url = searchingService.search(query);
        String urlsAsJson = convertToJson(url);


        PrintWriter writer = resp.getWriter();
        writer.print(urlsAsJson);

        resp.addHeader("Content-Type","application/json");
        resp.setHeader("Character-Encoding", "UTF-8");
    }

    private String convertToJson(List<String> url) {
        return url.toString();
    }

}
