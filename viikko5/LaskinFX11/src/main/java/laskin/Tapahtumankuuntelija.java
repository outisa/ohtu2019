package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.*;

public class Tapahtumankuuntelija implements EventHandler {

    private final Button undo;
    private final Sovelluslogiikka sovellus;
    private final Map<Button, Komento> komennot;
    private Komento edellinen;

    public Tapahtumankuuntelija(final TextField tuloskentta, final TextField syotekentta, final Button plus,
            final Button miinus, final Button nollaa, final Button undo) {
        this.undo = undo;
        this.sovellus = new Sovelluslogiikka();
        komennot = new HashMap<>();
        this.edellinen = new Edellinen(tuloskentta, sovellus);
        

        komennot.put(plus, new Summa(tuloskentta, syotekentta, nollaa, undo, sovellus));
        komennot.put(miinus, new Erotus(tuloskentta, syotekentta, nollaa, undo, sovellus));
        komennot.put(nollaa, new Nollaa(tuloskentta, syotekentta, nollaa, undo, sovellus));

    }

    @Override
    public void handle(final Event event) {
        if (event.getTarget() != undo) {
            final Komento komento = komennot.get((Button) event.getTarget());
            edellinen.suorita();
            komento.suorita();
            
        } else {
            edellinen.peru();
            
        }

    }

}
