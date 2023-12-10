import java.util.*;
public class Ingredient {
    private Ingredients ingredient;
    private double prix;

    // Map pour associer chaque ingrédient à son prix
    private static Map<Ingredients, Double> prixIngredients = new HashMap<>();

    public Ingredient(Ingredients ingredient, double prix) {
        this.ingredient = ingredient;
        this.prix = prix;

        // Ajouter l'association ingrédient-prix à la map
        prixIngredients.put(ingredient, prix);
    }

    public Ingredients getIngredient() {
        return ingredient;
    }

    public double getPrix() {
        return prix;
    }

    // Méthode statique pour obtenir le prix d'un ingrédient
    public static double getPrix(Ingredients ingredient) {
        return prixIngredients.getOrDefault(ingredient, 5.0);
    }
}