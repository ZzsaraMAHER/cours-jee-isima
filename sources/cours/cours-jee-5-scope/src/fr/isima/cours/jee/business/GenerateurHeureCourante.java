package fr.isima.cours.jee.business;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerateurHeureCourante {

    private final String dateFormat;

    public GenerateurHeureCourante(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String nowWithStandardFormat() {
        return DateTimeFormatter.ofPattern(dateFormat).format(LocalDateTime.now());
    }
}
