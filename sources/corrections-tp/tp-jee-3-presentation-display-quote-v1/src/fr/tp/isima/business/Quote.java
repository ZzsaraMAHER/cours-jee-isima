package fr.tp.isima.business;

/**
 * L'objet immuable contenant les citations
 * 
 * @author Benjamin Kuchcik
 * @see Quotes
 */
public class Quote {

    /**
     * Le champ est final, il doit donc être initialisé dans le constructeur.
     * 
     */
    private final String author;

    private final String content;

    public Quote(String author, String content) {
        super();
        this.author = author;
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

}
