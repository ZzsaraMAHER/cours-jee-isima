package fr.tp.isima.business;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represente une session d'utilisation.
 * <p>
 * Un {@link Utilisateur} peut avoir plusieurs sessions d'utilisation en même
 * temps. La session d'utilisation est donc relier à un utilisateur. L'objet
 * permet de compter, le nombre de citation vu dans la session d'utilisation en
 * cours.
 * </p>
 * 
 * @author Benjamin Kuchcik
 *
 */
public class SessionUtilisation {

    /**
     * L'utilisateur utilisant utilisé pour se connecter à cette session
     */
    private final Utilisateur utilisateur;

    /**
     * Le nombre de citation vu pour cette session
     */
    private final AtomicInteger nombreDeCitation = new AtomicInteger();

    public SessionUtilisation(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public int getNombreDeCitationVue() {
        return nombreDeCitation.get();
    }

    /**
     * Permet d'ajouter une quote à la session d'utilisation. Appel la methode d
     * {@link Utilisateur} pour pouvoir incrémenter le nombre de citation vu par
     * l'utilisateur.
     * 
     * @see Utilisateur#incrementNombreCitationLu()
     */
    public void addAQuote() {
        nombreDeCitation.incrementAndGet();
        utilisateur.incrementNombreCitationLu();
    }

    public void terminer() {
        utilisateur.terminerSession(this);
    }

}
