package fr.tp.isima.servlets;

import javax.servlet.annotation.WebServlet;

import fr.tp.isima.services.StringUtils;

/**
 * R�alise l'op�ration SubstringBefore en d�leguant �
 * {@link StringUtils#substringBefore(String, String)}
 * 
 * @author Benjamin Kuchcik
 * @see StringUtils
 * @see AbstractSubstringServlet
 */
@WebServlet("/strings/substringBefore")
public class SubstringBeforeServlet extends AbstractSubstringServlet {

    @Override
    protected String substring(String chain, String pattern) {
        return StringUtils.substringBefore(chain, pattern);
    }

}
