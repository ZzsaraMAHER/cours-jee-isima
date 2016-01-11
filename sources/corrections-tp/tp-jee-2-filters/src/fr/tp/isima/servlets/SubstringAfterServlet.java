package fr.tp.isima.servlets;

import javax.servlet.annotation.WebServlet;

import fr.tp.isima.services.StringUtils;

/**
 * R�alise l'op�ration SubstringAfter en d�leguant �
 * {@link StringUtils#substringAfter(String, String)}
 * 
 * @author Benjamin Kuchcik
 * @see StringUtils
 * @see AbstractSubstringServlet
 */
@WebServlet("/strings/substringAfter")
public class SubstringAfterServlet extends AbstractSubstringServlet {

    @Override
    protected String substring(String chain, String pattern) {
        return StringUtils.substringAfter(chain, pattern);
    }

}
