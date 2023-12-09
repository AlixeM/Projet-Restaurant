import java.util.List;

public class Barman extends Employe {
	int soirDeSuite;
	List<Plat> boissonCommandes;
	boolean enPrepa = false;
	
	public Barman(String nom, String prenom, double salaire, int soirDeSuite) {
        super(nom,prenom,salaire,soirDeSuite);   
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
