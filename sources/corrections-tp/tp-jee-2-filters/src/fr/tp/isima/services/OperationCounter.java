package fr.tp.isima.services;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Cette classe sert simplement à compter le nombre d'occurence d'opérations sur
 * les maths ou sur les string
 * 
 * @author Benjamin
 *
 */
public class OperationCounter {

    private final AtomicInteger mathOps = new AtomicInteger(0);

    private final AtomicInteger stringOps = new AtomicInteger(0);

    /**
     * Compte la requête ou envoie une exception si elle n'est pas referencee.
     * La methode est thread safe mais le toString() peut etre different de la
     * valeur trouvee au moment ou le compteur comptait effectivement.
     * 
     * @param opName
     *            le nom complet de l'operation
     * @return une chaine contenant le toString de l'operationCounter
     * 
     */
    public String countRequest(String opName) {
        if (opName.startsWith("/maths")) {
            mathOps.getAndIncrement();
        } else if (opName.startsWith("/strings")) {
            stringOps.getAndIncrement();
        } else {
            throw new IllegalArgumentException("Operation " + opName + " inconnue");
        }
        return toString();
    }

    @Override
    public String toString() {
        return "Math ops : " + mathOps.get() + " and string ops " + stringOps.get();
    }
}
