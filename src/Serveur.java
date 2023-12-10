import java.util.*;

public class Serveur extends Employe {
	
	public Serveur(String nom, String prenom, double salaire, int soirDeSuite) {
        super(nom,prenom,salaire,soirDeSuite);   
    }

    public void afficherPlatsDisponibles(List <Plat> platsDispo) {
    	System.out.println("Plats disponibles :");
    	int i = 1;
    	for (Plat plat : platsDispo) {
    		System.out.println((platsDispo.indexOf(plat)+1) + "-" + plat.nom);
    		i+=1;
    	}
    	System.out.println("-------------");
    }
}
