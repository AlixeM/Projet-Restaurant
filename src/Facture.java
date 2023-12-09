import java.io.*;
import java.util.*;
public class Facture {
    
    public static void genererListeCourses(Map<Ingredients, Integer> listeDesCourses) {
        try (FileWriter writer = new FileWriter("liste_courses.txt")) {
            for (Map.Entry<Ingredients, Integer> entry : listeDesCourses.entrySet()) {
                Ingredients ingredient = entry.getKey();
                int quantite = entry.getValue();
                double prixTotal = Ingredient.getPrix(ingredient) * quantite;

                // Écrire dans le fichier
                writer.write(ingredient + ": " + quantite + " - Prix total : " + prixTotal + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void genererRecetteDuJour(List<Transaction> recetteDuJour) {
        try (FileWriter writer = new FileWriter("recette_journee.txt")) {
            int totalPrixJour = 0;
            int totalPlatsAchetes = 0;

            for (Transaction transaction : recetteDuJour) {
                // Ajouter le prix de la transaction au total de la journée
                totalPrixJour += transaction.getPrix();

                // Ajouter le nombre de plats achetés au total
                totalPlatsAchetes += transaction.getPlats().size();

                // Écrire dans le fichier
                writer.write("Transaction #" + transaction.getId() + " - Prix : " + transaction.getPrix() + "\n");
                writer.write("Plats achetés : " + transaction.getPlats() + "\n\n");
            }

            // Écrire les totaux à la fin du fichier
            writer.write("Total prix de la journée : " + totalPrixJour + "\n");
            writer.write("Total plats achetés dans la journée : " + totalPlatsAchetes + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

