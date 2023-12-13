package modele;

public class Roi extends Personnage {

    public Roi() {
        super("Roi", 4, Caracteristiques.ROI, 1);
    }

    public void percevoirRessourcesSpecifiques() {
        if (getPlateau() != null && getJoueur() != null && !getEstAssassine()) {
            int nombreQuartiersNobles = compterQuartiersNoblesDansCite();
            getJoueur().ajouterPieces(nombreQuartiersNobles);
            System.out.println(nombreQuartiersNobles);

            for (int i = 0; i < getPlateau().getNbPersonnages(); i++) {
                Personnage personnage = getPlateau().getPersonnage(i);
                if (personnage != null) {
                    personnage.setPossedeCouronne(false);
                }
            }
        }
    }

        private int compterQuartiersNoblesDansCite() {
            int nombreQuartiersNobles = 0;
            for (Quartier quartier : getJoueur().getCite()) {
                if (quartier.getType().equals(Quartier.TYPE_QUARTIERS[1])) {
                    nombreQuartiersNobles++;
                }
            }
            return nombreQuartiersNobles;
        }

    }
