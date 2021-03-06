package fr.tp.isima.filter;

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

import fr.tp.isima.business.SessionUtilisation;
import fr.tp.isima.listener.Keys;

/**
 * Controle de la bonne authentificaiton de l'utilisateur
 * 
 * @author Benjamin Kuchcik
 *
 */
@WebFilter("/*")
public class MustSigninFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        final HttpServletRequest httpReq = (HttpServletRequest) req;
        if (isAllowedCall(httpReq)) {
            chain.doFilter(req, resp);
        } else {
            final HttpServletResponse httpResp = (HttpServletResponse) resp;
            httpResp.sendRedirect(httpReq.getContextPath() + "/signin.jsp");
        }

    }

    private boolean isAllowedCall(final HttpServletRequest httpReq) {
        return isSigningRequest(httpReq) || isConnectedUser(httpReq) || isStaticRessource(httpReq);
    }

    private boolean isStaticRessource(HttpServletRequest httpReq) {
        return httpReq.getServletPath().endsWith(".css") || httpReq.getServletPath().equals(".js");
    }

    private boolean isConnectedUser(HttpServletRequest httpReq) {
        return httpReq.getSession().getAttribute(Keys.SESSION_UTILISATION) instanceof SessionUtilisation;
    }

    private boolean isSigningRequest(HttpServletRequest httpReq) {
        return httpReq.getServletPath().equals("/signin") || httpReq.getServletPath().equals("/signin.jsp");
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}
