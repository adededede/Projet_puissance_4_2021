package puissance4.puissance4modele;

import java.util.Arrays;
import java.util.Stack;

public class Plateau {
    private Stack<Jeton>[] grille;
    int hauteur;
    int largeur;

    public Plateau(int hauteur, int largeur){
        this.hauteur = hauteur;
        this.largeur = largeur;
        grille = new Stack[largeur];
        for(int i= 0; i<grille.length;i++){
            grille[i] = new Stack<>(); // la pile n'a pas de taille fixe
        }
    }

    public boolean recoitJeton(Jeton j, int colonne){
        // test colonnes
        boolean aJouer = true;
        if(grille[colonne].size() >= hauteur){
            aJouer = false;
        }else {
            grille[colonne].add(j);
        }
        return aJouer;
    }

    public Jeton[][] getGrille(){
        Jeton tab[][] = new Jeton[largeur][hauteur];
        for(int i = 0;i < largeur;i++){
            for(int j = 0; j < grille[i].size(); j++){
                tab[i][j] = grille[i].elementAt(j);
            }
        }
        return tab;
    }

    // sert à l'affichage de la grille
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder("");
        Jeton[][] grilleTab = getGrille();
        for (int j = hauteur-1; j >=0; j--) {// pour bien afficher, on commence par afficher la hauteur la plus haute
            res.append("[");
            for (int i = 0; i < largeur; i++) {
                res.append(grilleTab[i][j]);
                if (i != largeur-1) res.append(",");
            }
            res.append("]\n");
        }
        return res.toString();
    }

    /**
     *
     * @return Renvoie vrai si la grille est pleine
     */
    public boolean estPleine(){
        int size = 0;
        for( Stack<Jeton> s : grille){
            size += s.size();
        }
        return (hauteur * largeur) == size;
    }
}
