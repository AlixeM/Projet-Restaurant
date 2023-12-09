import java.util.List;

public class Restaurant {
    List<Employe> employes;
    List<Employe> travailleurs;
    boolean ouverture = false;
    public Restaurant() {
        
        Cuisinier cuisinier = new Cuisinier ("Michel", "Francis", 2000, 0);
        Cuisinier cuisinier2 = new Cuisinier ("Michel", "Francis", 2000, 0);
        Cuisinier cuisinier3 = new Cuisinier ("Michel", "Francis", 2000, 0);
        Cuisinier cuisinier4 = new Cuisinier ("Michel", "Francis", 2000, 0);
        Cuisinier cuisinier5 = new Cuisinier ("blabla", "truc", 2000, 5);
        Cuisinier cuisinier6 = new Cuisinier ("zozozoz", "hahahaha", 2000, 0);
        Manager manager = new Manager ("Truc", "Bidule", 5000,0);
        Barman barman = new Barman ("Robert", "Jean", 2000,0);
        Barman barman2 = new Barman ("Pierre", "Jean", 2000,0);
        ajouterEmploye(cuisinier);
        ajouterEmploye(cuisinier2);
        ajouterEmploye(cuisinier3);
        ajouterEmploye(cuisinier4);
        ajouterEmploye(cuisinier5);
        ajouterEmploye(cuisinier6);
        ajouterEmploye(manager);
        ajouterEmploye(barman);
        ajouterEmploye(barman2);
    }
   
    

    
	
    //... autres attributs et méthodes 

    public void ajouterEmploye(Employe employe) {
        employes.add(employe);
    }

    public void supprimerEmploye(Employe employe) {
        employes.remove(employe);
    }
    // Vérifie si une équipe est dispo et reconstitue le stock
    public void ouvrir(Manager manager, Stock stock) {
    	stock.remplirStock();
    	travailleurs=manager.gererEquipe(employes);
    	if (travailleurs.isEmpty()) {
    		System.out.println("Equipe pas assez nombreuse pour ouvrir");
    		return;
    	}
    	this.ouverture=true;
    	System.out.println("Encore une belle journée qui commence !");
    }

    public void fermer() {
    	this.ouverture=false;
    	System.out.println("Ciao li pepperoni e la spaghetti mamaaaaaaa");
    }
    
    public void nettoyer() throws InterruptedException {
        System.out.println("Nettoyage en cours...");
        Thread.sleep(5000);// Attendre 5 secondes
        System.out.println("Restaurant nettoyé");
    }
}