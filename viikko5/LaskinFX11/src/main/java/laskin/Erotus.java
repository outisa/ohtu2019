package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Komento {
  TextField tuloskentta;
  TextField syotekentta;
  Button nollaa;
  Button undo;
  Sovelluslogiikka sovellus;
  

  public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
    this.tuloskentta = tuloskentta;
    this.syotekentta = syotekentta;
    this.nollaa = nollaa;
    this.undo = undo;
    this.sovellus = sovellus;

  }

@Override
  public void suorita() {
    if (!syotekentta.getText().equals("")) {
      int arvo = Integer.parseInt(syotekentta.getText());
      sovellus.miinus(arvo);
      syotekentta.setText("");
      tuloskentta.setText("" + sovellus.tulos()); 
    } 
    
  }

  @Override
  public void peru() {
    
  }

}