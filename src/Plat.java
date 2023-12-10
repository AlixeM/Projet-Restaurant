import java.util.*;

public class Plat {
	double prix;
	String nom;
	List <Ingredients> ingredients = new ArrayList<>(); 
	
	public Plat(double prix, String nom, List <Ingredients> ingredients) {
		this.prix=prix;
		this.nom=nom;
		this.ingredients=ingredients;
	}
	
	public List <Ingredients> getIngredients(){
		return ingredients;
	}
}
