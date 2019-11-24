package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    private static IntJoukko A, B, C;
    

    private static String annaKirjain() {
        Scanner lukija = new Scanner(System.in);
        String luettu = lukija.nextLine();
        return luettu;
    }

    private static IntJoukko mikaJoukko(String text) {
        String luettu;
        System.out.println(text);
        luettu = annaKirjain();

        while (true) {
            if (luettu.equals("A") || luettu.equals("a")) {
                return A;
            } else if (luettu.equals("B") || luettu.equals("b")) {
                return B;
            } else if (luettu.equals("C") || luettu.equals("c")) {
                return C;
            } else {
                System.out.println("Virheellinen joukko! " + luettu);
                System.out.print("Yritä uudelleen!");
                luettu = annaKirjain();
            }
        }
    }

    private static void lisaa() {
        int lisattavaLuku = annaLuku("Mikä luku lisätään? ");
        IntJoukko joukko = mikaJoukko("Mihin joukkoon? ");
        joukko.lisaa(lisattavaLuku);
    }

    private static void poista() {
        IntJoukko joukko = mikaJoukko("Mistä joukosta? ");
        int poistettavaLuku = annaLuku("Mikä luku poistetaan? ");
        joukko.poista(poistettavaLuku);
    }

    private static void kuuluu() {
        IntJoukko joukko = mikaJoukko("Mihin joukkoon? ");
        int kysyttyLuku = annaLuku("Mikä luku? ");
        boolean kuuluuko = joukko.kuuluu(kysyttyLuku);
        if (kuuluuko) {
            System.out.println(kysyttyLuku + " kuuluu joukkoon ");
        } else {
            System.out.println(kysyttyLuku + " ei kuulu joukkoon ");
        }
    }

    public static void main(String[] args) {
        A = new IntJoukko();
        B = new IntJoukko();
        C = new IntJoukko();
        String luettu;

        System.out.println("Tervetuloa joukkolaboratorioon!");
        tuloste();

        Scanner lukija = new Scanner(System.in);
        while (true) {
            luettu = lukija.nextLine();
            if (luettu.equals("lisää") || luettu.equals("li")) {
                lisaa();
            } else if (luettu.equalsIgnoreCase("poista") || luettu.equalsIgnoreCase("p")) {
                poista();
            } else if (luettu.equalsIgnoreCase("kuuluu") || luettu.equalsIgnoreCase("k")) {
                kuuluu();
            } else if (luettu.equalsIgnoreCase("yhdiste") || luettu.equalsIgnoreCase("y")) {
                toimenpide("yhdiste");
            } else if (luettu.equalsIgnoreCase("leikkaus") || luettu.equalsIgnoreCase("le")) {
                toimenpide("leikkaus");
            } else if (luettu.equalsIgnoreCase("erotus") || luettu.equalsIgnoreCase("e")) {
                toimenpide("erotus");
            } else if (luettu.equalsIgnoreCase("A")) {
                System.out.println(A);
            } else if (luettu.equalsIgnoreCase("B")) {
                System.out.println(B);
            } else if (luettu.equalsIgnoreCase("C")) {
                System.out.println(C);
            } else if (luettu.equalsIgnoreCase("lopeta") || luettu.equalsIgnoreCase("quit") || luettu.equalsIgnoreCase("q")) {
                System.out.println("Lopetetaan, moikka!");
                break;
            } else {
                System.out.println("Virheellinen komento! " + luettu);
            }    
            tuloste();
        }
    }

    private static int annaLuku(String text) {
        Scanner lukija = new Scanner(System.in);
        System.out.print(text);
        return lukija.nextInt();
    }

    private static void tuloste() {
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");
    }

    private static void toimenpide(String toimenpide) {
        IntJoukko aJoukko = mikaJoukko("1. joukko? ");
        IntJoukko bJoukko = mikaJoukko("2. joukko? ");
        if(toimenpide.equals("yhdiste")) {
            IntJoukko cJoukko = IntJoukko.yhdiste(aJoukko, bJoukko);
            System.out.println("A yhdiste B = " + cJoukko.toString());
        } else if (toimenpide.equals("leikkaus")) {
            IntJoukko cJoukko = IntJoukko.leikkaus(aJoukko, bJoukko);
            System.out.println("A leikkaus B = " + cJoukko.toString());           
        } else {
            IntJoukko cJoukko = IntJoukko.erotus(aJoukko, bJoukko);
            System.out.println("A erotus B = " + cJoukko.toString());
        }    
    }    
}
