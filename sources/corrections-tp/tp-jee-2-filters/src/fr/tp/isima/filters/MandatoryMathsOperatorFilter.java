package fr.tp.isima.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Vérifie la présence ou non des parametres pour les opérations mathématiques
 * 
 * @author Benjamin Kuchcik
 *
 */
@WebFilter("/maths/*")
public class MandatoryMathsOperatorFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        final String a = req.getParameter("a");
        final String b = req.getParameter("b");
        if (a == null && b == null) {
            throw new ServletException("Membres a et b obligatoires");
        } else if (a == null) {
            throw new ServletException("Membre a obligatoire");
        } else if (b == null) {
            throw new ServletException("Membre b obligatoire");
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}
