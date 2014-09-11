package fi.raksamanageri.domain;

import fi.raksamanageri.logiikka.*;
import java.util.Scanner;

public class CLI {

    private Scanner lukija;
    private Peli peli;

    public CLI() {
        this.lukija = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.print("Ladataanko peli muistista (k/e/x): ");
            String komento = this.lukija.nextLine();
            if (komento.equals("k")) {
                lataaPeli();
                break;
            } else if (komento.equals("e")) {
                System.out.print("Anna nimesi: ");
                String nimi = this.lukija.nextLine();
                peli = new Peli(nimi);
                menu();
                break;
            } else if (komento.equals("x")) {
                break;
            }
        }
    }

    private void menu() {
        System.out.println("\n\n*** RAKSAMANAGERI V0.1 ***");
        System.out.println("Valitse vaihtoehto:");
        System.out.println("1. Hallitse tyontekijöitä");
        System.out.println("2. Hallitse tyomaita");
        System.out.println("3. Seuraava vuoro");
        System.out.println("4. Tallenna peli");
        System.out.println("5. Lopeta peli");
        System.out.print("> ");
        String komento = this.lukija.nextLine();

        switch (komento) {
            case "1":
                hallitseTyontekijoita();
                menu();
                break;
            case "2":
                hallitseTyomaita();
                menu();
                break;
            case "3":
                peli.seuraavaVuoro();
                menu();
                break;
            case "4":
                tallennaPeli();
                menu();
                break;
            case "5":
                break;
            default:
                menu();
                break;

        }
    }

    private void lataaPeli() {
        System.out.println("EI VIELÄ IMPLEMENTOITU");
    }

    private void tallennaPeli() {
        System.out.println("EI VIELÄ IMPLEMENTOITU");
    }

    private void hallitseTyontekijoita() {
        System.out.println("\n\nValitse vaihtoehto: ");
        System.out.println("1. Näytä työntekijäsi");
        System.out.println("2. Palkkaa työntekijöitä");
        System.out.println("3. Erota työntekijöitä");
        System.out.println("4. Palaa päävalikkoon");
        String komento = this.lukija.nextLine();

        switch (komento) {
            case "1":
                tulostaTyontekijat();
                hallitseTyontekijoita();
                break;
            case "2":
                palkkaaTyontekijoita();
                hallitseTyontekijoita();
                break;
            case "3":
                System.out.println("3");
                hallitseTyontekijoita();
                break;
            case "4":
                return;
            default:
                hallitseTyontekijoita();
                break;
        }
    }

    private void tulostaTyontekijat() {
        System.out.println("Työntekijäsi: ");
        for (int i=1; i<=this.peli.getPelaaja().annaAlaiset().size(); i++) {
            Tyontekija t = this.peli.getPelaaja().annaAlaiset().get(i-1);
            System.out.print(i + ". " + t);
//            if (t.onkoKotimainen()) {
//                System.out.print("Kotimainen ");
//            } else {
//                System.out.print("Ulkomainen ");
//            }
//            System.out.println(" työntekijä, palkka : "
//            + t.getPalkka() + " tyoteho : " + t.getTyoteho());
        }
    }
    
    private void palkkaaTyontekijoita() {
        System.out.println("Palkkaa kuka: [x]=ei ketään");
        for (int i=1; i<=this.peli.getVapaatTyontekijat().size(); i++) {
            Tyontekija t = this.peli.getVapaatTyontekijat().get(i-1);
            System.out.println(i + ". " + t);
        }
        
        
    }

    private void hallitseTyomaita() {
    }
}
