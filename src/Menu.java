import java.util.*;
public class Menu {
	List <Plat> menu = new ArrayList<>();
	
	public Menu() {
		Plat saladeDeluxe = new Plat(9,"Salade Deluxe",Arrays.asList(Ingredients.TOMATE,Ingredients.SALADE));
        Plat salade = new Plat(9,"Salade",Arrays.asList(Ingredients.SALADE));
        Plat soupeOignon = new Plat(8,"Soupe Oignon",Arrays.asList(Ingredients.OIGNON,Ingredients.OIGNON,Ingredients.OIGNON));
        Plat soupeTomate = new Plat(8,"Soupe Tomate",Arrays.asList(Ingredients.TOMATE,Ingredients.TOMATE,Ingredients.TOMATE));
        Plat soupeChampi = new Plat(8,"Soupe Champignon",Arrays.asList(Ingredients.CHAMPIGNON,Ingredients.CHAMPIGNON,Ingredients.CHAMPIGNON));
        Plat burgerComplet = new Plat(15,"Burger Complet",Arrays.asList(Ingredients.PAIN,Ingredients.STEAK,Ingredients.TOMATE,Ingredients.SALADE));
        Plat burgerMid = new Plat(15,"Burger Mid",Arrays.asList(Ingredients.PAIN,Ingredients.STEAK,Ingredients.SALADE));
        Plat burgerClassique = new Plat(15,"Burger Classique",Arrays.asList(Ingredients.PAIN,Ingredients.STEAK));
        Plat pizza = new Plat(12, "Pizza",Arrays.asList(Ingredients.PÂTE,Ingredients.TOMATE,Ingredients.FROMAGE));
        Plat pizzaChampi = new Plat(12, "Pizza Champignon",Arrays.asList(Ingredients.PÂTE,Ingredients.TOMATE,Ingredients.FROMAGE,Ingredients.CHAMPIGNON));
        Plat pizzaPepperoni = new Plat(12, "Pizza Pepperoni",Arrays.asList(Ingredients.PEPPERONI,Ingredients.PÂTE,Ingredients.TOMATE,Ingredients.FROMAGE));
        Plat limonade = new Plat(4, "Limonade",Arrays.asList(Ingredients.LIMONADE));
        Plat cidre = new Plat(5, "Cidre Doux",Arrays.asList(Ingredients.CIDRE));
        Plat biere = new Plat(5, "Bière sans alcool",Arrays.asList(Ingredients.BIERE));
        Plat jus = new Plat(1, "Jus de fruit",Arrays.asList(Ingredients.JUS));
        Plat eau =new Plat(0, "Eau",Arrays.asList(Ingredients.EAU));
        
        //Initialisation des cocktails du bar
        Plat vodkaMenthe = new Plat(10, "Vodka Menthe", Arrays.asList(Ingredients.VODKA, Ingredients.MENTHE));
        Plat vodkaFramboise= new Plat(10, "Vodka Framboise", Arrays.asList(Ingredients.VODKA, Ingredients.FRAMBOISE));
        Plat rhumOrange = new Plat(10, "Rhum Orange", Arrays.asList(Ingredients.RHUM, Ingredients.ORANGE));
        
        //ajout des plats dans le menu
        this.menu = Arrays.asList(
        		saladeDeluxe, salade, soupeOignon, soupeTomate, soupeChampi,
                burgerComplet, burgerMid, burgerClassique, pizza, pizzaChampi,
                pizzaPepperoni, limonade, cidre, biere, jus, eau, vodkaMenthe, 
                vodkaFramboise, rhumOrange
            );
	}
	
}
