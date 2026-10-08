

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("       1. GESTION DES SAUVETEURS");
        System.out.println("==========================================");

        // Création de la liste de pilotes / sauveteurs
        List<Rescuer> listeSauveteurs = new ArrayList<>();

        // Création de sauveteurs initiaux
        Rescuer r1 = new Rescuer("Dupont", "Jean", 25, "Secouriste en montagne");
        Rescuer r2 = new Rescuer("Martin", "Sophie", 30, "Pilote de drone");
        Rescuer r3 = new Rescuer("Avocetien", "Jessie", 20, "Ingénieur Sauvetage");

        // Ajout à la liste
        listeSauveteurs.add(r1);
        listeSauveteurs.add(r2);
        listeSauveteurs.add(r3);

        // Affichage des sauveteurs créés
        System.out.println("\n--- Liste initiale des sauveteurs ---");
        for (Rescuer r : listeSauveteurs) {
            r.afficher();
        }

        // --- Test des contrôles de modification (Setters) ---
        System.out.println("\n--- Test des contrôles de modification sur Jean Dupont ---");
        
        System.out.print("1. Tentative de changer le nom par 'Al' (trop court) : ");
        r1.setName("Al"); // Doit afficher une erreur (< 3 caractères)
        
        System.out.print("2. Tentative de changer l'âge à 16 ans (mineur) : ");
        r1.setAge(16); // Doit afficher une erreur (mineur)

        System.out.print("3. Changement valide du prénom en 'Alexandre' : ");
        r1.setFirstName("Alexandre"); // Doit fonctionner
        r1.afficher(); // Vérification de la modification


        // --- Test de la recherche par nom ---
        System.out.println("\n--- Recherche d'un sauveteur par son nom ---");
        rechercherSauveteurParNom(listeSauveteurs, "Martin");
        rechercherSauveteurParNom(listeSauveteurs, "Inconnu");


        System.out.println("\n==========================================");
        System.out.println("          2. GESTION DES DRONES");
        System.out.println("==========================================");

        // Création de la liste de drones
        List<Drone> listeDrones = new ArrayList<>();

        // Drone 1 : Initialisé à l'origine (0, 0, 0)
        Drone d1 = new Drone("DRONE-ALPHA");

        // Drone 2 : Initialisé à des coordonnées quelconques (10, 15, 20)
        Drone d2 = new Drone("DRONE-BETA", 10, 15, 20);

        listeDrones.add(d1);
        listeDrones.add(d2);

        // --- Démarrage et déplacement du Drone 1 ---
        System.out.println("\n--- Démarrage et déplacements du Drone ALPHA ---");
        d1.demarrer();
        d1.deplacer(6, 8, 12); // Nouveau point : (6, 8, 12)

        System.out.println("Distance de DRONE-ALPHA par rapport à l'origine (0,0,0) : " 
                           + d1.calculerDistanceOrigine() + " mètres");

        // --- Démarrage et déplacement du Drone 2 ---
        d2.demarrer();
        System.out.println("Position actuelle de DRONE-BETA : (" 
                           + d2.getPosX() + ", " + d2.getPosY() + ", " + d2.getPosZ() + ")");

        // --- Test de l'alerte de proximité entre deux drones ---
        System.out.println("\n--- Test de détection de proximité (Seuil = 15m) ---");
        d1.verifierAlerteProximite(d2, 15.0); // Déclenche une alerte car ils sont proches

        System.out.println("\n--- Éloignement du DRONE-ALPHA ---");
        d1.deplacer(50, 50, 10); // Éloigne le drone
        d1.verifierAlerteProximite(d2, 15.0); // Ne déclenche plus d'alerte


        // --- Test de crash d'un drone ---
        System.out.println("\n--- Test de crash du DRONE-BETA (altitude négative) ---");
        d2.deplacer(0, 0, -50); // Le drone tente d'aller sous terre
    }

    /**
     * Méthode auxiliaire pour rechercher un sauveteur par nom dans la liste
     */
    public static void rechercherSauveteurParNom(List<Rescuer> liste, String nomRecherche) {
        boolean trouve = false;
        for (Rescuer r : liste) {
            if (r.getName().equalsIgnoreCase(nomRecherche)) {
                System.out.print(" -> Sauveteur trouvé : ");
                r.afficher();
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println(" -> Aucun sauveteur trouvé avec le nom : " + nomRecherche);
        }
    }
}