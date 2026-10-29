# Cas pratique 01 — Calcul des frais de livraison

## 1. Contexte

Une application de commerce électronique dispose d'un service permettant de calculer les frais de livraison en fonction du montant d'une commande.

## 2. Spécifications fonctionnelles

Le calcul des frais de livraison doit respecter les règles métier suivantes :

- Pour un montant inférieur à 100 DH, les frais de livraison sont de 40 DH.
- Pour un montant compris entre 100 DH inclus et 500 DH exclus, les frais de livraison sont de 20 DH.
- Pour un montant supérieur ou égal à 500 DH, la livraison est gratuite.

On suppose que le montant de la commande est un entier positif ou nul.

## 3. Travail demandé

1. Analyser les spécifications fonctionnelles et le code source fourni.
2. Concevoir des cas de test pertinents en utilisant les techniques de conception des tests étudiées.
3. Développer une classe Java permettant d'exécuter les tests unitaires sans utiliser de framework de test.
4. Comparer les résultats obtenus aux résultats attendus.
5. Afficher le statut de chaque test : PASS ou FAIL.
6. Analyser les éventuels échecs et identifier leurs causes.