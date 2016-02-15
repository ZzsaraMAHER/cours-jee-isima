package fr.tp.isima.servlet;

import javax.servlet.http.HttpServlet;

import fr.tp.isima.business.SessionUtilisation;
import fr.tp.isima.business.Utilisateurs;
import fr.tp.isima.listener.Keys;

public class AbstractWithSignServlet extends HttpServlet {

    final protected SessionUtilisation createSessionUtilisation(String nameOfUser) {
        final Utilisateurs utilisateurs = (Utilisateurs) getServletContext().getAttribute(Keys.UTILISATEURS);

        return utilisateurs.findUtilisateurByName(nameOfUser).ouvrirSessionUtilisation();
    }

}
