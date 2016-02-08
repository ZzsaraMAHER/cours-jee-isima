package fr.tp.isima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.tp.isima.business.Quotes;
import fr.tp.isima.business.SessionUtilisation;
import fr.tp.isima.listener.Keys;

abstract class AbstractDisplayQuoteServlet extends HttpServlet {

    // comme specifie dans le sujet, quotes est immuable
    private Quotes quotes;

    @Override
    final public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String quoteNumberUnparsed = req.getParameter("quoteNumber");

        final QuoteViewBean qvb = createQuoteViewBean(quoteNumberUnparsed);
        req.setAttribute("quote", qvb);
        doOperationOnQuote(req, resp, createQuoteViewBean(quoteNumberUnparsed));
        // on increment uniquement s'il n'y a pas d'erreur
        ((SessionUtilisation) req.getSession().getAttribute(Keys.SESSION_UTILISATION)).addAQuote();
    }

    protected abstract void doOperationOnQuote(HttpServletRequest req, HttpServletResponse resp, QuoteViewBean qvb) throws ServletException, IOException;

    final protected QuoteViewBean createQuoteViewBean(String quoteNumberUnparsed) {
        try {
            return QuoteViewBean.withNumero(quotes, Integer.parseInt(quoteNumberUnparsed));
        } catch (final NumberFormatException e) {
            e.printStackTrace();
            // par defaut on affiche la premier quote
            return QuoteViewBean.withNumero(quotes, 1);
        }
    }

    @Override
    public void init() throws ServletException {
        quotes = Quotes.createDefaultQuotes();
    }

}
