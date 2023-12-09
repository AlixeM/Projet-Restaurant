import java.util.*;

public class Main {

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant(); // Initialisation du restaurant
        Stock stock = new Stock();
      //Initialisation des plats du menu 
        Plat saladeDeluxe = new Plat(9,"Salade Deluxe",Arrays.asList(Ingredients.TOMATE,Ingredients.SALADE));
        Plat salade = new Plat(9,"Salade",Arrays.asList(Ingredients.SALADE));
        Plat soupeOignon = new Plat(8,"Soupe Oignon",Arrays.asList(Ingredients.OIGNON,Ingredients.OIGNON,Ingredients.OIGNON));
        Plat soupeTomate = new Plat(8,"Soupe Tomate",Arrays.asList(Ingredients.TOMATE,Ingredients.TOMATE,Ingredients.TOMATE));
        Plat soupeChampi = new Plat(8,"Soupe Champignon",Arrays.asList(Ingredients.CHAMPIGNON,Ingredients.CHAMPIGNON,Ingredients.CHAMPIGNON));
        Plat burgerComplet = new Plat(15,"Burger Complet",Arrays.asList(Ingredients.PAIN,Ingredients.STEAK,Ingredients.TOMATE,Ingredients.SALADE));
        Plat burgerMid = new Plat(15,"Burger Mid",Arrays.asList(Ingredients.PAIN,Ingredients.STEAK,Ingredients.SALADE));
        Plat burgerClassique = new Plat(15,"Burger Classique",Arrays.asList(Ingredients.PAIN,Ingredients.STEAK));
        Plat pizza = new Plat(12, "Pizza",Arrays.asList(Ingredients.PÂTE,Ingredients.TOMATE,Ingredients.FROMAGE));
        Plat pizzaChampi = new Plat(12, "Pizza Champignon",Arrays.asList(Ingredients.PÂTE,Ingredients.TOMATE,Ingredients.FROMAGE,Ingredients.CHAMPIGNON));
        Plat pizzaPepperoni = new Plat(12, "Pizza Pepperoni",Arrays.asList(Ingredients.PEPPERONI,Ingredients.PÂTE,Ingredients.TOMATE,Ingredients.FROMAGE));
        Plat limonade = new Plat(4, "Limonade",Arrays.asList(Ingredients.LIMONADE));
        Plat cidre = new Plat(5, "Cidre Doux",Arrays.asList(Ingredients.CIDRE));
        Plat biere = new Plat(5, "Bière sans alcool",Arrays.asList(Ingredients.BIERE));
        Plat jus = new Plat(1, "Jus de fruit",Arrays.asList(Ingredients.JUS));
        Plat eau =new Plat(0, "Eau",Arrays.asList(Ingredients.EAU));
        //Initialisation des cocktails du bar
        Plat vodkaMenthe = new Plat(10, "Vodka Menthe", Arrays.asList(Ingredients.VODKA, Ingredients.MENTHE));
        Plat vodkaFramboise= new Plat(10, "Vodka Framboise", Arrays.asList(Ingredients.VODKA, Ingredients.FRAMBOISE));
        Plat rhumOrange = new Plat(10, "Rhum Orange", Arrays.asList(Ingredients.RHUM, Ingredients.ORANGE));
        
        //ajout des plats dans le menu
        List <Plat> menu = Arrays.asList(
        		saladeDeluxe, salade, soupeOignon, soupeTomate, soupeChampi,
                burgerComplet, burgerMid, burgerClassique, pizza, pizzaChampi,
                pizzaPepperoni, limonade, cidre, biere, jus, eau, vodkaMenthe, 
                vodkaFramboise, rhumOrange
            );
        Serveur serveurChef = new Serveur ("Serveur", "Enchef", 2000,0);
        Manager managerChef = new Manager ("Manager", "Enchef", 5000,0);
        Cuisinier cuisinierChef = new Cuisinier ("Cuisinier", "Enchef", 2000, 0);
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
                	//DEMANDER LE NOMBRE DE CLIENTS ET ENVOYER A UNE TABLE
                	//...
                	// CREER UNE TRANSACTION A LA COMMANDE 
                	//...
                	boolean tableTerminee = false;
                    while (!tableTerminee) {
                    	//affichage du menu
                	System.out.println("Plats disponibles :");
                    
                    if (serveurChef.verifDispo(saladeDeluxe, stock)) {
                        System.out.println("1- Salade Deluxe");
                    }
                    if (serveurChef.verifDispo(salade, stock)) {
                        System.out.println("2- Salade");
                    }
                    if (serveurChef.verifDispo(soupeOignon,stock)) {
                        System.out.println("3- Soupe Oignon");
                    }
                    if (serveurChef.verifDispo(soupeTomate,stock)) {
                        System.out.println("4- Soupe Tomate");
                    }
                    if (serveurChef.verifDispo(soupeChampi,stock)) {
                        System.out.println("5- Soupe Champignon");
                    }
                    if (serveurChef.verifDispo(burgerComplet,stock)) {
                        System.out.println("6- Burger Complet");
                    }
                    if (serveurChef.verifDispo(burgerMid,stock)) {
                        System.out.println("7- Burger Mid");
                    }
                    if (serveurChef.verifDispo(burgerClassique,stock)) {
                        System.out.println("8- Burger Classique");
                    }
                    if (serveurChef.verifDispo(pizza,stock)) {
                        System.out.println("9- Pizza");
                    }
                    if (serveurChef.verifDispo(pizzaChampi,stock)) {
                        System.out.println("10- Pizza Champignon");
                    }
                    if (serveurChef.verifDispo(pizzaPepperoni,stock)) {
                        System.out.println("11- Pizza Pepperoni");
                    }
                    if (serveurChef.verifDispo(limonade,stock)) {
                        System.out.println("12- Limonade");
                    }
                    if (serveurChef.verifDispo(cidre,stock)) {
                        System.out.println("13- Cidre Doux");
                    }
                    if (serveurChef.verifDispo(biere,stock)) {
                        System.out.println("14- Bière sans alcool");
                    }
                    if (serveurChef.verifDispo(jus,stock)) {
                        System.out.println("15- Jus de fruit");
                    }
                    if (serveurChef.verifDispo(eau,stock)) {
                        System.out.println("16- Eau");
                    }
                    // FAUT RAJOUTER LES COCKTAILS
                    System.out.println("-------------");
                    	// demande de commande au client
                        System.out.println("Voulez-vous ajouter un plat ? (Oui/Non)");
                        String reponse = scanner.next();

                        if (reponse.equalsIgnoreCase("Oui")) {
                            // Demander au serveur de choisir un plat
                        	Scanner scanner1 = new Scanner(System.in);
                            System.out.println("Quel plat souhaitez-vous ?");
                            

                            int choixEcranServeur = scanner1.nextInt();
                            switch (choixEcranServeur) {
                            case 1:  
                            	stock.retirerStock(salade);
                            	System.out.println("Vous avez choisi le plat : " + salade.nom);
                            	break;
                            case 2:
                            // RAJOUTER LES AUTRES PLATS ET AJOUTER A LA TRANSACTION CHAQUE PLAT
                            default: ; // Gérer le cas par défaut selon vos besoins
                        }

                        } else if (reponse.equalsIgnoreCase("Non")) {
                            tableTerminee = true;
                            System.out.println("La table a terminé de commander.");
                        } else {
                            System.out.println("Veuillez répondre par 'Oui' ou 'Non'.");
                        }
                    }
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
