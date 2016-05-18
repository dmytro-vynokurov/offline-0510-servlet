package ua.goit.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

public class LowercaseFilter implements Filter {

    private static final String QUERY_PARAMETER_NAME = "q";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String query = request.getParameter(QUERY_PARAMETER_NAME);
        final String lowerCase = query==null ? null : query.toLowerCase();
        HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper((HttpServletRequest) request){
            @Override
            public String getParameter(String name) {
                if(name!=null && name.equals(QUERY_PARAMETER_NAME)) return lowerCase;
                return super.getParameter(name);
            }
        };

        chain.doFilter(requestWrapper, response);
    }

    @Override
    public void destroy() {

    }
}
