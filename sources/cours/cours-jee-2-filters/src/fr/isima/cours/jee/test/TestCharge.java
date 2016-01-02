package fr.isima.cours.jee.test;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TestCharge {

    public static void main(String[] args) {
        final int nombreAppel = 10000;
        final List<Runnable> tasks = new ArrayList<>();

        // Cette instruction est l'équivlant d'un for int i = 0; i< max en java8
        // Pour chaque element on ajoute un element
        IntStream.range(0, nombreAppel).forEach((range) -> tasks.add(createCallHi(range)));
        for (int i = 0; i < nombreAppel; i++) {
            tasks.add(createCallHi(i));
        }
        // Cette instruction est un raccourci pour executer dans un thread
        // chaque fonction. Le gain en de code est très important
        tasks.parallelStream().forEach(e -> e.run());
    }

    private static Runnable createCallHi(int range) {
        System.out.println("Creating caller of range " + range);
        return () -> {
            try (InputStream is = new URL("http://localhost:8080/cours-jee-2-filters/welcome/hi?nick=loadTest").openStream()) {
                System.out.println("Executing call " + range);
                is.read(new byte[50]);
            } catch (final Exception e) {
                System.err.println("Call of range " + range + " failed");
                e.printStackTrace();
            }
        };
    }
}
