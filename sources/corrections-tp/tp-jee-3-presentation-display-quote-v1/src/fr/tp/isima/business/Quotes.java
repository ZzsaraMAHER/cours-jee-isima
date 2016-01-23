package fr.tp.isima.business;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * L'objet pour g�rer les {@link Quote}
 * 
 * @author Benjamin Kuchcik
 *
 */
public class Quotes {

    /**
     * Les positions sont d�cal�es : le numero passe en parametre des m�thodes
     * ne correspond pas au rang dans a la liste
     */
    private static final int FIRST_QUOTE_RANGE = 1;
    private final List<Quote> quotes;

    private Quotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    /**
     * 
     * @return la liste non modifiable des {@link Quote}. Cela permet d'�viter
     *         qu'un process ext�rieur ne modifie la liste
     */
    public List<Quote> getQuotes() {
        return Collections.unmodifiableList(quotes);
    }

    public int size() {
        return quotes.size();
    }

    /**
     * La citation � la position pass� en parametre
     * 
     * @param numero
     * @return si la citation n'est pas bonne on cr�e une fausse citation
     * @see https://en.wikipedia.org/wiki/Null_Object_pattern
     */
    public Quote get(int numero) {
        if (numero > quotes.size() || numero < 0) {
            return createDefaultQuote(numero);
        }
        return quotes.get(numero - 1);
    }

    /**
     * Une citation par defaut
     * 
     * @param numero
     * @return
     */
    private Quote createDefaultQuote(int numero) {
        return new Quote("L'auteur de l'application", "Aucune citation n'existe a ce numero " + numero, true);
    }

    /**
     * Si la citation est la premiere
     * 
     * @param q
     * @return
     */
    public boolean isFirst(Quote q) {
        return externalPosition(q) == FIRST_QUOTE_RANGE;
    }

    private int indexOf(Quote q) {
        return quotes.indexOf(q);
    }

    public boolean isLast(Quote q) {
        return externalPosition(q) == quotes.size() && hasAtLeastTwoQuote();
    }

    public boolean hasPrevious(Quote q) {
        return externalPosition(q) > FIRST_QUOTE_RANGE && hasAtLeastTwoQuote();
    }

    public boolean hasNext(Quote q) {
        return externalPosition(q) < quotes.size() && hasAtLeastTwoQuote() && externalPosition(q) >= FIRST_QUOTE_RANGE;
    }

    boolean hasAtLeastTwoQuote() {
        return quotes.size() > 1;
    }

    public int previousIndex(Quote q) {
        return externalPosition(q) - 1;
    }

    private int externalPosition(Quote q) {
        // les citations sont ranges a partir de 1, alors que la liste a parttir
        // de 0
        return indexOf(q) + 1;
    }

    public int nextIndex(Quote q) {
        return externalPosition(q) + 1;
    }

    public boolean hasNotLast(Quote q) {
        return q.isDefaultQuote() || isLast(q);
    }

    public int firstIndex() {
        return FIRST_QUOTE_RANGE;
    }

    public int lastIndex() {
        return quotes.size();
    }

    public static Quotes createDefaultQuotes() {
        return new Quotes(Arrays.asList(
                new Quote("Georges Clemenceau",
                        "Un tra�tre est un homme politique qui quitte son parti pour s'inscrire a un autre. Par contre, un converti est un homme politique qui quitte son parti pour s'inscrire au votre."),
                new Quote("Tristan Bernard", "Les hommes sont toujours sinc�res. Ils changent de sinc�rit�, voil� tout."),
                new Quote("Woody Allen", "La vie est une maladie mortelle sexuellement transmissible."),
                new Quote("Woody Allen",
                        "Dans votre ascension professionnelle, soyez toujours tr�s gentil pour ceux que vous d�passez en montant. Vous les retrouverez au m�me endroit en redescendant."),
                new Quote("Albert Einstein",
                        "Il y a deux choses d'infini au monde : l'univers et la b�tise humaine....mais pour l'univers j'en suis pas tr�s s�r. "),
                new Quote("Marcel Proust", "L'homme n'est pas fait pour travailler et la preuve, c'est que �a le fatigue. "),
                new Quote("Oscar Wilde",
                        "Il n'y a que deux sortes de gens attrayants ; ceux qui savent absolument tout et ceux qui ne savent absolument rien."),
                new Quote("Fran�ois de La Rochefoucauld",
                        "Comme c'est le caract�re des grands esprits de faire entendre en peu de paroles beaucoup de choses, les petits esprits au contraire ont le don de beaucoup parler, et de ne rien dire.")));
    }

    static Quotes createQuotes(Quote... quotes) {
        return new Quotes(Arrays.asList(quotes));
    }

    public static Quotes empty() {
        return new Quotes(Arrays.asList());
    }

}
