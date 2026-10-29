package com.testslogiciels.livraison;

public class FraisLivraison {
	
	public int calculerFrais(int montantCommande) {

        if (montantCommande < 100) {
            return 40;
        }

        if (montantCommande <= 500) {
            return 20;
        }

        return 0;
    }
}


