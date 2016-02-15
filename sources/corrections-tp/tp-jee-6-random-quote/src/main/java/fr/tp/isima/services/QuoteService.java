package fr.tp.isima.services;

import fr.tp.isima.entities.Quote;

/**
 * Cette interface presente tous les services disponibles
 * 
 * @author Benjamin
 *
 */
public interface QuoteService {

    Quote findRandomQuote(String user);
}
