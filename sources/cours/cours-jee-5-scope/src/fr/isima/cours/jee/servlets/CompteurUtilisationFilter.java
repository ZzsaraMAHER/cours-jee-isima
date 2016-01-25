package fr.isima.cours.jee.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import fr.isima.cours.jee.servlets.listeners.SessionUserListener;

@WebFilter("/heure/*")
public class CompteurUtilisationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        try {
            System.out.println("Debut du filtre de comptage des heures");
            chain.doFilter(req, resp);
        } finally {
            // Les evenements de creation de session n'arrivent qu'apres
            // l'execution des filtres
            // il faut donc incrementer le compteur qu'a posteriori
            // l'execution du final permet de s'assurer que cette instruction
            // n'est jamais oubliee
            final CompteurDemandeAffichageHeure compteur = findCompteurAffichageHeure(req);

            compteur.addDemande();
            System.out.println("Fin du filtre de comptage des heures");
        }
    }

    private CompteurDemandeAffichageHeure findCompteurAffichageHeure(ServletRequest req) {
        final HttpServletRequest httpReq = (HttpServletRequest) req;
        final CompteurDemandeAffichageHeure compteur = (CompteurDemandeAffichageHeure) httpReq.getSession().getAttribute(
                SessionUserListener.COMPTEUR_HEURE_COURANTE);
        // en cas d'arret relance du serveur le compteur peut-etre null
        if (compteur == null) {
            throw new NullPointerException(SessionUserListener.COMPTEUR_HEURE_COURANTE);
        }
        return compteur;
    }

    @Override
    public void init(FilterConfig conf) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
