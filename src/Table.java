import java.util.*;

public class Table {
    int numero;
    int nbPersonnes;
    int nbPersonnesMax;

    public Table(int numero, int nbPersonnesMax) {
        this.numero = numero;
        this.nbPersonnesMax = nbPersonnesMax;

        if (nbPersonnesMax <= 0) {
            // Si on met pas le bon nombre de personnes max
            System.out.println("Erreur : Le nombre maximum de personnes doit être supérieur à zéro.");
            return; // Annule la création de l'instance de Table
        }

        if (nbPersonnes > nbPersonnesMax) {
            // Si le nombre de personnes dépasse le max
            System.out.println("Erreur : Le nombre de personnes dépasse la capacité maximale de la table.");
            return; // Annule la création de l'instance 
        }

        // Si tout est bon, initialise le nb de personnes
        this.nbPersonnes = nbPersonnes;
    }
}
