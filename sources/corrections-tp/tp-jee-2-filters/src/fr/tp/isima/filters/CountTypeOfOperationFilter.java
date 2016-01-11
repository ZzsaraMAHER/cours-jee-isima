package fr.tp.isima.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import fr.tp.isima.services.OperationCounter;

/**
 * Compte les requêtes en fonction de leur type (math ou chaine)
 * 
 * @author Benjamin Kuchcik
 *
 */
public class CountTypeOfOperationFilter implements Filter {
    private OperationCounter operationCounter;

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest httpReq = (HttpServletRequest) request;
        System.out.println(operationCounter.countRequest(httpReq.getServletPath()));
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        operationCounter = new OperationCounter();
    }

}
