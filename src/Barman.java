import java.util.*;

public class Barman extends Employe {
	int soirDeSuite;
	List<Plat> boissonCommandes = new ArrayList<>();
	boolean enPrepa = false;
	
	public Barman(String nom, String prenom, double salaire, int soirDeSuite) {
        super(nom,prenom,salaire,soirDeSuite);   
    }
	
	public void ajouterBoisson(Plat plat) {
		boissonCommandes.add(plat);
	}
	
	public void afficherListe() {
		for (Plat plat : boissonCommandes) {
			System.out.println(plat.nom);
		}
	}
	
	public void preparer() {
		enPrepa = true;
		boissonCommandes.clear();
		System.out.println("Boissons en préparation");
	}
	
	public void ready() {
		enPrepa = false;
		System.out.println("Préparation terminée !");
	}
}
