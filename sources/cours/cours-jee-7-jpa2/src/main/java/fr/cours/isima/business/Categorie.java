package fr.cours.isima.business;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;

import fr.cours.isima.persistence.CategorieBean;
import fr.cours.isima.persistence.CategorieDao;

/**
 * La catégorie permet de regrouper les articles ( {@link Article}) rendant
 * possible l'affichage thématique
 * 
 * @author Benjamin
 *
 */
public class Categorie {

    private final CategorieBean categoryBean;
    private final CategorieDao categoryDao;

    Categorie(CategorieDao categoryDao, CategorieBean categoryBean) {
        this.categoryDao = categoryDao;
        Preconditions.checkNotNull(categoryBean);
        this.categoryBean = categoryBean;
    }

    public CategorieBean getCategoryBean() {
        return categoryBean;
    }

    public String getLibelle() {
        return categoryBean.getLibelle();
    }

    public long getId() {
        return categoryBean.getId();
    }

    public void save() {
        categoryDao.save(categoryBean);
    }

    @Override
    public int hashCode() {
        return HashCode.fromLong(categoryBean.getId()).asInt();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Categorie) {
            final Categorie that = (Categorie) obj;
            return Objects.equal(categoryBean.getId(), that.categoryBean.getId());
        }
        return false;
    }
}
