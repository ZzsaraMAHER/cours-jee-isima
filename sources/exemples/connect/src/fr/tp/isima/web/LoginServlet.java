package fr.tp.isima.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import fr.tp.isima.business.Utilisateur;

/**
 * Cette classe permet de démarrer une authentification
 * 
 * @author Benjamin Kuchcik
 *
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String login = req.getParameter("login");
        if (StringUtils.isBlank(login)) {
            req.setAttribute("error-message", "Le login est obligatoire");
            req.getRequestDispatcher(req.getContextPath() + "/login.jsp").forward(req, resp);
        } else {
            // La session utilisateur est gérée automatiquement par le serveur
            // Nous ne nous preoccupons pas de sa gestion ou de son
            // instanciation
            // Techniquement un cookie contient un JSESSION_ID, identifiant
            // qui est envoyé à chaque requete utilisateur et est initalisé la
            // premiere
            // fois que le client appele une page sur notre serveur
            // d'application

            final HttpSession session = req.getSession();
            // on affiche l'id de la session, celui-la meme qui est dans le
            // jsession id
            System.out.println("JSESSION_ID " + session.getId());
            // on peut afficher egalement le cookie qui se trouve dans la
            // requête http
            System.out.println("Cookie " + req.getHeader("Cookie"));

            session.setAttribute(Keys.SESSION_UTILISATION, new Utilisateur(login));
            // le redirect à l'avantage d'éviter les F5 et les renvoies de
            // formulaires
            // toutefois il ne fonctionne pas sur les pages dans WEB-INF (c'est
            // le
            // client qui va appeler la page, et bien sur il n'a pas acces au
            // jsp de WEB-INF
            resp.sendRedirect(req.getContextPath() + "/youAreLogin");
        }
    }
}
