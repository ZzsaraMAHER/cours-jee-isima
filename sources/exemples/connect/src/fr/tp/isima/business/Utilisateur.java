package fr.tp.isima.business;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

/**
 * Represente un utilisateur connecte à l'application. Il n'a qu'un login, mais
 * il peut contenir toutes les informations que l'on souhaite. La classe
 * implemente bien entendu {@link Serializable}
 * 
 * @author Benjamin Kuchcik
 *
 */
public class Utilisateur implements Serializable {

    private final String login;

    /**
     * Cree un utilisateur
     * 
     * @param login,
     *            il sera "trimme"
     */
    public Utilisateur(String login) {
        if (StringUtils.isBlank(login)) {
            throw new IllegalArgumentException("Login must be filled");
        }
        this.login = StringUtils.trim(login);
    }

    public String getLogin() {
        return login;
    }

}
