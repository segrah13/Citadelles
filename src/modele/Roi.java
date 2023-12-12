package modele;

public class Roi extends Personnage {

    public Roi() {
        super("Roi", 4, Caracteristiques.ROI, 1);
    }

    @Override
    public void percevoirRessourcesSpecifiques() {
        if (getJoueur() != null && !getEstAssassine()) {
            for (Quartier quartier : getJoueur().getCite()) {
                if (quartier.getType().equals(Quartier.TYPE_QUARTIERS[2])) {
                    getJoueur().ajouterPieces(1);
                }
            }

            /*
            for (int i = 0; i < getPlateau().getNbPersonnages(); i++) {
                Personnage personnage = getPlateau().getPersonnage(i);
                if (personnage != null) {
                    personnage.setPossedeCouronne(false);
                }
            }

             */
        }
    }

    @Override
    public void utiliserPouvoir() {

    }
}
