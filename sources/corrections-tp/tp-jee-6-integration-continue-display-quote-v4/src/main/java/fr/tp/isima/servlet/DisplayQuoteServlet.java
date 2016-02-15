package fr.tp.isima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/displayQuote")
public class DisplayQuoteServlet extends AbstractDisplayQuoteServlet {

    @Override
    protected void doOperationOnQuote(HttpServletRequest req, HttpServletResponse resp, QuoteViewBean qvb) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/quote.jsp").forward(req, resp);
    }
}
