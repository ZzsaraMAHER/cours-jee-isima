package fr.isima.cours.jee.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.isima.cours.jee.business.GenerateurHeureCourante;

@WebServlet("/GenererHeureFormatStandard")
public class GenererHeureFormatStandard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final GenerateurHeureCourante generateurHeureCourante = new GenerateurHeureCourante();
        final HeureCouranteJSONSerializer serializer = new HeureCouranteJSONSerializer();
        serializer.serialize(generateurHeureCourante, response.getOutputStream());
    }
}
