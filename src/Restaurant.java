import java.util.*;

public class Restaurant {
    List<Employe> employes = new ArrayList<>();
    List<Employe> travailleurs = new ArrayList<>();
    List <Table> tables = new ArrayList<>();
    boolean ouverture = false;
    public Restaurant() {
        // création des employés
        Cuisinier cuisinier = new Cuisinier ("Pitou", "Anne", 2000, 0);
        Cuisinier cuisinier2 = new Cuisinier ("Toudu", "Robert", 2000, 0);
        Cuisinier cuisinier3 = new Cuisinier ("Rico", "Patrick", 2000, 0);
        Cuisinier cuisinier4 = new Cuisinier ("Milas", "Francis", 2000, 0);
        Cuisinier cuisinier5 = new Cuisinier ("Cala", "Joséphine", 2000, 5);
        Cuisinier cuisinier6 = new Cuisinier ("Bilty", "Louise", 2000, 0);
        Manager manager = new Manager ("Casnoix", "Jean", 5000,0);
        Barman barman = new Barman ("Moldu", "Hubert", 2000,0);
        Barman barman2 = new Barman ("Firatu", "Pricilla", 2000,0);
        Serveur serveur = new Serveur ("Miratru", "Olivia", 2000,0);
        Serveur serveur2 = new Serveur ("Rantis", "Freddy", 0,0);
        Serveur serveur3 = new Serveur ("Danlta", "Alphonse", 2000,0);
        Serveur serveur4 = new Serveur ("Kilo", "Cendy", 2000,0);
        ajouterEmploye(cuisinier);
        ajouterEmploye(cuisinier2);
        ajouterEmploye(cuisinier3);
        ajouterEmploye(cuisinier4);
        ajouterEmploye(cuisinier5);
        ajouterEmploye(cuisinier6);
        ajouterEmploye(manager);
        ajouterEmploye(barman);
        ajouterEmploye(barman2);
        ajouterEmploye(serveur);
        ajouterEmploye(serveur2);
        
        // création des tables
        Table table1 = new Table(1,1);
        Table table2 = new Table(2,2);
        Table table3 = new Table(3,3);
        Table table4 = new Table(4,4);
        Table table5 = new Table(5,5);
        Table table6 = new Table(6,6);
        Table table7 = new Table(7,7);
        Table table8 = new Table(8,8);
        Table table9 = new Table(9,9);
        Table table10 = new Table(10,10);
        ajouterTable(table1);
        ajouterTable(table2);
        ajouterTable(table3);
        ajouterTable(table4);
        ajouterTable(table5);
        ajouterTable(table6);
        ajouterTable(table7);
        ajouterTable(table8);
        ajouterTable(table9);
        ajouterTable(table10);
    }
   
    public void afficherInfosTravailleurs() {
    	System.out.println("Travailleurs du jour : ");
        for (Employe employe : travailleurs) {
            System.out.println("Nom: " + employe.nom + ", Prénom: " + employe.prenom);
        }
    }
    
    public Manager chercherManager() {
        for (Employe employe : employes) {
            if (employe instanceof Manager) {
                return (Manager) employe;
            }
        }
        // Si aucun Manager n'est trouvé, retourner null
        return null;
    }
    
    public void ajouterEmploye(Employe employe) {
        employes.add(employe);
    }
    
    public void ajouterTable(Table table) {
        tables.add(table);
    }
    
    public void supprimerEmploye(Employe employe) {
        employes.remove(employe);
    }
    
    // Vérifie si une équipe est dispo et reconstitue le stock
    public boolean ouvrir(Manager manager, Stock stock) {
    	stock.remplirStock();
    	travailleurs=manager.gererEquipe(employes);
    	if (travailleurs.isEmpty()) {
    		System.out.println("Equipe pas assez nombreuse pour ouvrir, jour de repos forcé pour tout le monde");
    		for (Employe employe : employes) {
    			employe.soirDeSuite=0;
    		}
    		return false;
    	}
    	this.ouverture=true;
    	afficherInfosTravailleurs();
    	System.out.println("Encore une belle journée qui commence !");
    	return true;
    }

    public void fermer() {
        this.ouverture = false;
        for (Employe employe : travailleurs) {
            employe.soirDeSuite++;
        }
        System.out.println("Au revoir ! Merci pour cette belle journée");
    }

    
    public void nettoyer() throws InterruptedException {
        System.out.println("Nettoyage en cours...");
        Thread.sleep(5000);// Attendre 5 secondes
        System.out.println("Restaurant nettoyé");
    }
    
    public Table assignerTable(int nbPersonnes) {
        for (Table table : tables) {
        	
        	if (nbPersonnes <= 0) {
        		System.out.println("Ah c'est drôle ça une table avec même pas une personne");
        		return null;
        	}
            if (table.nbPersonnesMax == nbPersonnes) {
            	System.out.println("Je vous conduis à la table numéro " + table.numero);
                return table;
            }
        }
        // Si aucune table correspondante n'est trouvée, retourner null
        System.out.println("Nous n'avons pas de table qui correspond, essayez d'être moins nombreux");
        return null;
    }
}