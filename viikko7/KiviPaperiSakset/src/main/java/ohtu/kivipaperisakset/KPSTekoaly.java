package ohtu.kivipaperisakset;

public class KPSTekoaly extends KPS{

    private final Tekoaly tekoaly = new Tekoaly();

    public KPSTekoaly(IO io) {
        super(io);
    }
    
    @Override
    protected String annaSiirto() {
        return tekoaly.annaSiirto();
    }

    @Override
    protected void asetaSiirto(String ekanSiirto) {
        tekoaly.asetaSiirto(ekanSiirto);
    }

    @Override
    protected void tulostaValinta(String tokanSiirto) {
        io.print("Tietokone valitsi: " + tokanSiirto); 
    }
}