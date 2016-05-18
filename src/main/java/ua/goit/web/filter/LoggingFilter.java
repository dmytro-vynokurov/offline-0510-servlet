package ua.goit.web.filter;

import javax.servlet.*;
import java.io.IOException;

public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String query = request.getParameter("q");
        System.out.println("*************     request received with query "+query);
        chain.doFilter(request, response);
        System.out.println("*************     request processed with query "+query);
    }

    @Override
    public void destroy() {

    }
}
