import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Affichage des écrans
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel écran souhaitez-vous afficher?");
        System.out.println("1- Ecran prise de commande");
        System.out.println("2- Ecran cuisine");
        System.out.println("3- Ecran bar");
        System.out.println("4- Ecran Monitoring");
        int choixEcran = scanner.nextInt();
        System.out.println("Vous avez choisi l'écran: " + choixEcran);

        // En fonction du choix d'écran
        switch (choixEcran) {
            case 1:
                // Ecran Serveur
                // Ajoutez des commandes de plats et de boissons
                Serveur.ajouterCommande(Commande);
                
                break;

            case 2:
                // Ecran cuisine
                // Logique spécifique à l'écran cuisine
                break;

            case 3:
                // Ecran bar
                // Logique spécifique à l'écran bar
                break;

            case 4:
                // Ecran Monitoring
                // Logique spécifique à l'écran Monitoring
                break;

            default:
                System.out.println("Choix d'écran invalide");
        }

        // Fermez le restaurant
        restaurant.fermer();
    }
}