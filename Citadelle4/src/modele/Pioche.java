package modele;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pioche extends Quartier{
    private List<Quartier> listeQuartiers;
    public Pioche(){
        this.listeQuartiers = new ArrayList<>();
    }



    public Quartier piocher(){
        if(!listeQuartiers.isEmpty()) {
            Quartier cartePiochee = listeQuartiers.get(0);
            listeQuartiers.remove(0);
            System.out.println(cartePiochee.getNom());
            return cartePiochee;
        } else{
            return null;
        }
    }

    public void ajouter(Quartier nouveau){
        listeQuartiers.add(nouveau);
        System.out.println(nouveau.getNom());
    }

    public int nombreQuartiersDansPioche(){
        return listeQuartiers.size();
    }
    public void melanger(){
        Collections.shuffle(listeQuartiers);
    }
}
