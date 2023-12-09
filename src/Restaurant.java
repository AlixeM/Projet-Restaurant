import java.util.Arrays;
import java.util.List;

public class Restaurant {
    List<Employe> employes;
    List<Employe> travailleurs;
    List<Plat> menu;
    boolean ouverture;
    public Restaurant() {
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
        
        //ajout des plats dans le menu
        menu = Arrays.asList(
        		saladeDeluxe, salade, soupeOignon, soupeTomate, soupeChampi,
                burgerComplet, burgerMid, burgerClassique, pizza, pizzaChampi,
                pizzaPepperoni, limonade, cidre, biere, jus, eau
            );
        
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
        travailleurs=manager.gererEquipe(employes);
        
        // Ouverture du restaurant
        ouvrir();
    }
   
    

    
	
    //... autres attributs et méthodes 

    public void ajouterEmploye(Employe employe) {
        employes.add(employe);
    }

    public void supprimerEmploye(Employe employe) {
        employes.remove(employe);
    }

    public void ouvrir() {
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