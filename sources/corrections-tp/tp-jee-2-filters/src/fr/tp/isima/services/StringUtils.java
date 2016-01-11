package fr.tp.isima.services;

/**
 * Classe utilitaire pour la gestion de chaines de caractère.
 * 
 * A noter que les methodes sont fortement inspirées de la classe StringUtils
 * d'apache que nous serons amené à voir ultérieurement
 * 
 * @author Benjamin Kuchcik
 *
 */
public class StringUtils {

    private static final String EMPTY = "";

    /**
     * Les classes utilitaires (pattern utils) ne doivent pas être instanciées
     */
    private StringUtils() {

    }

    /**
     * Concatene les deux chaines si elles sont non null
     * 
     * Exemples :
     * <ul>
     * <li>a:null,b:null=>""</li>
     * <li>a:"a",b:null=>"a"</li>
     * <li>a:null,b:"b"=>"b"</li>
     * <li>a:"a",b:"b"=>"a b"</li>
     * </ul>
     * 
     * @param a
     *            la premiere chaine a concatener
     * @param b
     *            la seconde
     * @return la chaine concaténée telle que décrite dans la documentation
     */
    public static String concat(String a, String b) {
        if (a == null && b == null) {
            return EMPTY;
        } else if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }
        return a + " " + b;
    }

    /**
     * Retourne tout les éléments de la chaine passée en paramètre avant le
     * pattern
     * 
     * @param chain
     *            la chaine nullable
     * @param pattern
     *            le pattern à rechercher
     * @return la chaine sans la partie suivant la premiere occurence du
     *         pattern. Si le pattern n'est pas contenu dans la chaine, retourne
     *         la chaine entiere
     */
    public static String substringBefore(String chain, String pattern) {
        checkPattern(pattern);
        if (defaultString(chain).contains(pattern)) {
            return chain.substring(0, chain.indexOf(pattern));
        }
        return chain;
    }

    private static void checkPattern(String pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("Il faut obligatoirement définir un pattern");
        }
    }

    /**
     * Retire d'une chaine tous les éléments précédents le pattern (y compris le
     * pattern) ou la chaine vide si le pattern n'est pas contenu en parametre
     * 
     * @param chain
     *            la chaine nullable
     * @param pattern
     *            le pattern obligatoire
     * @return le contenu de la chaine débarassé de ce qui précéde le pattern ou
     *         la chaine "" si le pattern n'est pas dans la chaine en paramètre
     */
    public static String substringAfter(String chain, String pattern) {
        checkPattern(pattern);
        if (defaultString(chain).contains(pattern)) {
            return chain.substring(chain.indexOf(pattern) + pattern.length(), chain.length());
        }
        return EMPTY;
    }

    /**
     * Retourne une chaine par défaut si la chaine en entrée est null
     * 
     * @param str
     *            la chaine à tester
     * @return la chaine vide si la chaine en entrée est null ou la chaine en
     *         entree
     */
    public static String defaultString(String str) {
        return str == null ? EMPTY : str;
    }
}
