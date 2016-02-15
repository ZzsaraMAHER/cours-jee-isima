package fr.cours.isima.persistence;

import java.util.List;

public class JpaCategoryDao implements CategorieDao {

    private final EntityManagerExecutor entityManagerExecutor = new EntityManagerExecutor();

    @Override
    public List<CategorieBean> findAllCategories() {
        return entityManagerExecutor.execute(entityManager -> entityManager.createQuery("select c from Categorie c", CategorieBean.class).getResultList());
    }

    @Override
    public CategorieBean findById(final long id) {
        return entityManagerExecutor.execute(entityManager -> entityManager.createQuery("select c from Categorie c where c.id='" + id + "'", CategorieBean.class)
                .getSingleResult());
    }

    @Override
    public void save(CategorieBean bean) {
        if (bean.getId() > 0) {
            entityManagerExecutor.update(bean);
        } else {
            entityManagerExecutor.insert(bean);
        }
    }

    @Override
    public Class<CategorieBean> getBeanClass() {
        return CategorieBean.class;
    }

    @Override
    public void deleteAll() {
        entityManagerExecutor.execute(em -> em.createQuery("delete from Categorie").executeUpdate());
    }

}
