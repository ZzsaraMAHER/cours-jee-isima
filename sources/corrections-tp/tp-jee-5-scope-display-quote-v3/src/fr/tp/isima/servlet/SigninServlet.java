package fr.tp.isima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.tp.isima.business.Utilisateurs;
import fr.tp.isima.listener.Keys;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Utilisateurs utilisateurs = (Utilisateurs) getServletContext().getAttribute(Keys.UTILISATEURS);

        req.getSession().setAttribute(Keys.SESSION_UTILISATION, utilisateurs.findUtilisateurByName(req.getParameter("pseudo")).ouvrirSessionUtilisation());
        resp.sendRedirect(req.getContextPath() + "/displayMainPage?quoteNumber=1");
    }
}
