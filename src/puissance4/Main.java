package puissance4;

import puissance4.puissance4modele.Couleur;
import puissance4.puissance4modele.Jeton;
import puissance4.puissance4modele.Joueur;
import puissance4.puissance4modele.Plateau;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Plateau plateau = new Plateau(6,8);
        ArrayList<Jeton> jetonsJ1 = new ArrayList<>();
        ArrayList<Jeton> jetonsJ2 = new ArrayList<>();
        Joueur joueur1 = new Joueur("Joueur 1");
        Joueur joueur2 = new Joueur("Joueur 2");
        for(int i = 0; i < 30 ; i++){
            joueur1.recevoirJeton(new Jeton(Couleur.JAUNE));
            joueur2.recevoirJeton(new Jeton(Couleur.ROUGE));
        }


        System.out.println("plateau jeton joué col 0 "+ plateau.recoitJeton(new Jeton(Couleur.JAUNE),0));
        System.out.println("plateau jeton joué col 1 " + plateau.recoitJeton(new Jeton(Couleur.ROUGE),1));
        System.out.println("plateau jeton joué col 0 "+ plateau.recoitJeton(new Jeton(Couleur.JAUNE),0));



        System.out.println("Affichage de la grille (vide)");
        System.out.println(plateau);


        System.out.println("Joueur 1 joue " + joueur1.jouerJeton(new Jeton(Couleur.JAUNE)));
        System.out.println(plateau.getGrille().length);
        System.out.println("Affichage de la grille " +  plateau);

    }
}
