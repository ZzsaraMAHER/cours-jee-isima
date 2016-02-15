package fr.cours.isima.business;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.base.Preconditions;

import fr.cours.isima.persistence.ArticleBean;
import fr.cours.isima.persistence.ArticleDao;
import fr.cours.isima.persistence.CategorieDao;

/**
 * Cette classe de service permet d'accéder à l'ensemble des articles et
 * categories
 * 
 * @see ArticleDao
 * @see CategorieDao
 * 
 * @author Benjamin KUCHCIK
 * 
 */
public class Articles {

    private final ArticleDao articleDao;
    private final CategorieDao categoryDao;

    public Articles(ArticleDao articleDao, CategorieDao categoryDao) {
        Preconditions.checkNotNull(articleDao, "articleDao");
        Preconditions.checkNotNull(categoryDao, "categoryDao");
        this.articleDao = articleDao;
        this.categoryDao = categoryDao;

    }

    public Article createArticle() {
        final ArticleBean articleBean = new ArticleBean();
        return new Article(articleBean, articleDao, categoryDao);
    }

    /**
     * 
     * @return la liste de tous les articles disponibles
     */
    public List<Article> findAllArticles() {
        return articleDao.findAllArticles().stream().map(articleBean -> new Article(articleBean, articleDao, categoryDao)).collect(Collectors.toList());
    }

    public Article findById(long parseLong) {
        return new Article(articleDao.findById(parseLong), articleDao, categoryDao);
    }

    public void deleteArticleById(long id) {
        articleDao.delete(articleDao.findById(id));
    }

}
