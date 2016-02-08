package fr.isima.cours.jee.servlets;

import java.io.OutputStream;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

import fr.isima.cours.jee.business.GenerateurHeureCourante;

public class HeureCouranteJSONSerializer {

    public void serialize(GenerateurHeureCourante generateurHeureCourante, OutputStream outputStream) {
        final JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("date", generateurHeureCourante.nowWithStandardFormat());
        Json.createWriter(outputStream).writeObject(job.build());
    }

}
