package fr.cours.isima.fill.database;

import fr.cours.isima.common.ApplicationsObjects;
import fr.cours.isima.persistence.ArticleDao;
import fr.cours.isima.persistence.CategorieBean;
import fr.cours.isima.persistence.CategorieDao;

/**
 * Cette classe peut etre utiliser pour reinitialiser la base de donnes et en
 * creer une novuelles
 * 
 * @author Benjamin
 *
 */
public class FillDataBase {

    public static void main(String[] args) {
        final ApplicationsObjects objects = ApplicationsObjects.loadAll();

        // On nettoie la base
        objects.get(ArticleDao.class).deleteAll();
        final CategorieDao categoryDao = objects.get(CategorieDao.class);
        categoryDao.deleteAll();

        // Creation d'une categorie livres
        final CategorieBean livres = new CategorieBean();
        livres.setId(1);
        livres.setLibelle("Livres");
        categoryDao.save(livres);

        // Creatop, d'une cateogires cds
        final CategorieBean cds = new CategorieBean();
        cds.setId(2);
        cds.setLibelle("Cds");
        categoryDao.save(cds);
    }
}
