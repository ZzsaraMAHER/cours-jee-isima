package fr.cours.isima.presentation.article;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cours.isima.presentation.Page;

@WebServlet("/deleteArticle")
public class DeleteArticleServlet extends ArticlesServlet {

    @Override
    protected Page process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getArticles().deleteArticleById(Long.parseLong(req.getParameter("id")));
        return redirectOnListArticles(req).build();
    }

}
