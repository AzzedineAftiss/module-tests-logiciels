
package com.testslogiciels.authentification;

import java.util.ArrayList;

public class GestionUtilisateur {

    private ArrayList<String[]> comptes;

    public GestionUtilisateur(ArrayList<String[]> comptes) {
        this.comptes = comptes;
    }

    public boolean verifierUtilisateur(String email) {

        for (String[] compte : comptes) {
            if (compte[0].equals(email)) {
                return true;
            }
        }

        return false;
    }

    public boolean authentifier(String email, String motDePasse) {

        for (String[] compte : comptes) {

            if (compte[0].equals(email)
                    && compte[1].equals(motDePasse)) {
                return true;
            }
        }

        return false;
    }
}

