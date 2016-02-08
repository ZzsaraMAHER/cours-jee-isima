package fr.tp.isima.servlet;

import java.io.OutputStream;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

import fr.tp.isima.business.SelectedQuote;

/**
 * Classe permettant de transformer l'objet selectedQuote en chain de caractere
 * Json.
 * 
 * Nous utilisons l'API de serialisation de Json de JEE.
 * 
 * @author Benjamin
 *
 */
public class SelectedQuoteJsonSerializer {

    public void serialize(SelectedQuote selectedQuote, OutputStream os) {
        final JsonObjectBuilder job = Json.createObjectBuilder().add("author", selectedQuote.getQuote().getAuthor()).add("content",
                selectedQuote.getQuote().getContent());
        final JsonArrayBuilder jab = Json.createArrayBuilder();
        job.add("number", selectedQuote.getNumber());
        selectedQuote.getDirections().
                // ajout des 4 directions en json
                forEach((direction) -> jab.add(Json.createObjectBuilder().add("id", direction.getId())
                        // le bouton a ciblier
                        .add("targetLabel", direction.getTargetLabel())
                        // precise si le bouton est actif ou non
                        .add("targetIndex", direction.getIndexOfDirection()).add("enabled", direction.isEnabled())));

        job.add("directions", jab.build());

        Json.createWriter(os).writeObject(job.build());
    }
}
