import java.util.Scanner;

public class Serveur extends Employe {

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
            System.out.println("1- Soupe Oignon");
        }
        if (verifDispo("Soupe Tomate")) {
            System.out.println("1- Soupe Tomate");
        }
        if (verifDispo("Soupe Champignon")) {
            System.out.println("1- Soupe Champignon");
        }
        if (verifDispo("Burger Complet")) {
            System.out.println("1- Burger Complet");
        }
        if (verifDispo("Burger Mid")) {
            System.out.println("1- Burger Mid");
        }
        if (verifDispo("Burger Classique")) {
            System.out.println("1- Burger Classique");
        }
        if (verifDispo("Pizza")) {
            System.out.println("1- Pizza");
        }
        if (verifDispo("Pizza Champignon")) {
            System.out.println("1- Pizza Champignon");
        }
        if (verifDispo("Pizza Pepperoni")) {
            System.out.println("1- Pizza Pepperoni");
        }
        if (verifDispo("Limonade")) {
            System.out.println("1- Limonade");
        }
        if (verifDispo("Cidre Doux")) {
            System.out.println("1- Cidre Doux");
        }
        if (verifDispo("Bière sans alcool")) {
            System.out.println("1- Bière sans alcool");
        }
        if (verifDispo("Jus de fruit")) {
            System.out.println("1- Jus de fruit");
        }
        if (verifDispo("Eau")) {
            System.out.println("1- Eau");
        }
        
        System.out.println("-------------");
    }

    private boolean verifDispo(String plat) {
        // Logique de vérification de disponibilité du plat (à implémenter selon votre besoin)
        // Retourner true si le plat est disponible, false sinon
        // Vous pouvez utiliser une classe Stock pour gérer les stocks de chaque plat
        return Stock.verifierDisponibilite(plat);
    }

    private void ajouterCommande() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel plat souhaitez-vous ?");
        
        afficherPlatsDisponibles();

        int choixEcran = scanner.nextInt();
        String nomPlat = getNomPlat(choixEcran);

        // Vérifier la disponibilité du plat
        if (verifDispo(nomPlat)) {
            // Retirer le plat du stock
            Stock.retirerStock(nomPlat);
            System.out.println("Vous avez choisi le plat : " + nomPlat);
        } else {
            System.out.println("Le plat n'est plus disponible. Veuillez choisir un autre plat.");
            ajouterCommande(); // Relancer la fonction pour choisir un autre plat
        }
    }

    private String getNomPlat(int choix) {
        switch (choix) {
            case 1: return "Salade Deluxe";
            // Ajouter les autres cas pour les autres plats...
            default: return ""; // Gérer le cas par défaut selon vos besoins
        }
    }
}
