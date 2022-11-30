package puissance4.puissance4modele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partie {

    private Joueur joueur1;
    private Joueur joueur2;

    private Plateau p;


    /**
     *
     * @param pseudoJoueur1 pseudonyme du joueur 1
     * @param pseudoJoueur2 pseudonyme du joueur 2
     */
    public Partie(String pseudoJoueur1,String pseudoJoueur2, int hauteur, int largeur){
        this(new Joueur(pseudoJoueur1),new Joueur(pseudoJoueur2));
        p = new Plateau(hauteur,largeur);
    }

    private Partie(Joueur j1, Joueur j2){
        joueur1 = j1;
        joueur2 = j2;
    }


    public Plateau getPlateau(){
        return p;
    }

    public Joueur[] getJoueurs(){
        return new Joueur[]{joueur1,joueur2};
    }

    public boolean victoire(){
        Jeton[][] grille = p.getGrille();
        int ptw = 4; // pions to wins
        int largeur = grille.length;
        int hauteur = grille[0].length;

        int ali = 1; // nombre de jeton aligné

        // Bas en haut
        for( int col = 0; col < largeur; col++){
            for(int lig = 0; lig < hauteur - (ptw - 1); lig++){ // on ne teste pas si il reste ptw -1 jetons
              Jeton jeton = grille[col][lig];
              if(jeton == null) // si le jeton au dessus est null tout les autres aussi, on passe à la col suivante
                  break;
              boolean win = true;
              for(int i =1; i < ptw && win; i++){
                  win &= jeton.equals(grille[col][lig + i]);
              }
              if (win)
                  return true;
            }
        }

        // Gauche à droite
        for(int lig = 0; lig < hauteur; lig++){
            for(int col = 0; col < largeur - (ptw -1); col++){
                Jeton jeton = grille[col][lig];
                if(jeton != null){ // on ne passe pas à la col suivante si c'est null
                    boolean win = true;
                    for(int i = 1; i < ptw && win; i++){
                        win &= jeton.equals(grille[col+i][lig]);
                    }
                    if(win)
                        return true;
                }
            }
        }

        // Bas à Gauche vers Haut à Droite
        for(int lig = 0; lig < hauteur - (ptw -1); lig++){
            for(int col = 0; col < largeur - (ptw -1); col++){
                Jeton jeton = grille[col][lig];
                if(jeton != null){
                boolean win = true;
                for(int i = 1; i < ptw && win; i++){
                    win &= jeton.equals(grille[col + i][lig + i]);
                }
                if(win)
                    return true;
                }
            }
        }

        // Bas à Droite vers Haut à Gauche
        for(int lig =0; lig < hauteur - (ptw -1); lig ++){
            for(int col = largeur -1; col > (ptw-1)-1; col --){
                Jeton jeton = grille[col][lig];
                if(jeton != null){
                    boolean win = true;
                    for(int i = 1; i < ptw && win; i++){
                        win &= jeton.equals(grille[col - i][lig + i]);
                    }
                    if(win)
                        return true;
                }
            }
        }


        return false; // pas de gagnant
    }

}
