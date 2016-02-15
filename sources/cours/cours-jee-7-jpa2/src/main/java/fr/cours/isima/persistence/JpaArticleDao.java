package fr.cours.isima.persistence;

import java.util.List;

public class JpaArticleDao implements ArticleDao {

    private final EntityManagerExecutor entityManagerExecutor = new EntityManagerExecutor();

    @Override
    public List<ArticleBean> findAllArticles() {
        return entityManagerExecutor.execute(em -> em.createQuery("select a from Article a", ArticleBean.class).getResultList());
    }

    @Override
    public void save(ArticleBean articleBean) {
        if (articleBean.getId() > 0) {
            entityManagerExecutor.update(articleBean);
        } else {
            try {
                entityManagerExecutor.insert(articleBean);
            } catch (final RuntimeException e) {
                // On repasse l'id à zero sinon on ne pourra pas enregistrer la
                // valeur

                articleBean.setId(0);
                throw e;
            }
        }
    }

    @Override
    public ArticleBean findById(final long id) {
        return entityManagerExecutor.execute(em -> em.createQuery("select a from Article a where a.id='" + id + "'", ArticleBean.class).getSingleResult());
    }

    @Override
    public void delete(ArticleBean populatedBean) {
        entityManagerExecutor.delete(populatedBean);
    }

    @Override
    public Class<ArticleBean> getBeanClass() {
        return ArticleBean.class;
    }

    @Override
    public void deleteAll() {
        entityManagerExecutor.execute(em -> em.createQuery("delete from Article").executeUpdate());
    }
}
