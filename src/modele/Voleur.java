package modele;

import controleur.Interaction;

import java.util.ArrayList;

public class Voleur extends Personnage{
    public Voleur(){
        super("Voleur", 2, Caracteristiques.VOLEUR, 1);
    }

    @Override
    public void utiliserPouvoir() {
        if (this.getPlateau() != null) {
            ArrayList<Personnage> allPersonnage = this.getPlateau().getAllPersonnages();
            for (Personnage personnage : allPersonnage) {
                System.out.println(personnage.getNom());
            }
            System.out.println("Quel personnage voulez-vous voler ?");
            int personnageChoisi = Interaction.lireUnEntier(0, allPersonnage.size());

            if (this.getPlateau().getPersonnage(personnageChoisi).getNom().equals("Voleur"))
                System.out.println("Vous ne pouvez pas vous voler vous meme");

            else if(this.getPlateau().getPersonnage(personnageChoisi).getRang() == 1){
                System.out.println("Vous ne pouvez voler quelqu'un qui possède un personnage de rang 1");
            }

            else {
                this.getPlateau().getPersonnage(personnageChoisi).setEstVole();
                System.out.println("Vous avez volé " + this.getPlateau().getPersonnage(personnageChoisi).getNom());
        }



        }

    }
}
