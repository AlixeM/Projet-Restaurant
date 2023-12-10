import java.util.*;

public class Manager extends Employe {
	
	List <Transaction> recetteDuJour = new ArrayList<>();
	int argentGagne = 0;
	
	public Manager(String nom, String prenom, double salaire, int soirDeSuite) {
        super(nom,prenom,salaire,soirDeSuite);   
    }
	
	public void calculArgent() {
		if (recetteDuJour.isEmpty()) {
			argentGagne=0;
		}else {
			for (Transaction transaction : recetteDuJour) {
				argentGagne+=transaction.prix;
			}
		}
		
	}
	
	public List<Employe> gererEquipe(List<Employe> employes) {
        List<Employe> equipeGeree = new ArrayList<>();

        int cuisinierCount = 0;
        int barmanCount = 0;
        int serveurCount = 0;

        // Parcourir la liste d'employés et sélectionner les cuisiniers, le barman et les serveurs en vérifiant soirDeSuite
        for (Employe employe : employes) {
            if (employe instanceof Cuisinier && employe.soirDeSuite < 2 && cuisinierCount < 4) {
                equipeGeree.add(employe);
                cuisinierCount++;
            } else if (employe instanceof Barman && employe.soirDeSuite < 2 && barmanCount < 1) {
                equipeGeree.add(employe);
                barmanCount++;
            }  else if (employe instanceof Serveur && employe.soirDeSuite < 2 && serveurCount < 2) {
                equipeGeree.add(employe);
                serveurCount++;
            }
        }

        // Ajouter le manager à l'équipe
        equipeGeree.add(this);
        
        if (cuisinierCount < 4 || barmanCount < 1 || serveurCount < 2) {
            System.out.println("L'équipe est incomplète, le restaurant ne peut pas ouvrir.");
            equipeGeree.clear(); // Réinitialiser la liste si l'équipe est incomplète
        }
        return equipeGeree;
	}
	
	public Map<Ingredients, Integer> listeDesCourses(Map<Ingredients, Integer> stock) {
        Map<Ingredients, Integer> listeDesCourses = new HashMap<>();

        for (Map.Entry<Ingredients, Integer> entry : stock.entrySet()) {
            Ingredients ingredient = entry.getKey();
            int quantiteActuelle = entry.getValue();

            // Si la quantité actuelle est inférieure à 10, calculer la quantité à acheter
            if (quantiteActuelle < 10) {
                int quantiteAcheter = 10 - quantiteActuelle;
                listeDesCourses.put(ingredient, quantiteAcheter);
            }
        }

        return listeDesCourses;
    }
	
	public void afficherMapCourses(Map<Ingredients, Integer> map) {
        System.out.println("Liste des courses à faire :");

        for (Map.Entry<Ingredients, Integer> entry : map.entrySet()) {
            Ingredients ingredient = entry.getKey();
            int quantite = entry.getValue();

            System.out.println(ingredient + " : " + quantite);
        }
    }
}