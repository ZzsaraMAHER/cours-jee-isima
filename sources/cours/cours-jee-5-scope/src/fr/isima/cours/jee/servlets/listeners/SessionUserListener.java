package fr.isima.cours.jee.servlets.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import fr.isima.cours.jee.servlets.CompteurDemandeAffichageHeure;

@WebListener
public class SessionUserListener implements HttpSessionListener {

    public static final String COMPTEUR_HEURE_COURANTE = "compteur-heure-courante";

    @Override
    public void sessionCreated(HttpSessionEvent create) {
        final HttpSession session = create.getSession();
        System.out.println("Session create " + session.getId());
        session.setAttribute(COMPTEUR_HEURE_COURANTE, new CompteurDemandeAffichageHeure());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent hse) {
        final HttpSession session = hse.getSession();
        System.out.println("Fin de la session de l'utilisateur " + session.getId());
        final CompteurDemandeAffichageHeure compteur = (CompteurDemandeAffichageHeure) session.getAttribute(COMPTEUR_HEURE_COURANTE);
        System.out.println(compteur);
    }
}
