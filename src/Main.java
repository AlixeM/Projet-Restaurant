import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Créez un nouveau restaurant et des employés
        Restaurant restaurant = new Restaurant();
        Cuisinier cuisinier = new Cuisinier();
        Serveur serveur = new Serveur();
        Manager manager = new Manager();

        // Ajoutez des employés au restaurant
        restaurant.ajouterEmploye(cuisinier);
        restaurant.ajouterEmploye(serveur);
        restaurant.ajouterEmploye(manager);

        // Ouvrez le restaurant
        restaurant.ouvrir();

        // Ajoutez des commandes de plats et de boissons
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ArrayList<Boisson> boissons = new ArrayList<>();
        cuisinier.ajouterCommande(ingredients);
        serveur.ajouterBoisson(boissons);

        // Vérifiez la disponibilité des ingrédients et des boissons
        manager.verifDispo(ingredients, boissons);

        // Créez une transaction
        Transaction transaction = manager.creerTransaction();

        // Fermez le restaurant
        restaurant.fermer();
    }
}