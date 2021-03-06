package fr.cours.isima.business;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.NoResultException;

import com.google.common.base.Optional;

import fr.cours.isima.persistence.CategorieDao;

public class Categories {
    private final CategorieDao categoryDao;

    public Categories(CategorieDao categoryDao) {
        super();
        this.categoryDao = categoryDao;
    }

    /**
     * 
     * @return la liste de toutes les categories d'article
     */
    public List<Categorie> findAllCategories() {
        return categoryDao.findAllCategories().stream().map((categ) -> new Categorie(categoryDao, categ)).collect(Collectors.toList());
    }

    public Optional<Categorie> findCategoryById(long id) {
        try {
            return Optional.of(new Categorie(categoryDao, categoryDao.findById(id)));
        } catch (final NoResultException e) {
            return Optional.absent();
        }
    }
}
