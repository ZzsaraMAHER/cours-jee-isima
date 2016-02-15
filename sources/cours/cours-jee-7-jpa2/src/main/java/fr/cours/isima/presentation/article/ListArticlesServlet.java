package fr.cours.isima.presentation.article;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cours.isima.presentation.Page;

@WebServlet(urlPatterns = { "/listArticles", "/index.html" })
public class ListArticlesServlet extends ArticlesServlet {

    @Override
    protected Page process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return forwardOnList().withBean("articles", getArticles().findAllArticles()).build();
    }

}
