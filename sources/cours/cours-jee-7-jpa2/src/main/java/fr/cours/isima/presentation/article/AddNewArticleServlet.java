package fr.cours.isima.presentation.article;

import static fr.cours.isima.presentation.Form.successForm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cours.isima.business.Article;
import fr.cours.isima.business.Articles;
import fr.cours.isima.presentation.Form;
import fr.cours.isima.presentation.Page;

@WebServlet("/addNewArticle")
public class AddNewArticleServlet extends ArticlesServlet {

    @Override
    protected Page process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Articles articles = getArticles();
        final Article article = articles.createArticle();
        final Form<ArticleViewBean> formViewBean = successForm(new ArticleViewBean(articles, getCategories(), article));

        // Un petit moyen d'encapsuler
        return forwardOnEdit().withForm(formViewBean).build();
    }

}
