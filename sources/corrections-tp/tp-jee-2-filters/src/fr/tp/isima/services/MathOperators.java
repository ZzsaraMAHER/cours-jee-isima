package fr.tp.isima.services;

/**
 * Les différents opérateurs pour appliquer les calculs sur les Servlets.
 * 
 * L'exemple vous permet de voir un interet de l'enum en Java (pattern State)
 * qui permet de modéliser un nombre fini d'états, uniques, et de leur adjoindre
 * des comportements.
 * 
 * @author Benjamin Kuchcik
 *
 */
public enum MathOperators {
    PLUS {
        @Override
        public double apply(double left, double right) {
            return left + right;
        }
    },
    MOINS {
        @Override
        public double apply(double left, double right) {
            return left - right;
        }
    },
    PRODUIT {
        @Override
        public double apply(double left, double right) {
            return left * right;
        }
    },
    DIVISION {
        @Override
        public double apply(double left, double right) {
            return left / right;
        }
    };

    public abstract double apply(double left, double right);

}
