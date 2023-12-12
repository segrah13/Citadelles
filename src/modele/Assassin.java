package modele;
import controleur.Interaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Assassin extends Personnage {
    public Assassin() {
        super("Assassin", 1, Caracteristiques.ASSASSIN, 1);
    }

    @Override
    public void utiliserPouvoir() {
        if (this.getPlateau() != null) {
            ArrayList<Personnage> allPersonnage = this.getPlateau().getAllPersonnages();
            for (Personnage personnage : allPersonnage) {
                System.out.println(personnage.getNom());
            }
            System.out.println("Quel personnage voulez-vous assassiner ?");
            int personnageChoisi = Interaction.lireUnEntier(0, allPersonnage.size());

            if (this.getPlateau().getPersonnage(personnageChoisi).getNom().equals("Assassin"))
                System.out.println("Vous ne pouvez pas vous assassinez vous meme");
            else {
                this.getPlateau().getPersonnage(personnageChoisi).setEstAssassine();
                System.out.println("Vous avez assassiné " + this.getPlateau().getPersonnage(personnageChoisi).getNom());
            }

        }
    }
}
