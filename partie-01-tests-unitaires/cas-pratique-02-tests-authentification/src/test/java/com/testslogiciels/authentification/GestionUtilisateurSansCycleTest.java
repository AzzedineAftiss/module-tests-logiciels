
package com.testslogiciels.authentification;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class GestionUtilisateurSansCycleTest {

    static Path fichier =
        Path.of("target", "comptes-sans-cycle.jsonl");

    static Path journal =
        Path.of("target", "tests-sans-cycle.log");

    @Test
    void testCompteExistant() throws IOException {

        DonneesTests.creerFichier(fichier);

        ArrayList<String[]> comptes =
            DonneesTests.lireComptes(fichier);

        GestionUtilisateur gestion =
            new GestionUtilisateur(comptes);

        try {
            assertTrue(
                gestion.verifierUtilisateur("alice@example.test")
            );
        } finally {
            comptes.clear();
            DonneesTests.journaliser(journal, "testCompteExistant");
            Files.deleteIfExists(fichier);
        }
    }

    @Test
    void testCompteInexistant() throws IOException {

        DonneesTests.creerFichier(fichier);

        ArrayList<String[]> comptes =
            DonneesTests.lireComptes(fichier);

        GestionUtilisateur gestion =
            new GestionUtilisateur(comptes);

        try {
            assertFalse(
                gestion.verifierUtilisateur("inconnu@example.test")
            );
        } finally {
            comptes.clear();
            DonneesTests.journaliser(journal, "testCompteInexistant");
            Files.deleteIfExists(fichier);
        }
    }

    @Test
    void testAuthentificationCorrecte() throws IOException {

        DonneesTests.creerFichier(fichier);

        ArrayList<String[]> comptes =
            DonneesTests.lireComptes(fichier);

        GestionUtilisateur gestion =
            new GestionUtilisateur(comptes);

        try {
            assertTrue(
                gestion.authentifier(
                    "alice@example.test", "1234"
                )
            );
        } finally {
            comptes.clear();
            DonneesTests.journaliser(
                journal, "testAuthentificationCorrecte"
            );
            Files.deleteIfExists(fichier);
        }
    }
}
