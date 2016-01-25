package fr.isima.cours.jee.servlets;

import java.util.Properties;

import javax.servlet.http.HttpServlet;

import fr.isima.cours.jee.business.GenerateurHeureCourante;

abstract class AbstractServletWithGenerateurHeure extends HttpServlet {

    final protected GenerateurHeureCourante creerHeureCourante() {
        final Properties properties = (Properties) getServletContext().getAttribute("application-configuration");
        if (properties == null) {
            throw new IllegalStateException("Impossible de charger la configuration avec la cle application-configuration");
        }
        return new GenerateurHeureCourante(properties.getProperty("format.date.heure.courante"));
    }
}
