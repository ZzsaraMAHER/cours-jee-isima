package fr.cours.isima.presentation.article;

import fr.cours.isima.business.Article;
import fr.cours.isima.business.Categorie;

public class CategorieViewBean {

    private final Article article;

    private final Categorie category;

    CategorieViewBean(Article article, Categorie category) {
        super();
        this.article = article;
        this.category = category;
    }

    public boolean isSelected() {
        return category.equals(article.getCategory());
    }

    public String getLibelle() {
        return category.getLibelle();
    }

    public long getId() {
        return category.getId();
    }

}
