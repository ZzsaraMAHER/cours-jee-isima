package fr.cours.isima.business;

import com.google.common.base.Preconditions;

import fr.cours.isima.persistence.ArticleBean;
import fr.cours.isima.persistence.ArticleDao;
import fr.cours.isima.persistence.CategorieDao;

/**
 * 
 * @author Benjamin
 *
 */
public class Article {

    private final ArticleBean articleBean;
    private final ArticleDao articleDao;
    private final CategorieDao categoryDao;

    public Article(ArticleBean articleBean, ArticleDao articleDao, CategorieDao categoryDao) {
        Preconditions.checkNotNull(articleDao, "articleDao");
        Preconditions.checkNotNull(articleBean, "articleBean");
        Preconditions.checkNotNull(categoryDao, "categoryDao");
        this.categoryDao = categoryDao;
        this.articleDao = articleDao;
        this.articleBean = articleBean;
    }

    public void setDescription(String descriptionArticle) {
        articleBean.setDescription(descriptionArticle);
    }

    public void setCategory(Categorie category) {
        articleBean.setCategory(category.getCategoryBean());
    }

    public void setReference(String reference) {
        articleBean.setReference(reference);
    }

    public String getReference() {
        return articleBean.getReference();
    }

    public String getDescription() {
        return articleBean.getDescription();
    }

    public Long getId() {
        return articleBean.getId();
    }

    public void save() {
        articleDao.save(articleBean);
    }

    public Categorie getCategory() {
        if (articleBean.getCategory() == null) {
            return null;
        }
        return new Categorie(categoryDao, articleBean.getCategory());
    }

    public boolean exists() {
        return articleBean.getId() > 0l;
    }

}
