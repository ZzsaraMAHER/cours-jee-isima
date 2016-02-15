package fr.cours.isima.presentation.article;

import javax.servlet.http.HttpServletRequest;

import fr.cours.isima.business.Articles;
import fr.cours.isima.business.Categories;
import fr.cours.isima.presentation.NavigableServlet;
import fr.cours.isima.presentation.Page;
import fr.cours.isima.presentation.Page.PageBuilder;

abstract class ArticlesServlet extends NavigableServlet {

    final protected Articles getArticles() {
        return getApplicationObjects().get(Articles.class);
    }

    final protected Categories getCategories() {
        return getApplicationObjects().get(Categories.class);
    }

    protected final PageBuilder forwardOnEdit() {
        return Page.forwardOn("/jsp/editArticle.jsp");
    }

    protected final PageBuilder redirectOnListArticles(HttpServletRequest req) {
        return Page.redirectOn(req.getContextPath() + "/listArticles");
    }

    protected final PageBuilder forwardOnList() {
        return Page.forwardOn("/jsp/listArticles.jsp");
    }
}
