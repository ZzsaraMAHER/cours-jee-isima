package fr.cours.isima.persistence;

import java.util.List;

public interface ArticleDao extends Dao<ArticleBean> {

    /**
     * 
     * @return la liste de tous les articles
     */
    List<ArticleBean> findAllArticles();

    /**
     * Sauvegarde l'article dans la couche persistance
     * 
     * @param articleBean
     */
    @Override
    void save(ArticleBean articleBean);

    /**
     * 
     * @param populatedBean
     */
    void delete(ArticleBean populatedBean);

}
