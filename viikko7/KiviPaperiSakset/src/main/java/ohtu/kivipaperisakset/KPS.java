package ohtu.kivipaperisakset;

public abstract class KPS {
    public IO io;
    public KPS(IO io) {
        this.io = io;
    }

    
    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        String ekanSiirto = ensimmaisenSiirto();
        String tokanSiirto = annaSiirto();
        tulostaValinta(tokanSiirto);
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            io.print(tuomari);
            io.print("");

            ekanSiirto = ensimmaisenSiirto();

            tokanSiirto = annaSiirto();
            tulostaValinta(tokanSiirto);
            asetaSiirto(ekanSiirto);

        }

        io.print("");
        io.print("Kiitos!");
        io.print(tuomari);
        }
        private static boolean onkoOkSiirto(String siirto) {
            return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
        }
        
        protected abstract String annaSiirto();
        protected abstract void tulostaValinta(String tokanSiirto);
        protected abstract void asetaSiirto(String ekanSiirto);

    private String ensimmaisenSiirto() {
        io.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = io.nextLine();
        return ekanSiirto;
    }
}
