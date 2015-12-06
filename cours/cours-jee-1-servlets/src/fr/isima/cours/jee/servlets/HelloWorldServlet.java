package fr.isima.cours.jee.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cette Servlet permet simplement d'afficher le texte Hello World !
 * 
 * <p>
 * Dans le mod�le <b>MVC</b>, le Servlet repr�sente le contr�leur. Il appelle le
 * mod�le pour executer un service, et � partir des donn�es retourn�es par le
 * mod�le renvoie vers la vue afin que les donn�es soit affich�es �
 * l'utilisateur.
 * </p>
 * <p>
 * L'annotation {@link WebServlet} permet de d�clarer au container (ex Tomcat,
 * Jboss ou Glassfish) l'existence de la Servlet. En effet le container, en
 * d�marrant, scanne les classes se trouvant dans le repertoire classes. S'il
 * trouve une annotation {@link WebServlet}, il l'ajoute comme service de
 * l'application. Une application contient donc une � plusieurs Servlet afin de
 * proposer des services.
 * </p>
 * <p>
 * Bien que {@link Servlet} soit une norme g�n�rique, la plupart des
 * applications n'utilisent que des {@link HttpServlet} ce qui sera notre cas
 * pendant tout le cours.
 * </p>
 * 
 * @author Benjamin Kuchcik
 *
 */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
    /**
     * 
     * <p>
     * Une Servlet est capable de lire toutes les methodes standard HTTP :
     * <ul>
     * <li>Get : {@link #doGet(HttpServletRequest, HttpServletResponse)}</li>
     * <li>Post : {@link #doPost(HttpServletRequest, HttpServletResponse)}</li>
     * <li>Head : {@link #doHead(HttpServletRequest, HttpServletResponse)}</li>
     * <li>Delete : {@link #doDelete(HttpServletRequest, HttpServletResponse)}</li>
     * <li>Put : {@link #doPut(HttpServletRequest, HttpServletResponse)}</li>
     * <li>Options : {@link #doOptions(HttpServletRequest, HttpServletResponse)}
     * </li>
     * <li>Trace : {@link #doTrace(HttpServletRequest, HttpServletResponse)}
     * </ul>
     * <p>
     * Pour notre cours nous ne red�finirons que les methodes
     * {@link #doGet(HttpServletRequest, HttpServletResponse)} et
     * {@link #doPost(HttpServletRequest, HttpServletResponse)}. Toutefois dans
     * le cadre d'une application REST par exemple, connaitre le protocole HTTP
     * peut-�tre interessant.
     * </p>
     * 
     * @param req
     *            represente sous forme d'objet les informations envoy�s par le
     *            client emetteur de la requ�te
     * @param resp
     *            permet de faciliter la cr�ation de la r�ponse HTTP. Le serveur
     *            peut donner des informations utiles au client sur la r�ponse �
     *            sa requ�te et en tout premier lieu le contenu de la r�ponse
     * @see http://www.wikiwand.com/fr/Hypertext_Transfer_Protocol pour le
     *      d�tail du protocole HTTP
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Hello world !");
    }
}
