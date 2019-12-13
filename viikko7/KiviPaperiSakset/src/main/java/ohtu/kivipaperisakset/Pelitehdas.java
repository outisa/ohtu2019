package ohtu.kivipaperisakset;

public class Pelitehdas {

    public KPSPelaajaVsPelaaja kaksinpeli() { 
        return new KPSPelaajaVsPelaaja(new KonsoliIO());   
    }    
    
    public KPSParempiTekoaly pahaYksinpeli() {
        return new KPSParempiTekoaly(new KonsoliIO());
    }
    
    public KPSTekoaly yksinpeli() {
        return new KPSTekoaly(new KonsoliIO());
    }
}
