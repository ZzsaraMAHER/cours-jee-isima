package fr.tp.isima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.tp.isima.listener.Keys;

@WebServlet("/signin")
public class SigninServlet extends AbstractWithSignServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute(Keys.SESSION_UTILISATION, createSessionUtilisation(req.getParameter("pseudo")));
        resp.sendRedirect(req.getContextPath() + "/displayMainPage?quoteNumber=1");
    }
}
