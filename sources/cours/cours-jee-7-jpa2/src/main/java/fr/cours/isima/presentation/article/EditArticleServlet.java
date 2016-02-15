package fr.cours.isima.presentation.article;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cours.isima.business.Article;
import fr.cours.isima.presentation.Form;
import fr.cours.isima.presentation.Page;

@WebServlet("/editArticle")
public class EditArticleServlet extends ArticlesServlet {

    @Override
    protected Page process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Article article = getArticles().findById(Long.parseLong(req.getParameter("id")));
        final ArticleViewBean articleViewBean = new ArticleViewBean(getArticles(), getCategories(), article);
        return forwardOnEdit().withForm(Form.successForm(articleViewBean)).build();
    }
}
