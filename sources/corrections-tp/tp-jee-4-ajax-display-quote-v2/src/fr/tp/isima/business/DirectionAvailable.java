package fr.tp.isima.business;

/**
 * Permet de test si la direction est disponible. Une direction est forcément
 * parmis la liste des {@link NavigationDirection}.
 * 
 * <p>
 * L'utilisation de cette interface à une méthode permet de créer des lambas
 * exploités dans {@link Direction}
 * </p>
 * 
 * @author Benjamin Kuchcik
 *
 */
public interface DirectionAvailable {
    /**
     * Si la direction est active pour la quote
     * 
     * @param sq
     * @return
     */
    boolean isEnabled();
}
