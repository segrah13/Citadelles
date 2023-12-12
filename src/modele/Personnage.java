package modele;

public abstract class Personnage{
    private String nom;
    private int rang;
    private String caracteristiques;
    private int nbPermisDeContstruire;
    private Joueur joueur;
    private boolean estAssassine;
    private boolean estVole;
    private PlateauDeJeu plateau;


    public Personnage(String nom, int rang, String caracteristiques, int nbPermisDeContstruire){
        this.nom=nom;
        this.rang=rang;
        this.caracteristiques=caracteristiques;
        this.nbPermisDeContstruire=nbPermisDeContstruire;
        this.joueur= null;
        this.estAssassine= false;
        this.estVole=false;
    }

    public String getNom(){return nom;}
    public int getRang(){ return rang;}
    public String getCaracteristiques(){return caracteristiques;}
    public int getNbPermisDeConstruire(){return nbPermisDeContstruire;}
    public Joueur getJoueur(){return joueur;}
    public boolean getEstAssassine(){return estAssassine;}
    public boolean getEstVole(){return estVole;}

    public void setJoueur(Joueur j){ this.joueur= j;}
    public void setEstAssassine(){this.estAssassine=true;}
    public void setEstVole(){this.estVole=true;}

    public void ajouterPieces(){
        if (joueur != null && !estAssassine) {
            joueur.ajouterPieces(2);
        }else {

        }
    }

    public void ajouterQuartier(Quartier nouveau){
        if (joueur != null && !estAssassine){
            joueur.ajouterQuartierDansMain(nouveau);
        }
    }

    public void construire(Quartier nouveau){
        if (joueur != null && !estAssassine){
            joueur.ajouterQuartierDansCite(nouveau);
        }
    }
    public void percevoirRessourcesSpecifiques(){
        if (joueur != null && !estAssassine){
        }
    }
    public void reinitialiser(){

        this.joueur=null;
        this.estAssassine=false;
        this.estVole=false;
    }

    public PlateauDeJeu getPlateau() {
        return plateau;
    }

    public void setPlateau(PlateauDeJeu plateau){
        this.plateau=plateau;
    }

    protected void setPossedeCouronne(boolean b) {
    }

    public abstract void utiliserPouvoir();
}


