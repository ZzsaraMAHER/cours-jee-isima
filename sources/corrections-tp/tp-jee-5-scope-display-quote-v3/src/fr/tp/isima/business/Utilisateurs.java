package fr.tp.isima.business;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * L'ensemble des utilisateurs de l'application.
 * 
 * Le stockage ne se faisant qu'en m�moire, un red�marrage fait perdre toutes
 * les donn�es
 * 
 * @author Benjamin
 *
 */
public class Utilisateurs {

    private final ConcurrentMap<String, Utilisateur> utilisateurs = new ConcurrentHashMap<String, Utilisateur>();

    private final AtomicInteger nombreTotalCitation = new AtomicInteger(0);

    /**
     * Trouve l'utilisateur ou le cr�e s'il n'existe pas
     * 
     * @param name
     * @return
     */
    public Utilisateur findUtilisateurByName(String name) {
        if (name == null) {
            throw new NullPointerException("name is null");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Le nom doit faire au moins trois caracteres " + name);
        }
        // on enleve les espaces
        final String trimmedName = name.trim();

        // La synchronisation est obligatoire pour s'assurer qu'il n'y ait pas
        // une double insertion
        if (utilisateurs.containsKey(trimmedName)) {
            return utilisateurs.get(trimmedName);
        }
        // Plutot que d'essayer de coder un check qui ne fonctionne pas ou mal,
        // il est preferable de se baser
        // sur putIfAbsent. Si deux utilisateurs sont crees en m�me temps, une
        // instance sera eliminee. La probabilite de cette evenement, et la
        // faiblesse du cout de creation d'un utilisateur
        // rend ce code efficace
        final Utilisateur utilisateur = new Utilisateur(trimmedName, Quotes.createDefaultQuotes(), this);

        utilisateurs.putIfAbsent(trimmedName, utilisateur);
        return utilisateurs.get(trimmedName);
    }

    public void incrementNombreCitationLu() {
        nombreTotalCitation.getAndIncrement();
    }

    public int getNombreCitationVuAuTotal() {
        return nombreTotalCitation.get();
    }
}
