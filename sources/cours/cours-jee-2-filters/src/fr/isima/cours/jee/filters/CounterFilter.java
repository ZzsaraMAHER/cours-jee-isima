package fr.isima.cours.jee.filters;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Filtre permettant de compter le nombre de requ�te.
 * <p>
 * A noter que l'utilisation de {@link System#out} est g�n�ralement interdite
 * dans les projets en production, et que les informations de ce type sont
 * �crites par exemple dans des fichiers de logs.
 * </p>
 * 
 * @author Benjamin
 *
 */
@WebFilter("/*")
public class CounterFilter implements Filter {

    private AtomicLong counter;

    @Override
    public void doFilter(ServletRequest req, ServletResponse rep, FilterChain chain) throws IOException, ServletException {

        System.out.println("Nombre de requete " + counter.incrementAndGet());
        chain.doFilter(req, rep);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        counter = new AtomicLong(0);
    }

    @Override
    public void destroy() {
    }

}
