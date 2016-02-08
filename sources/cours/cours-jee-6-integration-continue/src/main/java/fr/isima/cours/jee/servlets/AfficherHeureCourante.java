package fr.isima.cours.jee.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.isima.cours.jee.business.GenerateurHeureCourante;

@WebServlet("/AfficherHeureCourante")
public class AfficherHeureCourante extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Execution de la servlet AfficherHeureCourante");
        final GenerateurHeureCourante generateurHeureCourante = new GenerateurHeureCourante();
        request.setAttribute("currentDateAsString", generateurHeureCourante.nowWithStandardFormat());
        request.getRequestDispatcher("/heureCourante.jsp").forward(request, response);
    }
}
