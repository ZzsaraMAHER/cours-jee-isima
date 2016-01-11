package fr.tp.isima.servlets;

import java.io.IOException;
import java.text.NumberFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.tp.isima.services.MathOperators;

/**
 * Cette classe est un exemple simple de pattern delegation. Cette méthode est
 * souvent préférée à l'héritage pour de nombreuses raisons :
 * <ul>
 * <li>Pour sa souplesse, on ne lie pas une classe à un héritier (que se
 * passe-t-il quand on a besoin de plusieurs services puisque Java ne permet pas
 * l'héritage multiple ?)</li>
 * <li>Très compatible avec containers (Spring ou CDI) qui injectent les objets
 * dans les champs</li>
 * </ul>
 * 
 * @author Benjamin Kuchcik
 * @see DivisionServlet
 * @see MoinsServlet
 * @see PlusServlet
 * @see ProduitServlet
 */
class CalculationDelegate {

    private static final String DEFAULT_LEFT_PARAMETER_NAME = "a";

    private static final String DEFAULT_RIGHT_PARAMETER_NAME = "b";

    private final String leftParameterName;

    private final String rightParameterName;

    private final MathOperators operator;

    public CalculationDelegate(String leftParameterName, String rightParameterName, MathOperators operator) {
        this.leftParameterName = leftParameterName;
        this.rightParameterName = rightParameterName;
        this.operator = operator;
    }

    public void doOperation(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String leftValue = request.getParameter(leftParameterName);
        final String rightValue = request.getParameter(rightParameterName);
        final NumberFormat number = NumberFormat.getInstance();
        number.setMaximumFractionDigits(4);
        response.getWriter().write(number.format(operator.apply(Double.parseDouble(leftValue), Double.parseDouble(rightValue))));
    }

    public static CalculationDelegate withDefaultParameterName(MathOperators operator) {
        return new CalculationDelegate(DEFAULT_LEFT_PARAMETER_NAME, DEFAULT_RIGHT_PARAMETER_NAME, operator);
    }

}
