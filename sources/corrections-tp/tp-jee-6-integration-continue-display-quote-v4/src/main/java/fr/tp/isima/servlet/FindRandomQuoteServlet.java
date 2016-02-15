package fr.tp.isima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fr.tp.isima.business.SessionUtilisation;
import fr.tp.isima.entities.Quote;

@WebServlet("/service/findRandomQuote")
public class FindRandomQuoteServlet extends AbstractWithSignServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String userName = req.getParameter("name");
        final SessionUtilisation session = createSessionUtilisation(userName);
        final Quote q = session.findRandomQuote();
        final Gson gson = new Gson();
        resp.getWriter().write(gson.toJson(q));
    }
}
