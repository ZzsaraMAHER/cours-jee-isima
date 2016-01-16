package fr.tp.isima.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.tp.isima.services.MathOperators;

@WebServlet("/maths/multiplier")
public class ProduitServlet extends HttpServlet {

    private final CalculationDelegate calculationDelegate = CalculationDelegate.withDefaultParameterName(MathOperators.PRODUIT);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        calculationDelegate.doOperation(req, resp);
    }
}