package ohtu.kivipaperisakset;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KPS {

    private final TekoalyParannettu tekoaly = new TekoalyParannettu(20);

    public KPSParempiTekoaly(IO io) {
        super(io);
    }

    @Override
    protected String annaSiirto() {
        return tekoaly.annaSiirto();
    }

    @Override
    protected void tulostaValinta(String tokanSiirto) {
        io.print("Tietokone valitsi: " + tokanSiirto); 
    }

    @Override
    protected void asetaSiirto(String ekanSiirto) {
        tekoaly.asetaSiirto(ekanSiirto);
    }

}
