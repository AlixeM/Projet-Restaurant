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
	
	public List<Integer> payer(Table table, int prix) {
		
		int prixPaye=0;
		int personnesAyantPaye=1;
		List<Integer> paiements = new ArrayList<>();
		
		while(prixPaye<prix || personnesAyantPaye<table.nbPersonnes) {
			Scanner scanner = new Scanner(System.in);
			int prixRestant=prix-prixPaye;
			System.out.println("Table n° "+ table.numero + "Prix restant à payer : " + prixRestant);
			System.out.println("Client n° " +personnesAyantPaye +", combien voulez-vous payer ?");
			int paye = scanner.nextInt();
			
			if (paye<=prixRestant && paye>=0) {
				System.out.println("Vous avez bien payé "+paye+" euros.");
				prixRestant=-paye;
				prixPaye=+paye;
				personnesAyantPaye++;
				paiements.add(paye);
			}
			else{
				System.out.println("Il y a une erreur avec le montant. Veuillez réessayer.");
			}
			
			if(prixPaye<prix || personnesAyantPaye==table.nbPersonnes) {
				System.out.println("Table n° "+ table.numero +"Client n° " +personnesAyantPaye +", il vous reste "+ prixRestant+ "euros à payer.");
				paye=prixRestant;
				System.out.println("Vous avez bien payé "+paye+" euros.");
				prixRestant=-paye;
				prixPaye=+paye;
				personnesAyantPaye++;
				paiements.add(paye);
			}
			scanner.close();
		}
		
		return paiements;
	}
	
}
