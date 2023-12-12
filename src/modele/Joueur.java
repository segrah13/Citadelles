package modele;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
public class Joueur {
    private String nom;
    private int tresor;
    private ArrayList<Quartier> cite;
    private ArrayList<Quartier> mainJoueur;
    private boolean possedeCouronne;

    public Joueur(String nom) {
        this.nom = nom;
        this.tresor = 0;
        this.cite = new ArrayList<>();
        this.mainJoueur = new ArrayList<>();
        this.possedeCouronne = false;
    }

    public Joueur(String nom, int tresor, ArrayList<Quartier> cite, ArrayList<Quartier> mainJoueur, boolean possedeCouronne) {
        this.nom = nom;
        this.tresor =0;
        this.cite = cite;
        this.mainJoueur = mainJoueur;
        this.possedeCouronne = possedeCouronne;
    }

    public String getNom(){
        return nom;
    }

    public int getTresor(){
        return tresor;
    }

    public ArrayList<Quartier> getCite(){
        return cite;
    }

    public ArrayList<Quartier> getMainJoueur(){
        return mainJoueur;
    }

    public boolean getPossededeCouronne(){
        return possedeCouronne;
    }

    public void setPossedeCouronne(boolean b){
        this.possedeCouronne = b;
    }

   public void ajouterPieces(int nombreDePieces){
        if(nombreDePieces > 0){
            tresor+=nombreDePieces;
            System.out.println(nombreDePieces + "pièces ajoutées au trésor.");
        }
    }



    public void retirerPieces(int nombreDePieces){
        if (nombreDePieces > 0){
            if (nombreDePieces <= tresor){
                tresor -= nombreDePieces;

            }
        }
    }
    public int nbQuartiersDansCite(){
        return cite.size();
    }

    public int nbQuartiersDansMain(){
        return mainJoueur.size();
    }

    public void ajouterQuartierDansCite(Quartier quartier){
        cite.add(quartier);

    }





    public boolean quartierPresentDansCite(String nomQuartiers){
        for(Quartier quartier : cite){
            if (quartier.getNom().equals(nomQuartiers)){
                return true;
            }
        }
        return false;
    }

    public boolean retirerQuartierDansCite(String nomQuartier){
        Iterator<Quartier> iterator = cite.iterator();
        while(iterator.hasNext()){
            Quartier quartier = iterator.next();
            if (quartier.getNom().equals(nomQuartier)){
                iterator.remove();

            }
        }

        return false;
    }

    public void ajouterQuartierDansMain(Quartier quartier){
        mainJoueur.add(quartier);
    }

    public Quartier retirerQuartierDansMain(){
        Random generateur = new Random();
        int numeroHasard = generateur.nextInt(this.nbQuartiersDansMain());
        if(mainJoueur.isEmpty()) {
            return null;
        } else {
        return this.mainJoueur.remove(numeroHasard);
        }
    }
    public void reinitialiser(){
        tresor = 0;
        mainJoueur.clear();
        cite.clear();

    }


}


