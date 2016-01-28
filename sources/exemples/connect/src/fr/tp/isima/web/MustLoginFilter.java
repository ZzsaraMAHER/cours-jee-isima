package fr.tp.isima.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.tp.isima.business.Utilisateur;

/**
 * Ce filtre est appelé systématique, et ceux même quand on appelle la page
 * login.jsp.
 * 
 * <p>
 * Il intercepte donc toutes les requêtes. Il y'a 3 cas
 * <ul>
 * <li>Le client appelle une URL necessitant une authentification mais n'est pas
 * autentifier, on le redirige alors vers la page de login</li>
 * <li>Le client appelle une URL publique, on autorise alors l'appel</li>
 * <li>Le client est authentifie, on autorise tous les appels</li>
 * </p>
 * 
 * @author Benjamin Kuchcik
 *
 */
@WebFilter("/*")
public class MustLoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        final HttpServletRequest httpReq = (HttpServletRequest) req;
        // si l'utilisateur est connecte ou bien la ressource publique (soit
        // toujours autorisée)
        // on laisse passer la requete
        if (isUserConnected(httpReq) || isPublicRessource(httpReq)) {
            chain.doFilter(req, resp);
        } else {
            // dans le cas contraire on redirige vers la page de login pour
            // forcer l'utilisateur
            // à se reconnecter
            final HttpServletResponse httpResp = (HttpServletResponse) resp;
            httpResp.sendRedirect(httpReq.getContextPath() + "/login.jsp");
        }

    }

    /**
     * Les ressources publiques sont soit les js/css soit les pages permettant
     * de s'authentifier
     * 
     * @param httpReq
     * @return
     */
    private boolean isPublicRessource(HttpServletRequest httpReq) {
        return httpReq.getServletPath().endsWith(".css") || httpReq.getServletPath().equals(".js") || isLoginRequest(httpReq);
    }

    private boolean isLoginRequest(HttpServletRequest httpReq) {
        return httpReq.getServletPath().equals("/login") || httpReq.getServletPath().equals("/login.jsp");
    }

    /**
     * Pour tester si l'utilisateur est connecté, nous vérifions en
     * {@link HttpSession} si l'utilisateur a bien été positionné par la
     * {@link LoginServlet}
     * 
     * @param httpReq
     * @return
     */
    private boolean isUserConnected(HttpServletRequest httpReq) {
        // instanceof test la nullite est en même temps vérifie le type de
        // l'objet !
        return httpReq.getSession().getAttribute(Keys.SESSION_UTILISATION) instanceof Utilisateur;
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}
