package ohtu.verkkokauppa;

import java.util.ArrayList;
//import org.springframework.stereotype.Component;

//@Component
public class Ostoskori {

    private ArrayList<Tuote> tuotteet;
    
    public Ostoskori() {
        this.tuotteet = new ArrayList<Tuote>();
    }

    public void lisaa(Tuote t) {
        this.tuotteet.add(t);
    }

    public void poista(Tuote t) {
        this.tuotteet.remove(t);
    }

    public int hinta() {
        int hinta = 0;

        for (Tuote tuote : this.tuotteet) {
            hinta += tuote.getHinta();
        }

        return hinta;
    }
}
