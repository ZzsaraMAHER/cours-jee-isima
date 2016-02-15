package fr.tp.isima.services;


public class QuoteServiceFailureException extends RuntimeException {

    public QuoteServiceFailureException(Throwable e) {
        super(e);
    }

}
