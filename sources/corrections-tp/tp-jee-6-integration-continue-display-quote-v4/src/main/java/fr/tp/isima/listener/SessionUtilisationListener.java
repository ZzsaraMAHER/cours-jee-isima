package fr.tp.isima.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import fr.tp.isima.business.SessionUtilisation;

@WebListener
public class SessionUtilisationListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent arg0) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent hse) {
        final SessionUtilisation su = (SessionUtilisation) hse.getSession().getAttribute(Keys.SESSION_UTILISATION);
        if (su != null) {
            su.terminer();
        }
    }
}
