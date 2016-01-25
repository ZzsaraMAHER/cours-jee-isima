package fr.isima.cours.jee.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.isima.cours.jee.business.GenerateurHeureCourante;

@WebServlet("/heure/GenererHeureFormatStandard")
public class GenererHeureFormatStandard extends AbstractServletWithGenerateurHeure {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final GenerateurHeureCourante generateurHeureCourante = creerHeureCourante();
        final HeureCouranteJSONSerializer serializer = new HeureCouranteJSONSerializer();
        serializer.serialize(generateurHeureCourante, response.getOutputStream());
    }
}
