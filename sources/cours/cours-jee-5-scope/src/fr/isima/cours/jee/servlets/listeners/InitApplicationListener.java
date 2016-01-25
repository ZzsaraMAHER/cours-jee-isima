package fr.isima.cours.jee.servlets.listeners;

import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitApplicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final Properties props = new Properties();
        try {
            props.load(InitApplicationListener.class.getResourceAsStream("/conf/application.properties"));
        } catch (final Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to start application. Can't read application.properties file " + e.getMessage(), e);
        }
        sce.getServletContext().setAttribute("application-configuration", props);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
