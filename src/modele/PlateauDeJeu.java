package modele;

import java.util.ArrayList;

public class PlateauDeJeu {
    private ArrayList<Joueur> listeJoueurs;
    private ArrayList<Personnage> listePersonnages;
    private Pioche pioche;
    private int nbPersonnages;
    private int nbJoueurs;

    public PlateauDeJeu() {
        this.listeJoueurs = new ArrayList<>();
        this.listePersonnages = new ArrayList<>();
        this.pioche = new Pioche();
        this.nbPersonnages = 0;
        this.nbJoueurs = 0;
    }

    public int getNbJoueurs() {
        return nbJoueurs;
    }

    public int getNbPersonnages() {
        return nbPersonnages;
    }

    public Pioche getPioche() {
        return pioche;
    }

    public Joueur getJoueur(int i) {
        if (i >= 0 && i < listeJoueurs.size()) {
            return listeJoueurs.get(i);
        } else {
            return null;
        }
    }

    public Personnage getPersonnage(int i) {
        if (i >= 0 && i < listePersonnages.size()) {
            return this.listePersonnages.get(i);
        } else {
            return null;
        }
    }

    public void ajouterPersonnage(Personnage nouveauPersonnage) {
        if (nouveauPersonnage != null && this.listePersonnages.size() < 9) {
            listePersonnages.add(nouveauPersonnage);
            nouveauPersonnage.setPlateau(this); // Association du plateau au personnage
            nbPersonnages++;

        }
    }

    public void ajouterJoueur(Joueur nouveauJoueur) {
        if (nouveauJoueur != null && nbJoueurs < listeJoueurs.size() + 1) {
            listeJoueurs.add(nouveauJoueur);
            nbJoueurs++;
        }
    }


    public ArrayList<Personnage> getAllPersonnages(){ return this.listePersonnages;

    }
}
