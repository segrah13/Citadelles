package modele;

public class PlateauDeJeu {
    private Joueur[] listeJoueurs;
    private Personnage[] listePersonnages;
    private Pioche pioche;
    private int nbPersonnages;
    private int nbJoueurs;

    public PlateauDeJeu() {
        this.listeJoueurs = new Joueur[9];
        this.listePersonnages = new Personnage[9];
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
        if (i >= 0 && i < nbJoueurs) {
            return listeJoueurs[i];
        } else {
            return null;
        }
    }

    public Personnage getPersonnage(int i) {
        if (i > 0 && i < nbJoueurs) {
            return listePersonnages[i];
        } else {
            return null;
        }
    }

    public void ajouterPersonnage(Personnage nouveauPersonnage) {
        if (nouveauPersonnage != null && nbPersonnages < listePersonnages.length) {
            listePersonnages[nbPersonnages] = nouveauPersonnage;
            nouveauPersonnage.setPlateau(this); // Association du plateau au personnage
            nbPersonnages++;
        }
    }

    public void ajouterJoueur(Joueur nouveauJoueur) {
        if (nouveauJoueur != null && nbJoueurs < listeJoueurs.length) {
            listeJoueurs[nbJoueurs] = nouveauJoueur;
            nbJoueurs++;
        }
    }
}
