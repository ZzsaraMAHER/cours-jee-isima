package fr.tp.isima.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cette classe est implémentée par, les classes réalisant les opérations sur la
 * chaines.
 * 
 * <p>
 * L'héritage est un méthode permettant de mutualiser du code
 * </p>
 * 
 * @author Benjamin
 * @see SubstringAfterServlet
 * @see SubstringBeforeServlet
 *
 */
public abstract class AbstractSubstringServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(substring(req.getParameter("chain"), req.getParameter("pattern")));
    }

    abstract protected String substring(String chain, String pattern);
}
