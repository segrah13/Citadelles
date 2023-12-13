package modele;

import controleur.Interaction;

import java.util.ArrayList;

public class Condottiere extends Personnage {
    public Condottiere() {
        super("Condottiere", 8, Caracteristiques.CONDOTTIERE, 1);
    }

    public void utiliserPouvoir() {
        if (this.getEstAssassine()) {
            System.out.println("Ce personnage est mort");
            return;
        }
        System.out.println("Voulez-vous utiliser votre pouvoir de destruction ? (o/n)");
        if (!Interaction.lireOuiOuNon()) {
            return;
        }
        System.out.println("Voici la liste des joueurs et le contenu de leur cité :");
        imprimerJoueurs();
        System.out.println("Pour information vous avez " + getJoueur().getTresor() + " pièce(s) d'or");
        int choix = choisisJoueur();
        if (choix == -1) {
            return;
        }
        Joueur joueur = getPlateau().getJoueur(choix);
        choix = choisisQuartier(joueur);
        Quartier quartier = joueur.getCite().get(choix);
    }
    private void imprimerJoueurs() {
        for (int i = 0; i < getPlateau().getNbJoueurs(); i++) {
            Joueur joueur = getPlateau().getJoueur(i);
            System.out.print(i + 1 + " " + joueur.getNom() + ": ");
            for (int j = 0; j < joueur.getCite().size(); j++) {
                Quartier q = joueur.getCite().get(j);
                System.out.print(j + 1 + " " + q.getNom() + " (coût " + q.getCoutConstruction() + "), ");
            }
            System.out.println();
        }
    }
    private int choisisJoueur(){
        while(1 > 0){
            System.out.println("Quel joueur choisissez-vous ?  (0 pour ne rien faire)");
            int choix = Interaction.lireUnEntier(0, this.getPlateau().getNbJoueurs() + 1) - 1;
            if (choix == -1) {
                return -1;
            }
            Joueur joueurChoisi = getPlateau().getJoueur(choix);
            boolean eveque = false;
            for (int i = 0; i < getPlateau().getNbPersonnages(); i++) {
                Personnage personnage = getPlateau().getPersonnage(i);
                if (personnage.getJoueur() == joueurChoisi && personnage.getNom().equals("Eveque")) {
                    System.out.println("L'eveque ne peux pas etre choisi.");
                    eveque = true;
                }
            }
            if (eveque) {
                continue;
            }
            int min_cout = 999;
            boolean grandeMuraille = false;
            for (int i = 0; i < joueurChoisi.getCite().size(); i++) {
                if (joueurChoisi.getCite().get(i).getNom().equals("GrandeMuraille")) {
                    grandeMuraille = true;
                }
                if (!joueurChoisi.getCite().get(i).getNom().equals("Donjon")) {
                    min_cout = Math.min(min_cout, joueurChoisi.getCite().get(i).getCoutConstruction());
                }
            }
            if (grandeMuraille) {
                min_cout++;
            }
            if (min_cout > getJoueur().getTresor()) {
                System.out.println("Joueur a des quartiers trop chers.");
                continue;
            }
            return choix;
        }
    }

    private int choisisQuartier(Joueur joueur){
        boolean grandeMuraille = false;
        for (int i = 0; i < joueur.getCite().size(); i++) {
            if (joueur.getCite().get(i).getNom().equals("GrandeMuraille")) {
                grandeMuraille = true;
            }
        }

        System.out.println("Quel quartier choisissez-vous ?");
        while (1 > 0) {

            int choix = Interaction.lireUnEntier(1, joueur.nbQuartiersDansCite() + 1) - 1;
            int coutConstruction = joueur.getCite().get(choix).getCoutConstruction();
            if (grandeMuraille) {
                coutConstruction++;
            }
            if (coutConstruction > getJoueur().getTresor()) {
                System.out.println("Votre trésor n'est pas suffisant.");
                System.out.println("Votre choix ? ");
                continue;

            }
            if (joueur.getCite().get(choix).getNom().equals("Donjon")) {
                System.out.println("Vous ne pouvez pas selectionner le donjon.");
                System.out.println("Votre choix ? ");
                continue;
            }
            return choix;
        }
    }

    public void percevoirRessourcesSpecifiques() {
        if (getEstAssassine()) {
            return;
        }
        ArrayList<Quartier> cite = this.getJoueur().getCite();
        int piece = 0;
        for (int i = 0; i < cite.size(); ++i) {
            if (cite.get(i) != null && cite.get(i).getType().equals("MILITAIRE")) {
                piece++;
            }
            if (cite.get(i) != null && cite.get(i).getNom().equals("Ecole de Magie")) {
                piece++;
                System.out.println("L'ecole de magie vous rapporte une piece de plus");
            }
        }
        this.getJoueur().ajouterPieces(piece);
    }
}
