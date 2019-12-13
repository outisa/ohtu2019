package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends KPS{

    public KPSPelaajaVsPelaaja(IO io) {
        super(io);
    }
 
    @Override
    protected String annaSiirto() {
        io.print("Toisen pelaajan siirto: ");
        String tokanSiirto = io.nextLine();
        return tokanSiirto;
    }

    @Override
    protected void tulostaValinta(String tokanSiirto) {
    }

    @Override
    protected void asetaSiirto(String ekanSiirto) {
    }
}