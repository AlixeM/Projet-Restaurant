import java.util.*;

public class Main {

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant(); // Initialisation du restaurant

        restaurant.ajouterEmploye(); // Print liste d'employés choisis (attention soir dispo)

        // Etat des stocks (jsp quelle fonction appeler
        //Stock 

        restaurant.ouvrir();// Ouvre le restaurant

        // Transaction jusqu'à fermeture
        boolean restaurantOuvert = true;
        while (restaurantOuvert) {
            // Affichage des écrans
            Scanner scanner = new Scanner(System.in);
            System.out.println("Que souhaitez vous faire ?");
            System.out.println("1- Ecran prise de commande");
            System.out.println("2- Ecran cuisine");
            System.out.println("3- Ecran bar");
            System.out.println("4- Ecran Monitoring");
            System.out.println("5- Fermer le restaurant");
            int choixEcran = scanner.nextInt();
            System.out.println("Vous avez choisi l'écran: " + choixEcran);

            // En fonction du choix d'écran 
            switch (choixEcran) {
                case 1:
                    // Ecran Serveur
                    Serveur.commander();
                    break;

                case 2:
                    // Ecran cuisine
                    Cuisinier.cuisiner();
                    break;

                case 3:
                    // Ecran bar
                    Barman.boisson();
                    break;

                case 4:
                    // Ecran Manager
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Que souhaitez-vous faire ?");
                    System.out.println("1- Liste des Employés de la journée");
                    System.out.println("2- Liste des courses");
                    System.out.println("3- Performances du restaurant");
                    System.out.println("4- Stocks");
                    System.out.println("5- Retour aux écrans principaux");
                    int choixEcranManager = scanner2.nextInt();
                    System.out.println("Vous avez choisi l'écran: " + choixEcranManager);

                    switch (choixEcranManager) {
                        case 1:
                            Manager.gererEquipe(List<Employe> employes);// afficher la liste des employés de la journée
                            break;
                        case 2:
                            Manager.listeDesCourses(Map<Ingredients, Integer> stock);// afficher la liste des courses à la fin de la journée
                            break;
                        case 3:
                            Manager.performancesJournee();// afficher le nombre de commandes et l'argent gagné de la journée
                            break;
                        case 4:
                            // Afficher la liste des stocks;
                        	// JSP quoi mettre
                            break;
                        case 5:
                            // Retour aux écrans principaux
                            break;
                        default:
                            System.out.println("Choix d'écran invalide");
                            break;
                    }
                    break;

                case 5:
                    restaurant.nettoyer(); //Nettoyage
                    
                    // Faire les courses mais JSP quelle fonction j'appelle
                    stock.effectuerCourses();

                    restaurant.fermer(); //Fermeture
                    restaurantOuvert = false;
                    break;
                    

                default:
                    System.out.println("Choix d'écran invalide");
            }
        }
    }
}
