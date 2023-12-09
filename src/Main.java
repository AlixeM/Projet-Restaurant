import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Initialisation du restaurant
        Restaurant restaurant = new Restaurant();

        // On check la liste d'employés (soir dispo attention) et print la liste des employés choisis
        //restaurant.ajouterEmploye();

        // Faire les stocks
        Stock stock = new Stock();

        // Ouvre le restaurant (print "Bonjour ! Le restaurant est ouvert")
        restaurant.ouvrir();

        // Boucle pour afficher les écrans jusqu'à ce que le restaurant soit fermé
        boolean restaurantOuvert = true;
        while (restaurantOuvert) {
            // Affichage des écrans
            Scanner scanner = new Scanner(System.in);
            System.out.println("Quel écran souhaitez-vous afficher?");
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
                    // Ajoutez des commandes de plats et de boissons
                    //Serveur.commander();
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
                            // Manager.gererEquipe(List<Employe> employes);
                            // afficher la liste des employés de la journée
                            break;
                        case 2:
                            // Manager.listeDesCourses(Map<Ingredients, Integer> stock);
                            // afficher la liste des courses à la fin de la journée
                            break;
                        case 3:
                            // Manager.performancesJournee();
                            // afficher le nombre de commandes et l'argent gagné de la journée
                            break;
                        case 4:
                            // Afficher la liste des stocks;
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
                    // Quand on choisit de fermer le restaurant
                    restaurant.fermer();

                    // Nettoyer (fonction qui print "nettoyage en cours" attend 5s puis print "restaurant nettoyé")
                    restaurant.nettoyer();

                    // Courses (appel d'une fonction dans la classe stock)
                    //stock.effectuerCourses();

                    // Fin du programme
                    restaurantOuvert = false; // Sortir de la boucle
                    break;

                default:
                    System.out.println("Choix d'écran invalide");
            }
        }
    }
}
