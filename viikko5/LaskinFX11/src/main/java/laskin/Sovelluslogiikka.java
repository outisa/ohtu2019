package laskin;

public class Sovelluslogiikka {
 
    private int tulos;
    private int edellinen;
 
    public void plus(int luku) {
        tulos += luku;
    }
     
    public void miinus(int luku) {
        tulos -= luku;
    }
 
    public void nollaa() {
        tulos = 0;
    }
 
    public int tulos() {
        return tulos;
    }

    public void edellinen(int luku) {
        this.edellinen = luku;
    }
    public int undo() {
        tulos = edellinen;
        return tulos;
    }
}