package fr.tp.isima.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.tp.isima.business.Utilisateurs;

/**
 * Initalise l'objet "utilisateurs" pour récolter les statistiques
 * 
 * @author Benjamin Kuchcik
 *
 */
@WebListener
public class InitialiserDisplayQuoteListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute(Keys.UTILISATEURS, new Utilisateurs());
    }

}
