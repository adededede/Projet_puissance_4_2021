package puissance4.puissance4modele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Joueur {
    private final String pseudo;
    private List<Jeton> jetons;

    /**
     * Construit un joueur dont le pseudo est passé en argument.
     *
     * @param pseudo pseudo du joueur
     */
    public Joueur(String pseudo) {
        this.pseudo = pseudo;
        this.jetons = new ArrayList<>();
    }

    /**
     * Supprime le jeton passée en argument de la main du joueur.
     *
     * @return false si la colonne est pleine
     */
    public boolean jouerJeton(Jeton jeton){ // lancé action
        if(jeton == null){
            throw new IllegalArgumentException("Jeton null");
        }
        for ( Jeton j: jetons) {
            if(j.equals(jeton))
                return jetons.remove(j);
        }
        return false;
    }

    /**
     * Ajoute un jeton dans la main du joueur.
     *
     * Utilisé lors de la distribution des jetons
     * @param j le jeton à ajouter à la main du joueur
     */
    public void recevoirJeton( Jeton j) {
        jetons.add( j );
    }



    /**
     * Retourne les jetons du joueur
     *
     * @return les jetons de this
     */
    public List<Jeton> getJetons() {
        return jetons;
    }

    @Override
    public String toString(){
        return getPseudo();
    }

    /**
     *  Retourne une instance de jeton par type de jeton que le joueur peut jouer
     * @return ArrayList de jeton contenant un jeton par type de jeton que le joueur a en sa possession
     */
    public List<Jeton> getJetonsDisponibles(){
        ArrayList<Jeton> jetonDispo = new ArrayList<>();
        for(Jeton j : jetons){
            if(jetonDispo.isEmpty())
                jetonDispo.add(j);
            else{
                for(Jeton jd : jetonDispo){ // pour chaque jeton dans jeton dispo
                    if(!jd.equals(j)){ // on regarde si on l'a pas déjà ajouté
                        jetonDispo.add(j);
                        break;
                    }
                }
            }
        }
        return jetonDispo;
    }


    // GETTER / SETTER
    /**
     * Retourne le pseudo du joueur
     *
     * @return le pseudo de this
     */
    public String getPseudo(){
        return pseudo;
    }
}
