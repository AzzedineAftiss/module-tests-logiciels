
package com.testslogiciels.authentification;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DonneesTests {

    public static void creerFichier(Path fichier)
            throws IOException {

        Files.createDirectories(fichier.getParent());

        if (Files.notExists(fichier)) {

            String donnees = """
                {"email":"alice@example.test","password":"1234"}
                {"email":"bob@example.test","password":"5678"}
                {"email":"sara@example.test","password":"abcd"}
                """;

            Files.writeString(fichier, donnees);
        }
    }

    public static ArrayList<String[]> lireComptes(Path fichier)
            throws IOException {

        ArrayList<String[]> comptes = new ArrayList<>();

        for (String ligne : Files.readAllLines(fichier)) {

            if (ligne.isBlank()) {
                continue;
            }

            // Lecture simplifiée du JSONL fixe de l'exercice
            String[] valeurs = ligne.split("\"");

            comptes.add(new String[]{
                valeurs[3], valeurs[7]
            });
        }

        return comptes;
    }

    public static void journaliser(Path journal, String nomTest)
            throws IOException {

        Files.createDirectories(journal.getParent());

        Files.writeString(
            journal,
            LocalDateTime.now() + " | " + nomTest
                + " | Exécution terminée\n",
            StandardOpenOption.CREATE,
            StandardOpenOption.APPEND
        );
    }
}
