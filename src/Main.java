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
                Serveur.commander();
                
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
                int choixEcranManager = scanner2.nextInt();
                System.out.println("Vous avez choisi l'écran: " + choixEcranManager);
                
                switch (choixEcranManager) {
                	case 1:
                		//Manager.gererEquipe(List<Employe> employes);
                		//afficher la liste des employés de la journée
                		break;
                	case 2 : 
                		//Manager.listeDesCourses(Map<Ingredients, Integer> stock);
                		//afficher la liste des courses à la fin de la journée
                		break;
                	case 3 : 
                		//Manager.performancesJournee();
                		//afficher le nombre de commandes et l'argent gagné de la journée
                		break;
                	case 4 : 
                		//Afficher la liste des stocks;
                		break;
                }
                break;

            default:
                System.out.println("Choix d'écran invalide");
        }

        // Fermez le restaurant
        restaurant.fermer();
    }
}