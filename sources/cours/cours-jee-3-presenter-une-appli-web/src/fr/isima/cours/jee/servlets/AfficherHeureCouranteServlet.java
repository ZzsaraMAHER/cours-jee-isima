package fr.isima.cours.jee.servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AfficherHeureCourante")
public class AfficherHeureCouranteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final DateTimeFormatter formatteur = DateTimeFormatter.ofPattern("HH:mm:ss 'le' dd/MM/yyyy");
        final String currentDateAsString = formatteur.format(LocalDateTime.now());
        request.setAttribute("currentDateAsString", currentDateAsString);
        request.getRequestDispatcher("/heureCourante.jsp").forward(request, response);
    }
}
