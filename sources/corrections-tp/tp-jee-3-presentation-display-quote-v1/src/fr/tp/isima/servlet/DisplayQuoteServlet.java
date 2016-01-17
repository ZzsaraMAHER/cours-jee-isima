package fr.tp.isima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.tp.isima.business.Quote;
import fr.tp.isima.business.Quotes;

@WebServlet("/displayQuote")
public class DisplayQuoteServlet extends HttpServlet {

    // comme specifie dans le sujet, quotes est immuable
    // il peut donc être utilisé comme attribut
    private Quotes quotes;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String quoteNumberUnparsed = req.getParameter("quoteNumber");

        req.setAttribute("quote", createQuoteViewBean(quoteNumberUnparsed));
        req.getRequestDispatcher("/quote.jsp").forward(req, resp);
    }

    private QuoteViewBean createQuoteViewBean(String quoteNumberUnparsed) {
        if (quoteNumberUnparsed == null) {
            return QuoteViewBean
                    .withExternalQuote(new Quote("L'auteur de l'application", "Vous devez fournir un numero de quote pour que je puisse l'afficher"));
        }
        try {
            return QuoteViewBean.withNumero(quotes, Integer.parseInt(quoteNumberUnparsed));
        } catch (final NumberFormatException e) {
            e.printStackTrace();
            return QuoteViewBean.withExternalQuote(new Quote("L'auteur de l'application", "Le parametre quoteNumber doit forcement etre un nombre"));
        }
    }

    @Override
    public void init() throws ServletException {
        quotes = Quotes.createDefaultQuotes();
    }
}
