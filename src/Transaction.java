import java.util.*;

public class Transaction {
	int id;
	Table table;
	int prix;
	List <Plat> plats = new ArrayList<>();
	
	public Transaction(int id, Table table) {
		this.id=id;
		this.table=table;
		this.prix=0;
		this.plats= new ArrayList <>();
	}
	
	public int getId() {
        return id;
    }

    public Table getTable() {
        return table;
    }

    public int getPrix() {
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
		int paye=0;
		int prixRestant=prix-prixPaye;
		boolean paiementCorrect = true;
		while(prixPaye<prix && personnesAyantPaye<table.nbPersonnes) {
				Scanner scanner = new Scanner(System.in);
				prixRestant=prix-prixPaye;
				try {
					System.out.println("Table n° "+ table.numero + " Prix restant à payer : " + prixRestant);
					System.out.println(" Client n° " +personnesAyantPaye +", combien voulez-vous payer ? (nombre entier) ");
					paye = scanner.nextInt();
				}catch(InputMismatchException e) {
		            System.out.println("Erreur : Vous devez entrer un entier.");
		            paye = 0;
		            personnesAyantPaye--;
		            paiementCorrect=false;
		        }
				if (paye<=prixRestant && paye>=0) {
					if (paiementCorrect) {
						System.out.println("Vous avez bien payé "+paye+" euros.");
					}
					paiementCorrect=true;
					prixRestant-=paye;
					prixPaye+=paye;
					personnesAyantPaye++;
					paiements.add(paye);
				}
				else{
					System.out.println("Il y a une erreur avec le montant. Veuillez réessayer.");
				}
			}
			if(prixPaye<prix && personnesAyantPaye==table.nbPersonnes) {
				System.out.println("Table n° "+ table.numero +" Client n° " +personnesAyantPaye +", il vous reste "+ prixRestant+ "euros à payer.");
				paye=prixRestant;
				System.out.println("Vous avez bien payé "+paye+" euros.");
				prixRestant-=paye;
				prixPaye+=paye;
				personnesAyantPaye++;
				paiements.add(paye);
		}
		return paiements;
	}
	
}
