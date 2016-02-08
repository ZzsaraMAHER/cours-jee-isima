package fr.tp.isima.servlet;

import fr.tp.isima.business.SessionUtilisation;
import fr.tp.isima.business.Utilisateur;
import fr.tp.isima.business.Utilisateurs;

public class StatsViewBean {

    private final Utilisateurs utilisateurs;
    private final SessionUtilisation sessionUtilisation;

    public StatsViewBean(Utilisateurs utilisateurs, SessionUtilisation sessionUtilisation) {
        this.utilisateurs = utilisateurs;
        this.sessionUtilisation = sessionUtilisation;
    }

    public int getNombreSessionEnCours() {
        return getUtilisateur().getNombreSessionUtilisation();
    }

    private Utilisateur getUtilisateur() {
        return sessionUtilisation.getUtilisateur();
    }

    public int getNombreCitationVuPourLaSessionEnCours() {
        return sessionUtilisation.getNombreDeCitationVue();
    }

    public int getNombreCitationVuAuTotal() {
        return utilisateurs.getNombreCitationVuAuTotal();
    }

    public int getNombreDeCitationPourLUtilisateur() {
        return getUtilisateur().getNombreCitationVue();
    }

}
