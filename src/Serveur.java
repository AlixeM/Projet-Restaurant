import java.util.*;

public class Serveur extends Employe {
	
	public Serveur(String nom, String prenom, double salaire, int soirDeSuite) {
        super(nom,prenom,salaire,soirDeSuite);   
    }

    public void afficherPlatsDisponibles(List <Plat> platsDispo) {
    	System.out.println("Plats disponibles :");
    	int i = 1;
    	for (Plat plat : platsDispo) {
    		System.out.println(i + "-" + plat.nom);
    	}
    	System.out.println("-------------");
    }
}
