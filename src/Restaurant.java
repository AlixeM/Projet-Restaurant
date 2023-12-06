import java.util.List;

public class Restaurant {
	 // Créez un nouveau restaurant et des employés
    Restaurant restaurant = new Restaurant();
    Cuisinier cuisinier = new Cuisinier();
    Serveur serveur = new Serveur();
    Manager manager = new Manager();
    List<Employe> employes;

    // Ajoutez des employés au restaurant
    restaurant.ajouterEmploye(cuisinier);
    restaurant.ajouterEmploye(serveur);
    restaurant.ajouterEmploye(manager);

    // Ouvrez le restaurant
    restaurant.ouvrir();
	
    //... autres attributs et méthodes 

    public void ajouterEmploye(Employe employe) {
        //... ajoutez le nouvel employé à la liste des employés
    }

    public void supprimerEmploye(Employe employe) {
        //... supprimez l'employé de la liste des employés
    }

    public void ouvrir() {
        //... affichez un message pour indiquer que le restaurant est ouvert
    }

    public void fermer() {
        //... affichez un message pour indiquer que le restaurant est fermé
    }
}