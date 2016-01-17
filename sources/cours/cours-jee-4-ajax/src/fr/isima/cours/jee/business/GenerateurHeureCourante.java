package fr.isima.cours.jee.business;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerateurHeureCourante {

    private static final String FORMAT_STANDARD_DATE = "HH:mm:ss 'le' dd/MM/yyyy";

    public String nowWithStandardFormat() {
        return DateTimeFormatter.ofPattern(FORMAT_STANDARD_DATE).format(LocalDateTime.now());
    }
}
