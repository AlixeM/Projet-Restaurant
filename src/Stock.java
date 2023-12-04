import java.util.*;

enum Ingredients{ SALADE, TOMATE, OIGNON, CHAMPIGNON, PAIN, STEAK, PÂTE, FROMAGE, PEPPERONI, LIMONADE, CIDRE, BIERE, JUS, EAU};

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
	}
	
	public void ajouterStock(Ingredients ingredient, int quantite) {
		stock.put(ingredient, stock.getOrDefault(ingredient, 0) + quantite);
	}
	
	public void retirerStock(Ingredients ingredient, int quantite) {
		int quantiteActuelle = stock.getOrDefault(ingredient, 0);
        if (quantiteActuelle >= quantite) {
            stock.put(ingredient, quantiteActuelle - quantite);
        } else {
            System.out.println("Stock insuffisant pour " + ingredient);
        }
	}
}
