import java.util.*;

enum Ingredients{ SALADE, TOMATE, OIGNON, CHAMPIGNON, PAIN, STEAK, PÂTE, FROMAGE, PEPPERONI, LIMONADE, CIDRE, BIERE, JUS, EAU,VODKA,MENTHE,FRAMBOISE,ORANGE,RHUM};

public class Stock {
	Map<Ingredients,Integer> stock = new HashMap<>();
	
	public Stock() {
		stock.put(Ingredients.SALADE,10);
		stock.put(Ingredients.TOMATE,10);
		stock.put(Ingredients.OIGNON,10);
		stock.put(Ingredients.CHAMPIGNON,10);
		stock.put(Ingredients.PAIN,10);
		stock.put(Ingredients.STEAK,10);
		stock.put(Ingredients.PÂTE,10);
		stock.put(Ingredients.FROMAGE,10);
		stock.put(Ingredients.PEPPERONI,10);
		stock.put(Ingredients.LIMONADE,10);
		stock.put(Ingredients.CIDRE,10);
		stock.put(Ingredients.BIERE,10);
		stock.put(Ingredients.JUS,10);
		stock.put(Ingredients.EAU,10);
		stock.put(Ingredients.VODKA,10);
		stock.put(Ingredients.MENTHE,10);
		stock.put(Ingredients.FRAMBOISE,10);
		stock.put(Ingredients.ORANGE,10);
		stock.put(Ingredients.RHUM,10);
	}
	
	public void ajouterStock(Ingredients ingredient, int quantite) {
		stock.put(ingredient, stock.getOrDefault(ingredient, 0) + quantite);
	}
	
    public void retirerStock(Plat plat) {
        Map<Ingredients, Integer> quantitesNecessaires = new HashMap<>();

        // Calculer les quantités nécessaires pour chaque ingrédient dans le plat
        for (Ingredients ingrédient : plat.getIngredients()) {
            quantitesNecessaires.put(ingrédient, quantitesNecessaires.getOrDefault(ingrédient, 0) + 1);
        }

        // Retirer les ingrédients du stock en tenant compte des quantités nécessaires 
        for (Map.Entry<Ingredients, Integer> entry : quantitesNecessaires.entrySet()) {
            Ingredients ingrédient = entry.getKey();
            int quantiteNecessaire = entry.getValue();

            // Vérifier si l'ingrédient est présent dans le stock
            if (stock.containsKey(ingrédient)) {
                int quantiteActuelle = stock.get(ingrédient);
                // Vérifier si la quantité est suffisante pour retirer
                if (quantiteActuelle >= quantiteNecessaire) {
                    stock.put(ingrédient, quantiteActuelle - quantiteNecessaire);
                } else {
                    // Gérer le cas où la quantité est insuffisante
                    System.out.println("Erreur : Stock insuffisant pour l'ingrédient " + ingrédient);
                }
            } else {
                // Gérer le cas où l'ingrédient n'est pas présent dans le stock
                System.out.println("Erreur : Ingrédient " + ingrédient + " non trouvé dans le stock");
            }
        }
    }
	//méthode qui remplit le stock
    public void remplirStock() {
    	for (Ingredients ingredient : Ingredients.values()) {
            // Mettre à 10 la quantité de chaque ingrédient
            stock.put(ingredient, 10);
        }
    }
    
    public boolean verifDispo(Plat plat) {
        Map<Ingredients, Integer> quantitesNecessaires = new HashMap<>();

        // Calculer les quantités nécessaires pour chaque ingrédient dans le plat
        for (Ingredients ingrédient : plat.getIngredients()) {
            quantitesNecessaires.put(ingrédient, quantitesNecessaires.getOrDefault(ingrédient, 0) + 1);
        }

        // Vérifier si les ingrédients sont présents en quantité suffisante dans le stock
        for (Map.Entry<Ingredients, Integer> entry : quantitesNecessaires.entrySet()) {
            Ingredients ingrédient = entry.getKey();
            int quantiteNecessaire = entry.getValue();

            if (stock.containsKey(ingrédient)) {
                int quantiteActuelle = stock.get(ingrédient);
                if (quantiteActuelle < quantiteNecessaire) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
    
    public List<Plat> verifDispoMenu(List <Plat> menuPrevisionnel){
    	List<Plat> platsDisponibles = new ArrayList<>();

        for (Plat plat : menuPrevisionnel) {
            if (verifDispo(plat)) {
                platsDisponibles.add(plat);
            }
        }

        return platsDisponibles;
    }
    public void afficherMapStock() {
        System.out.println("Ingrédients en stock :");

        for (Map.Entry<Ingredients, Integer> entry : stock.entrySet()) {
            Ingredients ingredient = entry.getKey();
            int quantite = entry.getValue();

            System.out.println(ingredient + " : " + quantite);
        }
    }
}



