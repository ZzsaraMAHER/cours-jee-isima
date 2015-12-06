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
 * Dans le modèle <b>MVC</b>, le Servlet représente le contrôleur. Il appelle le
 * modèle pour executer un service, et à partir des données retournées par le
 * modèle renvoie vers la vue afin que les données soit affichées à
 * l'utilisateur.
 * </p>
 * <p>
 * L'annotation {@link WebServlet} permet de déclarer au container (ex Tomcat,
 * Jboss ou Glassfish) l'existence de la Servlet. En effet le container, en
 * démarrant, scanne les classes se trouvant dans le repertoire classes. S'il
 * trouve une annotation {@link WebServlet}, il l'ajoute comme service de
 * l'application. Une application contient donc une à plusieurs Servlet afin de
 * proposer des services.
 * </p>
 * <p>
 * Bien que {@link Servlet} soit une norme générique, la plupart des
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
     * Pour notre cours nous ne redéfinirons que les methodes
     * {@link #doGet(HttpServletRequest, HttpServletResponse)} et
     * {@link #doPost(HttpServletRequest, HttpServletResponse)}. Toutefois dans
     * le cadre d'une application REST par exemple, connaitre le protocole HTTP
     * peut-être interessant.
     * </p>
     * 
     * @param req
     *            represente sous forme d'objet les informations envoyés par le
     *            client emetteur de la requête
     * @param resp
     *            permet de faciliter la création de la réponse HTTP. Le serveur
     *            peut donner des informations utiles au client sur la réponse à
     *            sa requête et en tout premier lieu le contenu de la réponse
     * @see http://www.wikiwand.com/fr/Hypertext_Transfer_Protocol pour le
     *      détail du protocole HTTP
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Hello world !");
    }
}
