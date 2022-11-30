package puissance4.puissance4vue;

import puissance4.observateursujet.Observateur;
import puissance4.puissance4controleur.ControleurClassique;
import puissance4.puissance4modele.Couleur;
import puissance4.puissance4modele.Jeton;
import puissance4.puissance4modele.Joueur;
import puissance4.puissance4modele.Partie;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public class VueGrilleClassique extends JFrame implements Observateur {
    Joueur joueur;
    ControleurClassique controleur;
    JLabel[][] cases; // on utilise un tableau de JLabel pour les cases

    public VueGrilleClassique(ControleurClassique controleur){
        this.controleur = controleur;
        controleur.ajouterObservateur(this);
        int hauteur = 6;
        int largeur = 7;

        // faire la grille
        JPanel jpGrille = new JPanel(new GridLayout(hauteur+1,largeur));

        JLabel jlJoueur1 = new JLabel(" "+(controleur.getPartie().getJoueurs())[0].getPseudo()+" : ");
        jlJoueur1.setBackground(Color.yellow);
        JLabel jlJoueur2 = new JLabel(" "+(controleur.getPartie().getJoueurs())[1].getPseudo()+" : ");
        jlJoueur2.setBackground(new Color(226, 61, 40));

        // un bouton au dessus de chaque colonne de la grille
        for(int i = 0; i < largeur; i++){
            JButton btn = new JButton();
            // si clic jouerJeton()
            int finalI = i;
            btn.addActionListener(e -> jouerJeton(finalI)); // choix de la colonne à jouer
            btn.setText("Placer jeton");
            jpGrille.add(btn);
        }

        cases = new JLabel[largeur][hauteur];
        // ajout label "cases"
        for (int i = 0; i< hauteur; i++){
            for (int j = 0; j < largeur; j++){
                JLabel jl = new JLabel();
                jl.setOpaque(true);
                jl.setBackground(new Color(34,76,152));
                Border bord = BorderFactory.createLineBorder(Color.BLACK, 1);
                jl.setBorder(bord);

                jpGrille.add(jl);
                cases[j][hauteur-i-1] = jl;
            }
        }

        // Choix du jeton à jouer
        JList<Jeton> choixJeton = new JList<>();
        choixJeton.setVisibleRowCount(controleur.NB_TYPE_JETONS);
        choixJeton.setForeground(Color.BLUE);
        choixJeton.setFixedCellWidth(100);
        choixJeton.addListSelectionListener((e ->selectionJeton() ));


        JPanel jpPrincipal = (JPanel)this.getContentPane();
        jpPrincipal.add(jlJoueur1, BorderLayout.WEST);
        jpPrincipal.add(jlJoueur2, BorderLayout.EAST);
        jpPrincipal.add(jpGrille,BorderLayout.CENTER);
        jpPrincipal.add(choixJeton,BorderLayout.SOUTH);


        //fenetre principale
        this.setTitle("Puissance 4");
        this.setVisible(true);
        this.setBounds(500,200,500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);

        mettreAJour(); // pas mettreAJour tout de suite car getJoueurCourant null
    }

    // mettreAJour est appelé par le Controlleur lorsqu'il faut mettre l'affichage à jour
    @Override
    public void mettreAJour() {

        BorderLayout bl = (BorderLayout) getContentPane().getLayout();
        JList<Jeton> choixJeton = (JList<Jeton>) bl.getLayoutComponent(BorderLayout.SOUTH);

        if(choixJeton == null){
            System.out.println("choixJeton null");
        }

        // on met à jour les jetons que le joueur peut jouer
        choixJeton.setListData(controleur.getJoueurCourant().getJetonsDisponibles().toArray(Jeton[]::new));
        choixJeton.setSelectedValue(controleur.getJoueurCourant().getJetonsDisponibles().get(0),true);
        // mettre à jour l'affichage des case
        Jeton[][] grille = controleur.getPartie().getPlateau().getGrille();

        int rows = cases[0].length;
        int colums = cases.length;

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < colums; col++){
                if(grille[col][row] != null && grille[col][row].getCouleur() == Couleur.ROUGE){
                    cases[col][row].setBackground(new Color(226, 61, 40));
                }else if (grille[col][row] != null && grille[col][row].getCouleur() == Couleur.JAUNE){
                    cases[col][row].setBackground(Color.YELLOW);
                }
            }
        }
        if(controleur.puissance4()){
            JOptionPane.showMessageDialog(this,"Puissance 4 pour "+controleur.getJoueurCourant());
            return;
        }else if(controleur.egalite()){
            JOptionPane.showMessageDialog(this,"Fin partie égalité");
            return;
        }
    }

    protected void jouerJeton(int colonne){
        if(controleur.getJetonCourant() == null){
            System.out.println("Vue jouerJeton getJetonCourant null");
            return;
        }
        controleur.setColonneCourante(colonne);
        controleur.avancer();
    }

    private void selectionJeton(){
        BorderLayout bl = (BorderLayout) getContentPane().getLayout();
        JList<Jeton> choixJeton = (JList<Jeton>) bl.getLayoutComponent(BorderLayout.SOUTH);
        if (choixJeton.getSelectedValue() != null) {
            controleur.setJetonCourant((Jeton)choixJeton.getSelectedValue());
            choixJeton.clearSelection();
        }
    }

}
