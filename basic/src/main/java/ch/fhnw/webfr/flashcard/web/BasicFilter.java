package ch.fhnw.webfr.flashcard.web;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by benjamin on 23.09.2015.
 */
@WebFilter("*")
public class BasicFilter implements Filter {
    private Logger logger = Logger.getLogger(BasicFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("init() called");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        StringBuffer buffer = new StringBuffer();
        buffer.append("Before request [uri=");
        buffer.append(httpRequest.getRequestURI());
        buffer.append("]");
        logger.debug(buffer.toString());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.debug("destroy() called");
    }
}
