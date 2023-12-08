import java.util.*;

public class Plat {
	double prix;
	String nom;
	List <Ingredients> Ingredients; 
	
	public Plat(double prix, String nom, List <Ingredients> ingredients) {
		this.prix=prix;
		this.nom=nom;
		this.Ingredients=ingredients;
	}
}
