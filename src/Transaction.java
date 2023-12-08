import java.util.*;

public class Transaction {
	int id;
	Table table;
	double prix;
	List <Plat> plats;
	
	//ajouter un constructeur qui, pour chaque transaction, ajoute le prix de celle-ci à
	//un compteur dans Manager pour les performances de la journée et incrémente un autre
	//compteur du nombre de plats achetés dans la journée
	
	public void ajouterPlat(Plat plat) {
		plats.add(plat);
	}
	public void retirerPlat (Plat plat) {
		plats.remove(plat);
	}

	public void calculerPrix(List <Plat> plats) {
		int total = 0;
		for (Plat plat : plats) {
			total += plat.prix;
		}
		this.prix=total;
	}
}
