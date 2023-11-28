import java.util.*;

public class Manager extends Employe {
    int prix;
    String nom;
    //... autres attributs et méthodes

    public void verifDispo(List<Ingredient> ingredients, List<Boisson> boissons) {
        //... vérifiez la disponibilité des ingrédients et des boissons
    }

    public Transaction creerTransaction() {
        //... créez une nouvelle transaction et retournez-la
        return new Transaction();
    }
}