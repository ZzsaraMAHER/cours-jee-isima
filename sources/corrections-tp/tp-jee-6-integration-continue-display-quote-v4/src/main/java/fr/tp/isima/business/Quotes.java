package fr.tp.isima.business;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import fr.tp.isima.entities.Quote;

public class Quotes {

    private final List<Quote> quotes;

    private Quotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public List<Quote> getQuotes() {
        return Collections.unmodifiableList(quotes);
    }

    public int size() {
        return quotes.size();
    }

    public SelectedQuote selectQuote(int numero) {
        if (numero > quotes.size() || numero <= 0) {
            return new SelectedQuote(this, createDefaultQuote(numero));
        }
        return new SelectedQuote(this, quotes.get(numero - 1));
    }

    public Quote findRandomQuote() {
        return quotes.get(ThreadLocalRandom.current().nextInt(quotes.size()));
    }

    private Quote createDefaultQuote(int numero) {
        return new Quote("L'auteur de l'application", "Aucune citation n'existe a ce numero " + numero);
    }

    public static Quotes createDefaultQuotes() {
        return new Quotes(Arrays.asList(
                new Quote("Georges Clemenceau",
                        "Un traître est un homme politique qui quitte son parti pour s'inscrire a un autre. Par contre, un converti est un homme politique qui quitte son parti pour s'inscrire au votre."),
                new Quote("Tristan Bernard", "Les hommes sont toujours sincères. Ils changent de sincérité, voilà tout."),
                new Quote("Woody Allen", "La vie est une maladie mortelle sexuellement transmissible."),
                new Quote("Woody Allen",
                        "Dans votre ascension professionnelle, soyez toujours très gentil pour ceux que vous dépassez en montant. Vous les retrouverez au même endroit en redescendant."),
                new Quote("Albert Einstein",
                        "Il y a deux choses d'infini au monde : l'univers et la bétise humaine....mais pour l'univers j'en suis pas très sûr. "),
                new Quote("Marcel Proust", "L'homme n'est pas fait pour travailler et la preuve, c'est que ça le fatigue. "),
                new Quote("Oscar Wilde",
                        "Il n'y a que deux sortes de gens attrayants ; ceux qui savent absolument tout et ceux qui ne savent absolument rien."),
                new Quote("François de La Rochefoucauld",
                        "Comme c'est le caractère des grands esprits de faire entendre en peu de paroles beaucoup de choses, les petits esprits au contraire ont le don de beaucoup parler, et de ne rien dire."),
                new Quote("Confucius", "Exige beaucoup de toi-même et attends peu des autres. Ainsi beaucoup d'ennuis te seront épargnés."),
                new Quote("Abraham Lincoln", "Aucun homme n'a assez de mémoire pour réussir dans le mensonge.")));
    }

    static Quotes createQuotes(Quote... quotes) {
        return new Quotes(Arrays.asList(quotes));
    }

    public static Quotes empty() {
        return new Quotes(Arrays.asList());
    }

}
