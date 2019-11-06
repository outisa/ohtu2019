
package ohtu.verkkokauppa;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class Kirjanpito {
    private ArrayList<String> tapahtumat;

    public Kirjanpito() {
        this.tapahtumat = new ArrayList<>();
    }
    
    public void lisaaTapahtuma(String tapahtuma) {
        this.tapahtumat.add(tapahtuma);
    }

    public ArrayList<String> getTapahtumat() {
        return this.tapahtumat;
    }       
}
