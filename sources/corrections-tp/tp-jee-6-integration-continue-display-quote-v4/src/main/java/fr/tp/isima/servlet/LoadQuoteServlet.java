package fr.tp.isima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loadQuote")
public class LoadQuoteServlet extends AbstractDisplayQuoteServlet {
    @Override
    protected void doOperationOnQuote(HttpServletRequest req, HttpServletResponse resp, QuoteViewBean qvb) throws ServletException, IOException {
        new SelectedQuoteJsonSerializer().serialize(qvb.getSelectedQuote(), resp.getOutputStream());
    }
}
