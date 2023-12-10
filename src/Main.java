import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
    	boolean programmeFerme = false; //Cycle de journée
    	
    	// Initialisation du restaurant
        Restaurant restaurant = new Restaurant(); 
        Stock stock = new Stock();
        Menu menuDuJour = new Menu();
        //Initialisation des plats du menu 
        
        // création des employés qui gèrent les écrans (ne sont pas comptés dans l'équipe de travailleurs)
        Serveur serveurChef = new Serveur ("Serveur", "Enchef", 2000,0);
        Manager managerChef = new Manager ("Manager", "Enchef", 5000,0);
        Cuisinier cuisinierChef = new Cuisinier ("Cuisinier", "Enchef", 2000, 0);
        Barman barmanChef = new Barman ("Barman", "Enchef", 2000,0);
        Manager manager = restaurant.chercherManager();
        
        while (!programmeFerme) {
        	restaurant.ouvrir(manager,stock);// Ouvre le restaurant, affiche les employés du jour et reconstitue les stocks

        // Transaction jusqu'à fermeture
        boolean restaurantOuvert = true;
        int nbTransactionsTerminees = 0;
        boolean tableOccupee = false;
        while (restaurantOuvert) {
        	boolean retour = false;
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
                	
                	//On associe une table aux clients si on ne s'occupe pas encore d'une table
                	if (!tableOccupee) {
                		Scanner scannerClient = new Scanner(System.in);
                    	System.out.println("Bonjour ! Combien êtes-vous ? Nous pouvons accueillir entre 1 et 10 personnes !");
                    	int nbClient = scannerClient.nextInt();
                    	while(nbClient<=1 || nbClient >=10) {
                    		System.out.println("Donnez un nombre correct s'il vous plaît ");
                    		nbClient = scannerClient.nextInt();
                    	}
                    	Table table = restaurant.assignerTable(nbClient);
                    	table.nbPersonnes=nbClient;
                    	// On associe une transaction à cette commande
                    	Transaction transaction = new Transaction(nbTransactionsTerminees +1,table);
                    	managerChef.recetteDuJour.add(transaction);
                    	tableOccupee = true;
                    	boolean tableTerminee = false;
                    	while (!tableTerminee) {
                        	//affichage du menu
                        	List <Plat> platsDispos = stock.verifDispoMenu(menuDuJour.menu);
                        	serveurChef.afficherPlatsDisponibles(platsDispos);
                        	
                        	// demande de commande au client
                            System.out.println("Voulez-vous ajouter un plat ? (Oui/Non)");
                            Scanner scannerPlat = new Scanner(System.in);
                            String reponse = scannerPlat.next();

                            if (reponse.equalsIgnoreCase("Oui")) {
                                // Demander au client de choisir un plat
                            	Scanner scanner1 = new Scanner(System.in);
                                System.out.println("Quel plat souhaitez-vous ?");
                                int choixEcranServeur = scanner1.nextInt();
                                //on vérifie que le numéro du plat est bien sur le menu
                                while(choixEcranServeur <1 || choixEcranServeur > platsDispos.size()) {
                                	System.out.println("Ce numéro n'est pas dans le menu");
                                	choixEcranServeur = scanner1.nextInt();
                                }
                                Plat platChoisi = platsDispos.get(choixEcranServeur-1);
                                stock.retirerStock(platChoisi);
                                //si c'est un plat on envoie la commande en cuisine
                                if (choixEcranServeur <12) {
                                	System.out.println("Vous avez choisi le plat : " + platChoisi.nom);
                                    cuisinierChef.ajouterPlat(platChoisi);
                                }
                                //si c'est une boisson on envoie au bar
                                else if(choixEcranServeur >= 12) {
                                	System.out.println("Vous avez choisi la boisson " + platChoisi.nom);
                                	barmanChef.ajouterBoisson(platChoisi);
                                }
                                transaction.ajouterPlat(platChoisi);
                            } else if (reponse.equalsIgnoreCase("Non")) {
                                tableTerminee = true;
                                System.out.println("La table a terminé de commander. Votre commande arrive sous peu.");
                            } else {
                                System.out.println("Veuillez répondre par 'Oui' ou 'Non'.");
                            }
                    	}
                    	//si on s'occupe déjà une table, on vérifie si la commande est arrivée
                        if (cuisinierChef.enPrepa==false && cuisinierChef.platCommandes.isEmpty() && barmanChef.enPrepa==false && barmanChef.boissonCommandes.isEmpty()) {
                        	System.out.println("Voici vos repas ! Puis-je");
                        }
                	}
                	//si on s'occupe déjà une table, on vérifie si la commande est arrivée
                    if (!cuisinierChef.enPrepa && cuisinierChef.platCommandes.isEmpty() && !barmanChef.enPrepa && barmanChef.boissonCommandes.isEmpty()) {
                    		System.out.println("Voici votre commande !");
                    		//mettre un temps d'attente si alixe y arrive --> Ask and you shall reicive
                    		Thread.sleep(10000);// Attendre 10 secondes
                    		System.out.println("Avez-vous fini ? Oui/Non");
                        	Scanner scannerCommande= new Scanner (System.in);
                  			 String reponse = scannerCommande.next();                  			 
                              if (reponse.equalsIgnoreCase("Non")) {
                              	System.out.println("Pas de souci je reviendrai plus tard");
                              }
                              else if (reponse.equalsIgnoreCase("Oui")) {
                    				System.out.println("Très bien, nous pouvons passer à l'addition !");
                    				Transaction transactionPaiement =managerChef.recetteDuJour.get(nbTransactionsTerminees);
                    				transactionPaiement.calculerPrix(transactionPaiement.plats);
                    				List <Integer> paiements =transactionPaiement.payer(transactionPaiement.table, transactionPaiement.prix);
                    				nbTransactionsTerminees++;
                    				tableOccupee=false;
                                }
                              else {
                                  System.out.println("Veuillez répondre par 'Oui' ou 'Non'.");
                              }
                    	}else{
                    		System.out.println("Votre commande est encore en préparation");
                    	}

                    
                    break;

                case 2:
                    // Ecran cuisine
                	while (!retour) {
                		if (!cuisinierChef.enPrepa) {
                    		if (cuisinierChef.platCommandes.isEmpty()) {
                    			System.out.println("Rien à signaler ! Quitter l'écran ? Oui/Non");
                    			Scanner scannerRetour = new Scanner (System.in);
                    			 String reponse = scannerRetour.next();
                    			if (reponse.equalsIgnoreCase("Oui")) {
                    				System.out.println("Retour à l'écran principal");
                                	retour=true;
                                }
                                else if (reponse.equalsIgnoreCase("Non")) {
                                	System.out.println("Très bien, on reste sur l'écran Cuisine");
                                }
                                else {
                                    System.out.println("Veuillez répondre par 'Oui' ou 'Non'.");
                                }
                    		}
                    		else {
                                System.out.println("Bonjour chef ! Voici ce qui attend d'être préparé :");
                                cuisinierChef.afficherListe();
                                System.out.println("Commencer à préparer les plats ? Oui/Non");
                                Scanner scannerCuisine = new Scanner (System.in);
                                String reponse = scannerCuisine.next();
                                if (reponse.equalsIgnoreCase("Oui")) {
                                	cuisinierChef.preparer();
                                	retour=true;
                                }
                                else if (reponse.equalsIgnoreCase("Non")) {
                                	System.out.println("Pas de souci, quand tu veux chef");
                                }
                                else {
                                    System.out.println("Veuillez répondre par 'Oui' ou 'Non'.");
                                }
                            }
                    	}
                		else {
                			System.out.println("Les plats sont-ils prêts ? Oui/Non");
                			Scanner scannerPret = new Scanner (System.in);
                            String reponse = scannerPret.next();
                            if (reponse.equalsIgnoreCase("Oui")) {
                            	cuisinierChef.ready();
                            	retour=true;
                            }
                            else if (reponse.equalsIgnoreCase("Non")) {
                            	System.out.println("Okay prends ton temps");
                            }
                            else {
                                System.out.println("Veuillez répondre par 'Oui' ou 'Non'.");
                            }
                		}
                	}
                    break;

                case 3:
                	while (!retour) {
                		if (!barmanChef.enPrepa) {
                    		if (barmanChef.boissonCommandes.isEmpty()) {
                    			System.out.println("Rien à signaler ! Quitter l'écran ? Oui/Non");
                    			Scanner scannerRetour = new Scanner (System.in);
                    			 String reponse = scannerRetour.next();
                    			if (reponse.equalsIgnoreCase("Oui")) {
                    				System.out.println("Retour à l'écran principal");
                                	retour=true;
                                }
                                else if (reponse.equalsIgnoreCase("Non")) {
                                	System.out.println("Très bien, on reste sur l'écran Bar");
                                }
                                else {
                                    System.out.println("Veuillez répondre par 'Oui' ou 'Non'.");
                                }
                    		}
                    		else {
                                System.out.println("Bonjour chef ! Voici ce qui attend d'être préparé :");
                                barmanChef.afficherListe();
                                System.out.println("Commencer à préparer les boissons ? Oui/Non");
                                Scanner scannerBar = new Scanner (System.in);
                                String reponse = scannerBar.next();
                                if (reponse.equalsIgnoreCase("Oui")) {
                                	barmanChef.preparer();
                                	retour=true;
                                }
                                else if (reponse.equalsIgnoreCase("Non")) {
                                	System.out.println("Pas de souci, quand tu veux chef");
                                }
                                else {
                                    System.out.println("Veuillez répondre par 'Oui' ou 'Non'.");
                                }
                            }
                    	}
                		else {
                			System.out.println("Les boissons sont-elles prêtes ? Oui/Non");
                			Scanner scannerPret = new Scanner (System.in);
                            String reponse = scannerPret.next();
                            if (reponse.equalsIgnoreCase("Oui")) {
                            	barmanChef.ready();
                            	retour=true;
                            }
                            else if (reponse.equalsIgnoreCase("Non")) {
                            	System.out.println("Okay prends ton temps");
                            }
                            else {
                                System.out.println("Veuillez répondre par 'Oui' ou 'Non'.");
                            }
                		}
                	}
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
                                //Manager.gererEquipe(List<Employe> employes);// afficher la liste des employés de la journée
                                break;
                            case 2:
                                //Manager.listeDesCourses(Map<Ingredients, Integer> stock);// afficher la liste des courses à la fin de la journée
                                break;
                            case 3:
                                //Manager.performancesJournee();// afficher le nombre de commandes et l'argent gagné de la journée
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
                    	// Demander à l'utilisateur s'il veut fermer le programme ou démarrer une nouvelle journée
		                Scanner scanner3 = new Scanner(System.in);
		                System.out.println("Que souhaitez-vous faire ?");
		                System.out.println("1- Fermer le programme");
		                System.out.println("2- Démarrer une nouvelle journée");
		                int choixFermeture = scanner3.nextInt();
		
		                switch (choixFermeture) {
		                    case 1:
		                    	restaurant.nettoyer(); //Nettoyage
		                        
		                        // Faire les courses mais JSP quelle fonction j'appelle
		                        //stock.effectuerCourses();
		                    	
		                        restaurant.fermer(); // Fermeture
		                        programmeFerme = true;
		                        break;
		                    case 2:
		                    	restaurant.nettoyer(); //Nettoyage
		                        
		                        // Faire les courses mais JSP quelle fonction j'appelle
		                        //stock.effectuerCourses();
		                    	
		                        restaurant.fermer();
		                        restaurantOuvert = false;
		                        break;
		                    default:
		                        System.out.println("Choix invalide. Fermeture du programme.");
		                        programmeFerme = true;
		                        break;
		                }
		                break;
		
		            default:
		                System.out.println("Choix d'écran invalide");
		        }
            }
        }
    }
}