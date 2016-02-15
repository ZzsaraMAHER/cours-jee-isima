package fr.cours.isima.presentation.article;

import static fr.cours.isima.presentation.ErrorFields.newErrorBuilder;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.math.NumberUtils;

import com.google.common.base.Optional;

import fr.cours.isima.business.Article;
import fr.cours.isima.business.Categorie;
import fr.cours.isima.persistence.UniqueConstraintException;
import fr.cours.isima.presentation.ErrorFields;
import fr.cours.isima.presentation.Form;
import fr.cours.isima.presentation.Page;

@WebServlet({ "/saveArticle" })
public class SaveArticleServlet extends ArticlesServlet {

    @Override
    protected Page process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final long id = NumberUtils.toLong(req.getParameter("id"), -1);
        final Article article = findArticleById(id);
        final Optional<Categorie> optionalCategorie = getCategories().findCategoryById(NumberUtils.toLong(req.getParameter("category")));
        if (optionalCategorie.isPresent()) {
            final Categorie categorie = optionalCategorie.get();
            article.setCategory(categorie);
            article.setDescription(req.getParameter("description"));
            article.setReference(req.getParameter("reference"));
            try {
                // Lors de la sauvegarde on controle les champs
                article.save();
                return redirectOnListArticles(req).build();
            } catch (final ConstraintViolationException e) {
                return returnToEditPage(article, newErrorBuilder().addErrorWithUniqueContraintException(e).build());
            } catch (final UniqueConstraintException e) {
                return returnToEditPage(article, newErrorBuilder().addErrorWithUniqueContraintException(e).build());
            }
        }
        return returnToEditPage(article, newErrorBuilder().addField("category", "Il faut selectionner une catégorie").build());

    }

    private Page returnToEditPage(final Article article, final ErrorFields fields) {
        final ArticleViewBean artViewBean = new ArticleViewBean(getArticles(), getCategories(), article);
        final Form<ArticleViewBean> form = new Form<ArticleViewBean>(artViewBean, fields);

        return forwardOnEdit().withForm(form).build();
    }

    private Article findArticleById(long id) {
        if (id > 0) {
            return getArticles().findById(id);
        }
        return getArticles().createArticle();
    }
}
