package fr.tp.isima.servlets;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cette servlet correspond � la question 3 du TP, utilisant les lambdas. Il
 * permet de lister le contenu du WebContent, du moins la copie du contenu du
 * WebContent d�ploy�e sur le serveur Tomcat
 * 
 * <p>
 * Explication sur le WebContent : le WebContent contient l'ensemble des
 * ressources qui vont �tre d�ploy�es automatiquement par Eclipse.
 * </p>
 * <p>
 * En ajoutant un repertoire dans le WebContent, vous le verrez directement en
 * rappelant cette servlet (il faudra peut-�tre redemarr� le Tomcat, dans ce cas
 * l� dans votre vue serveur apr�s le Started, vous verrez un "Restart")
 * </p>
 * <p>
 * <b>Attention</b> il s'agit d'une copie. Ce qui est d�ploy� n'est pas le
 * WebContent que vous pouvez voir dans Eclipse sur votre projet. Si vous cr�ez
 * un fichier lors de l'execution de votre programme, en utilisant le
 * {@link ServletContext}, alors celui-ci ne sera pas visible dans le WebContent
 * de votre Eclipse. Vous pouvez surcharger la m�thode
 * {@link HttpServlet#init()} pour le v�rifier.
 * </p>
 * <ul>
 * Que se passe-t-il au moment du d�ploiement ?
 * <li>0�) Compilation des sources (WebContent/WEB-INF/classes)</li>
 * <li>1�) Au moment du d�ploiement sur le Tomcat (par exemple suite � un add
 * and remove project ou un changement dans un fichier), le contenu du
 * WebContent est copi� dans le repertoire de d�ploiement de Tomcat (que vous
 * avez red�fini lors du 1er TP)</li>
 * <li>2�) L'application est d�marr�e par le Tomcat.</li>
 * </ul>
 * 
 * @author Benjamin Kuchcik
 *
 */
@WebServlet("/listWebContent")
public class ListWebContentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final File webContent = new File(getServletContext().getRealPath("/"));

        // Listing des repertoire classiquement
        final File[] listOfDirectoriesAndFiles = webContent.listFiles((FilenameFilter) (dir, name) -> !"WEB-INF".equals(name) && !"META-INF".equals(name));

        // Utilisation des stream java8 pour convertir notre list de File ne
        // liste de nom
        // Cette ecriture est tres fluide

        // Il est impossible de faire en lambda la gestion des exceptions
        // verifiees
        // C'est un vrai probleme en java.
        // En decommantant ce code vous verrez que vous obtenez une erreur de
        // compilation
        // final Stream<String> names =
        // Arrays.stream(listOfDirectoriesAndFiles).map(t -> t.getName());
        // final Writer servletWriter = resp.getWriter();
        // names.forEach(t -> servletWriter.write(t + "<br/>"));
        // Contournons avec un simple StringBuilder
        // ce lien explique bien le probleme
        // http://blog.zenika.com/index.php?post/2014/02/19/Repenser-la-propagation-des-exceptions-avec-Java-8
        final StringBuilder sb = new StringBuilder();
        Arrays.stream(listOfDirectoriesAndFiles).filter((file) -> file.isDirectory()).forEach(file -> sb.append(file.getName()).append("\n"));

        resp.getWriter().write(sb.toString());

    }

}
