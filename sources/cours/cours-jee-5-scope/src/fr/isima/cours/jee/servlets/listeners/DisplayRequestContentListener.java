package fr.isima.cours.jee.servlets.listeners;

import java.util.Enumeration;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class DisplayRequestContentListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.err.println("Ajout d'un attribut exemple, attribut-positionne pour l'url " + ((HttpServletRequest) sre.getServletRequest()).getRequestURI());
        sre.getServletRequest().setAttribute("attribut-postionne", "un attribut");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        final ServletRequest sr = sre.getServletRequest();
        System.err.println("Affichage des attributs de la request");
        final Enumeration<String> en = sr.getAttributeNames();
        while (en.hasMoreElements()) {
            final String key = en.nextElement();
            final Object val = sr.getAttribute(key);
            System.err.println("L'objet suivant est associe a la cle " + key + " : " + val);
        }
    }
}
