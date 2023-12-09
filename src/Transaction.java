import java.util.*;

public class Transaction {
	int id;
	Table table;
	double prix;
	List <Plat> plats;
	
	public int getId() {
        return id;
    }

    public Table getTable() {
        return table;
    }

    public double getPrix() {
        return prix;
    }

    public List<Plat> getPlats() {
        return plats;
    }
	
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
