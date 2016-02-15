package fr.cours.isima.presentation.article;

import java.util.List;
import java.util.stream.Collectors;

import fr.cours.isima.business.Article;
import fr.cours.isima.business.Articles;
import fr.cours.isima.business.Categories;
import fr.cours.isima.business.Categorie;

/**
 * Le view bean facilite l'affichage et permet d'aider a creer des jsp plus
 * simples et plus coherentes
 * 
 * @author Benjamin
 *
 */
public class ArticleViewBean {

    private final Articles articles;

    private final Article article;

    private final Categories categories;

    public ArticleViewBean(Articles articles, Categories categories, Article article) {
        this.articles = articles;
        this.categories = categories;
        this.article = article;
    }

    public String getReference() {
        return article.getReference();
    }

    public String getDescription() {
        return article.getDescription();
    }

    public Long getId() {
        return article.getId();
    }

    public Categorie getCategory() {
        return article.getCategory();
    }

    public List<CategorieViewBean> getAllCategories() {
        return categories.findAllCategories().stream().map((c) -> new CategorieViewBean(article, c)).collect(Collectors.toList());
    }

}
