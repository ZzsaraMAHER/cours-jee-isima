package fr.cours.isima.persistence;

import java.util.List;

public interface CategorieDao extends Dao<CategorieBean> {

    List<CategorieBean> findAllCategories();

}
