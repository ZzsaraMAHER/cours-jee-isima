package fr.isima.cours.jee.servlets;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

public class CompteurDemandeAffichageHeure implements Serializable {

    private final AtomicLong nombreDeDemandeParIhm;

    public CompteurDemandeAffichageHeure() {
        nombreDeDemandeParIhm = new AtomicLong();
    }

    public void addDemande() {
        nombreDeDemandeParIhm.incrementAndGet();
    }

    public long getNombreDemande() {
        return nombreDeDemandeParIhm.get();
    }

    @Override
    public String toString() {
        return "Nombre de demande d'affichage de l'heure : " + getNombreDemande();
    }
}
