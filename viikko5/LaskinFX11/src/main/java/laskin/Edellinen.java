package laskin;

import javafx.scene.control.TextField;

public class Edellinen extends Komento {
  String edellinen;
  TextField tuloskentta;
  Sovelluslogiikka sovellus;


  public Edellinen(TextField tuloskentta, Sovelluslogiikka sovellus) {
    this.edellinen = tuloskentta.getText();
    this.tuloskentta = tuloskentta;
    this.sovellus = sovellus;
  
  }
  @Override
  public void suorita() {   
    sovellus.edellinen(Integer.parseInt(tuloskentta.getText()));
  }

  @Override
  public void peru() {
    this.tuloskentta.setText(""+ sovellus.undo());

  }
  
} 