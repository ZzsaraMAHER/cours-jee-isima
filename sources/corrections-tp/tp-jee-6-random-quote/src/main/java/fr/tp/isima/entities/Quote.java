package fr.tp.isima.entities;

public class Quote {
    private String author;

    private String content;

    // Ajout d'un constructeur vide pour permettre la deserialisation
    public Quote() {

    }

    public Quote(String auteur, String contenu) {
        super();
        author = auteur;
        content = contenu;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
