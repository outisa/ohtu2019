
package ohtu.verkkokauppa;

//import org.springframework.stereotype.Component;

//@Component
public class Tuote {
    
    private int id;
    private String nimi;
    private int hinta;

    public Tuote(int id, String nimi, int hinta) {
        this.id = id;
        this.nimi = nimi;
        this.hinta = hinta;
    }

    @Override
    public boolean equals(Object o) {
        Tuote t = (Tuote)o;
        
        return this.id==t.id;
    }

    public int getId() {
        return this.id;
    }

    public int getHinta() {
        return this.hinta;
    }

    @Override
    public String toString() {
        return this.nimi;
    }            
    
}
