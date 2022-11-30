package puissance4.puissance4controleur;

import puissance4.observateursujet.Sujet;
import puissance4.puissance4modele.Couleur;
import puissance4.puissance4modele.Jeton;
import puissance4.puissance4modele.Joueur;
import puissance4.puissance4modele.Partie;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ControleurClassique extends Sujet {

    public static final int NB_TYPE_JETONS = 1;

    private Partie p;
    private Joueur joueurCourant;
    private Jeton jetonCourant;
    private int colonneCourante;

    public ControleurClassique(Partie p){
        this.p = p;
        joueurCourant = getJoueurSuivant();
        distribuerJetons();
    }

    public void avancer(){
        if(!finPartie()){
            if(colonneCourante == -1){
                System.out.println("Colonne non selectionné");
                return;
            }
            if(!joueurCourant.jouerJeton(jetonCourant)) {
                System.out.println("Le joueur n'a pas ce jeton en sa possession");
                return;
            }
            if(!p.getPlateau().recoitJeton(jetonCourant, colonneCourante)){
                System.out.println("Le plateau ne peut pas jouer ce jeton dans cette colonne");
                return;
            }
            if(puissance4()){ // si il y a un gagnant
                System.out.println("VICTOIRE DE "+ joueurCourant);
            }else{
                joueurCourant = getJoueurSuivant();
                jetonCourant = null;
                colonneCourante = -1;
            }
        }
        notifierObservateurs();
    }



    public boolean finPartie(){
        return p.getPlateau().estPleine() || puissance4();
    }
    public boolean puissance4(){
        return p.victoire();
    }
    public boolean egalite(){ return p.getPlateau().estPleine() && !puissance4();}

    /**
     * Distribue les jetons
     */
    private void distribuerJetons(){
        Joueur[] joueurs = p.getJoueurs();
        for(int i = 0; i< 30; i++){
            joueurs[0].recevoirJeton(new Jeton(Couleur.JAUNE));
            joueurs[1].recevoirJeton(new Jeton(Couleur.ROUGE));
        }
    }


    // -------------------------------------------
    //          GETTER / SETTER
    // -------------------------------------------

    public Jeton getJetonCourant(){return  jetonCourant;}
    public void setJetonCourant(Jeton jetonJoue){
        this.jetonCourant=jetonJoue;
    }

    public Joueur getJoueurCourant(){
        return joueurCourant;
    }

    public Partie getPartie(){
        return p;
    }
    /** @return renvoie le Joueur gagnant, null si pas de gagnant  */


    private Joueur getJoueurSuivant(){
        return (p.getJoueurs()[0] == joueurCourant) ? p.getJoueurs()[1] : p.getJoueurs()[0];
    }
    public int getColonneCourante(){ return colonneCourante;}
    public void setColonneCourante(int col) { colonneCourante = col;}




}
