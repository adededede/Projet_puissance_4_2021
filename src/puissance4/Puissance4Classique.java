package puissance4;

import puissance4.puissance4controleur.ControleurClassique;
import puissance4.puissance4modele.Partie;
import puissance4.puissance4vue.VueGrilleClassique;


public class Puissance4Classique {
    public static void main(String[] args) {
        try{
            // Création de la partie
            Partie p = new Partie("Joueur 1","Joueur 2",6,7);

            // Contrôleur
            ControleurClassique c = new ControleurClassique(p);

            // Vue
            VueGrilleClassique vueGrilleClassique = new VueGrilleClassique(c);
        }catch (Exception ignored){
        }
    }
}
