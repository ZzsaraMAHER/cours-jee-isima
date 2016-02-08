package fr.tp.isima.servlet;

import java.util.List;

import fr.tp.isima.business.Quote;
import fr.tp.isima.business.Quotes;
import fr.tp.isima.business.SelectedQuote;
import fr.tp.isima.business.SelectedQuote.Direction;

/**
 * Le choix d'utiliser une classe dite ViewBean permet de faire un code plus
 * leger facilement utilisable dans un EL
 * 
 * @author Benjamin
 *
 */
public class QuoteViewBean {

    private final SelectedQuote sq;

    private QuoteViewBean(SelectedQuote sq) {
        this.sq = sq;
    }

    public Quote getQuote() {
        return sq.getQuote();
    }

    public boolean isHasNext() {
        return sq.getNextDirection().isEnabled();
    }

    public boolean isHasPrevious() {
        return sq.getPreviousDirection().isEnabled();
    }

    public boolean isNotFirst() {
        return sq.isNotFirst();
    }

    public boolean isNotLast() {
        return sq.isNotLast();
    }

    public int getPreviousIndex() {
        return sq.getPreviousDirection().getIndexOfDirection();
    }

    public int getNextIndex() {
        return sq.getNextDirection().getIndexOfDirection();
    }

    public int getFirstIndex() {
        return sq.getFirstDirection().getIndexOfDirection();
    }

    public int getLastIndex() {
        return sq.getLastDirection().getIndexOfDirection();
    }

    public String getAuthor() {
        return sq.getQuote().getAuthor();
    }

    public String getContent() {
        return sq.getQuote().getContent();
    }

    public int getNumber() {
        return sq.getNumber();
    }

    public List<Direction> getDirections() {
        return sq.getDirections();
    }

    public static QuoteViewBean withNumero(Quotes quotes, int numero) {
        return new QuoteViewBean(quotes.selectQuote(numero));
    }

    public static QuoteViewBean withExternalQuote(Quote quote) {
        return new QuoteViewBean(new SelectedQuote(Quotes.empty(), quote));
    }

    public SelectedQuote getSelectedQuote() {
        return sq;
    }

}
