import java.util.Scanner;

public class Serveur extends Employe {
	
	public Serveur(String nom, String prenom, double salaire, int soirDeSuite) {
        super(nom,prenom,salaire,soirDeSuite);   
    }

    public void commander() {
        Scanner scanner = new Scanner(System.in);

        ajouterCommande();

        // Boucle pour permettre au serveur de choisir des plats jusqu'à ce que la table ait fini de commander
        boolean tableTerminee = false;
        while (!tableTerminee) {
            System.out.println("Voulez-vous ajouter un plat ? (Oui/Non)");
            String reponse = scanner.next();

            if (reponse.equalsIgnoreCase("Oui")) {
                // Demander au serveur de choisir un plat
                ajouterCommande();

            } else if (reponse.equalsIgnoreCase("Non")) {
                tableTerminee = true;
                System.out.println("La table a terminé de commander.");
            } else {
                System.out.println("Veuillez répondre par 'Oui' ou 'Non'.");
            }
        }
    }

    private void afficherPlatsDisponibles() {
        System.out.println("Plats disponibles :");
        
        if (verifDispo("Salade Deluxe")) {
            System.out.println("1- Salade Deluxe");
        }
        if (verifDispo("Salade")) {
            System.out.println("2- Salade");
        }
        if (verifDispo("Soupe Oignon")) {
            System.out.println("3- Soupe Oignon");
        }
        if (verifDispo("Soupe Tomate")) {
            System.out.println("4- Soupe Tomate");
        }
        if (verifDispo("Soupe Champignon")) {
            System.out.println("5- Soupe Champignon");
        }
        if (verifDispo("Burger Complet")) {
            System.out.println("6- Burger Complet");
        }
        if (verifDispo("Burger Mid")) {
            System.out.println("7- Burger Mid");
        }
        if (verifDispo("Burger Classique")) {
            System.out.println("8- Burger Classique");
        }
        if (verifDispo("Pizza")) {
            System.out.println("9- Pizza");
        }
        if (verifDispo("Pizza Champignon")) {
            System.out.println("10- Pizza Champignon");
        }
        if (verifDispo("Pizza Pepperoni")) {
            System.out.println("11- Pizza Pepperoni");
        }
        if (verifDispo("Limonade")) {
            System.out.println("12- Limonade");
        }
        if (verifDispo("Cidre Doux")) {
            System.out.println("13- Cidre Doux");
        }
        if (verifDispo("Bière sans alcool")) {
            System.out.println("14- Bière sans alcool");
        }
        if (verifDispo("Jus de fruit")) {
            System.out.println("15- Jus de fruit");
        }
        if (verifDispo("Eau")) {
            System.out.println("16- Eau");
        }
        
        System.out.println("-------------");
    }

    public boolean verifDispo(Plat plat,Stock stock) {
        return stock.verifDispo(plat);
    }

    private void ajouterCommande() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel plat souhaitez-vous ?");
        
        afficherPlatsDisponibles();

        int choixEcran = scanner.nextInt();
        Plat plat = getNomPlat(choixEcran);

        // Vérifier la disponibilité du plat
        if (verifDispo(plat)) {
            // Retirer le plat du stock
            Stock.retirerStock(nomPlat);
            System.out.println("Vous avez choisi le plat : " + plat.nom);
        } else {
            System.out.println("Le plat n'est plus disponible. Veuillez choisir un autre plat.");
            ajouterCommande(); // Relancer la fonction pour choisir un autre plat
        }
    }

    private Plat getNomPlat(int choix) {
        switch (choix) {
            case 1: return salade;
            // Ajouter les autres cas pour les autres plats...
            default: return ""; // Gérer le cas par défaut selon vos besoins
        }
    }
}
