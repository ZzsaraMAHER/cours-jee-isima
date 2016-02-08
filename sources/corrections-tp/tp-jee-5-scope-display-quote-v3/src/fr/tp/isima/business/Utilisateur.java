package fr.tp.isima.business;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Un utilisateur est informé des consultations pour pouvoir incrementer son
 * nombre de citation
 * 
 * @author Benjamin Kuchcik
 *
 */
public class Utilisateur {

    private final String pseudonyme;
    private final Quotes quotes;

    /**
     * Ce compteur est incrementé uniquement lorsqu'une session d'utilisation se
     * termine
     */

    private final List<SessionUtilisation> sessionsUtilisations = new CopyOnWriteArrayList<SessionUtilisation>();
    private final AtomicInteger nombreTotalDeCitationEnregistree = new AtomicInteger();
    private final Utilisateurs utilisateurs;

    public Utilisateur(String pseudonyme, Quotes quotes, Utilisateurs utilisateurs) {
        this.pseudonyme = pseudonyme;
        this.quotes = quotes;
        this.utilisateurs = utilisateurs;
    }

    public String getPseudonyme() {
        return pseudonyme;
    }

    public Quotes getQuotes() {
        return quotes;
    }

    /**
     * Cree une nouvelle session d'utilisation, celle-ci est liee fortement a
     * l'utilisateur
     * 
     * @return la session d'utilisation
     */
    public SessionUtilisation ouvrirSessionUtilisation() {
        final SessionUtilisation su = new SessionUtilisation(this);
        sessionsUtilisations.add(su);
        return su;
    }

    /**
     * Appelé depuis la {@link SessionUtilisation#addAQuote()}. Il incrémente le
     * nombre de citation vu par l'utilisateur et appelle la methode
     * {@link Utilisateurs#incrementNombreCitationLu()} pour incrémenter les
     * citations de toute l'application
     */
    void incrementNombreCitationLu() {
        nombreTotalDeCitationEnregistree.incrementAndGet();
        utilisateurs.incrementNombreCitationLu();
    }

    void terminerSession(SessionUtilisation sessionUtilisation) {
        sessionsUtilisations.remove(sessionUtilisation);
    }

    public int getNombreSessionUtilisation() {
        return sessionsUtilisations.size();
    }

    public int getNombreCitationVue() {
        return nombreTotalDeCitationEnregistree.get();
    }
}
