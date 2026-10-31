
package com.testslogiciels.authentification;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

import org.junit.jupiter.api.*;

class GestionUtilisateurAvecCycleTest {

    static Path fichier =
        Path.of("target", "comptes-avec-cycle.jsonl");

    static Path journal =
        Path.of("target", "tests-avec-cycle.log");

    ArrayList<String[]> comptes;
    GestionUtilisateur gestion;

    // Une seule fois avant tous les tests
    @BeforeAll
    static void preparerFichier() throws IOException {

        DonneesTests.creerFichier(fichier);
    }

    // Avant chaque test
    @BeforeEach
    void preparerTest() throws IOException {

        comptes = DonneesTests.lireComptes(fichier);

        gestion = new GestionUtilisateur(comptes);
    }

    @Test
    void testCompteExistant() {

        assertTrue(
            gestion.verifierUtilisateur("alice@example.test")
        );
    }

    @Test
    void testCompteInexistant() {

        assertFalse(
            gestion.verifierUtilisateur("inconnu@example.test")
        );
    }

    @Test
    void testAuthentificationCorrecte() {

        assertTrue(
            gestion.authentifier(
                "alice@example.test", "1234"
            )
        );
    }

    @Test
    void testMotDePasseIncorrect() {

        assertFalse(
            gestion.authentifier(
                "alice@example.test", "incorrect"
            )
        );
    }

    @Test
    void testAuthentificationCompteInexistant() {

        assertFalse(
            gestion.authentifier(
                "inconnu@example.test", "1234"
            )
        );
    }

    // Après chaque test
    @AfterEach
    void nettoyerTest(TestInfo info) throws IOException {

        comptes.clear();

        DonneesTests.journaliser(
            journal, info.getDisplayName()
        );
    }

    // Une seule fois après tous les tests
    @AfterAll
    static void nettoyerFichier() throws IOException {

        Files.deleteIfExists(fichier);
    }
}
