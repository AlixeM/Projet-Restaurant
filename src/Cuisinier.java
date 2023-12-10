import java.util.*;

public class Cuisinier extends Employe {
    int soirDeSuite;
    List <Plat> platCommandes = new ArrayList<>();
    boolean enPrepa = false;
    
	public Cuisinier(String nom, String prenom, double salaire, int soirDeSuite) {
        super(nom,prenom,salaire,soirDeSuite);   
        }
    
	public void ajouterPlat(Plat plat) {
		platCommandes.add(plat);
	}
	
	public void preparer() {
		enPrepa = true;
		platCommandes.clear();
		System.out.println("Plats en préparation");
	}
	
	public void ready() {
		enPrepa = false;
		System.out.println("Préparation terminée !");
	}
}
   