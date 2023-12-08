import java.util.List;

public class Barman extends Employe {
	int soirDeSuite;
	List<Plat> boissonCommandes;
	
	public Barman(String nom, String prenom, double salaire, int soirDeSuite) {
        super(nom,prenom,salaire,soirDeSuite);   
        }
	
	public void ready() {

	}
}
