package fr.tp.isima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.tp.isima.business.SessionUtilisation;
import fr.tp.isima.business.Utilisateurs;
import fr.tp.isima.listener.Keys;

@WebServlet("/displayStats")
public class DisplayStatsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Utilisateurs utilisateurs = (Utilisateurs) getServletContext().getAttribute(Keys.UTILISATEURS);
        final SessionUtilisation sessionUtilisation = (SessionUtilisation) req.getSession().getAttribute(Keys.SESSION_UTILISATION);

        req.setAttribute("stats", new StatsViewBean(utilisateurs, sessionUtilisation));
        req.getRequestDispatcher("/WEB-INF/jsp/stats.jsp").forward(req, resp);
    }
}
