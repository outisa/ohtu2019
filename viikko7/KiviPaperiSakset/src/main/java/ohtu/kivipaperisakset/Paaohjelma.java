package ohtu.kivipaperisakset;

public class Paaohjelma {
    public static void main(String[] args) {
        IO io = new KonsoliIO();
        Pelitehdas pelitehdas = new Pelitehdas();
        while (true) {
            io.print("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = io.nextLine();
            if (vastaus.endsWith("a")) {
                pelinLopetusInfo();
                pelitehdas.kaksinpeli().pelaa();

            } else if (vastaus.endsWith("b")) {
                pelinLopetusInfo();
                pelitehdas.yksinpeli().pelaa();
                
            } else if (vastaus.endsWith("c")) {
                pelinLopetusInfo();
                pelitehdas.pahaYksinpeli().pelaa();
            } else {
                break;
            }

        }

    }

    private static void pelinLopetusInfo() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
    }
}
