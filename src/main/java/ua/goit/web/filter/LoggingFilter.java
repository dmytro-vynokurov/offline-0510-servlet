package ua.goit.web.filter;

import javax.servlet.*;
import java.io.IOException;

public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("*************     request received with parameters "+request.getParameterMap().keySet());
        chain.doFilter(request, response);
        System.out.println("*************     request processed with parameters "+request.getParameterMap().keySet());
    }

    @Override
    public void destroy() {

    }
}
