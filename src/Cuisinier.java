import java.util.*;

public class Cuisinier extends Employe {
    int soirDeSuite;
    List <Plat> platCommandes;
    
	public Cuisinier(String nom, String prenom, double salaire, int soirDeSuite) {
        super(nom,prenom,salaire,soirDeSuite);   
        }
    
    public void ready() {
    	
    }
}
   