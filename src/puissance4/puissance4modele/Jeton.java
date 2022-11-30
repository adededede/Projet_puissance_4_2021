package puissance4.puissance4modele;

public class Jeton {
    Couleur couleur;

    public Jeton(Couleur couleur){
        this.couleur = couleur;
    }

    public Couleur getCouleur(){ return couleur; }

    @Override
    public String toString(){
        return couleur.toString();
    }

    @Override
    public boolean equals(Object other){
        boolean res = false;
        if(this == other)
            res = true;
        else if (other instanceof Jeton){
            Jeton autreJeton = (Jeton) other;
            res = couleur == autreJeton.couleur;
        }
        return res;
    }
}
