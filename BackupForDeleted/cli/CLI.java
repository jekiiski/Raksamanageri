package fi.raksamanageri.cli;

import fi.raksamanageri.domain.Peli;
import fi.raksamanageri.domain.Tyomaa;
import fi.raksamanageri.domain.Tyontekija;
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
                peli = new Peli();
                valmistelePeli();
                menu();
                break;
            } else if (komento.equals("x")) {
                break;
            }
        }
    }

    private void valmistelePeli() {
        this.peli.arvoUusiTyontekija();
        this.peli.arvoUusiTyomaa();
        this.peli.arvoUusiTyomaa();
        this.peli.arvoUusiTyontekija();
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
                erotaTyontekijoita();
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
        for (int i = 0; i < this.peli.getPelaaja().annaTyontekijat().size(); i++) {
            Tyontekija t = this.peli.getPelaaja().annaTyontekijat().get(i);
            System.out.println(i + 1 + ". " + t);
        }
    }

    private void palkkaaTyontekijoita() {
        System.out.println("Palkkaa kuka: [x]=ei ketään");
        for (int i = 0; i < this.peli.getVapaatTyontekijat().size(); i++) {
            Tyontekija t = this.peli.getVapaatTyontekijat().get(i);
            System.out.println(i + 1 + ". " + t);
        }
        String komento = lukija.nextLine();
        if (!komento.equals("x")) {
            int nro;
            try {
                nro = Integer.parseInt(komento);
            } catch (Exception e) {
                System.out.println("Anna numero tai [x]!");
                return;
            }
            if (nro >= 1 && nro <= this.peli.getVapaatTyontekijat().size()) {
                this.peli.getPelaaja().lisaaTyontekija(this.peli.getVapaatTyontekijat().get(nro - 1));
                this.peli.poistaUusiTyontekija(this.peli.getVapaatTyontekijat().get(nro - 1));
            } else {
                System.out.println("Ei moista työntekijänumeroa!");
            }
        }

    }

    private void erotaTyontekijoita() {
        System.out.println("Kenet erotetaan? [x]~poistu");
        for (int i = 0; i < this.peli.getPelaaja().annaTyontekijat().size(); i++) {
            Tyontekija t = this.peli.getPelaaja().annaTyontekijat().get(i);
            System.out.println(i + 1 + ". " + t);
        }
        String komento = lukija.nextLine();
        if (!komento.equals("x")) {
            int nro;
            try {
                nro = Integer.parseInt(komento);
            } catch (Exception e) {
                System.out.println("Anna numero tai [x]!");
                return;
            }
            if (nro >= 1 && nro <= this.peli.getPelaaja().annaTyontekijat().size()) {
                this.peli.getPelaaja().poistaTyontekija(this.peli.getPelaaja().annaTyontekijat().get(nro - 1));
            } else {
                System.out.println("Ei moista työntekijänumeroa!");
            }
        }

    }

    private void hallitseTyomaita() {
        System.out.println("\n\nValitse vaihtoehto: ");
        System.out.println("1. Näytä tyomaasi");
        System.out.println("2. Lisää uusi työmaa");
        System.out.println("3. Aseta työntekijä tyomaalle");
        System.out.println("4. Poista työntekijä tyomaalta");
        System.out.println("5. Poistu");
        String komento = this.lukija.nextLine();

        switch (komento) {
            case "1":
                tulostaTyomaat();
                hallitseTyomaita();
                break;
            case "2":
                lisaaTyomaa();
                hallitseTyontekijoita();
                break;
            case "3":
                asetaTyontekijaTyomaalle();
                hallitseTyontekijoita();
                break;
            case "4":
                poistaTyontekijaTyomaalta();
                hallitseTyontekijoita();
                break;
            case "5":
                return;
            default:
                hallitseTyomaita();
                break;
        }
    }

    private void tulostaTyomaat() {
        System.out.println("Työmaasi: ");
        for (int i = 0; i < this.peli.getPelaaja().annaTyomaat().size(); i++) {
            Tyomaa t = this.peli.getPelaaja().annaTyomaat().get(i);
            System.out.println(i + 1 + ". " + t);
        }
    }

    private void lisaaTyomaa() {
        System.out.println("Lisää mikä: [x]=ei ketään");
        for (int i = 0; i < this.peli.getTyomaat().size(); i++) {
            Tyomaa t = this.peli.getTyomaat().get(i);
            System.out.println(i + 1 + ". " + t);
        }
        String komento = lukija.nextLine();
        if (!komento.equals("x")) {
            int nro;
            try {
                nro = Integer.parseInt(komento);
            } catch (Exception e) {
                System.out.println("Anna numero tai [x]!");
                return;
            }
            if (nro >= 1 && nro <= this.peli.getTyomaat().size()) {
                this.peli.getPelaaja().lisääTyomaa(this.peli.getTyomaat().get(nro - 1));
                this.peli.poistaUusiTyomaa(this.peli.getTyomaat().get(nro - 1));
            } else {
                System.out.println("Ei moista työntekijänumeroa!");
            }
        }
    }

    private void asetaTyontekijaTyomaalle() {
        
        System.out.println("Ei implementoitu");
        
//        int tyontekijaNro = -1;
//        int tyomaaNro = -1;
//
//        System.out.println("Valitse työntekijä: [x]~poistu");
//        for (int i = 0; i < this.peli.getPelaaja().annaTyontekijat().size(); i++) {
//            Tyontekija t = this.peli.getPelaaja().annaTyontekijat().get(i);
//            System.out.println(i + 1 + ". " + t);
//        }
//        String komento = lukija.nextLine();
//        if (!komento.equals("x")) {
//            try {
//                tyontekijaNro = Integer.parseInt(komento);
//            } catch (Exception e) {
//                System.out.println("Anna numero tai [x]!");
//                return;
//            }
//            if (tyontekijaNro < 1 || tyontekijaNro > this.peli.getVapaatTyontekijat().size()) {
//                System.out.println("Ei moista työntekijänumeroa!");
//            }
//        }
//
//        System.out.println("Mille työmaalle sijoitetaan: [x]~poistu");
//        for (int i = 0; i < this.peli.getPelaaja().annaTyomaat().size(); i++) {
//            Tyomaa t = this.peli.getPelaaja().annaTyomaat().get(i);
//            System.out.println(i + 1 + ". " + t);
//        }
//        String toinenKomento = lukija.nextLine();
//        if (!toinenKomento.equals("x")) {
//            try {
//                tyomaaNro = Integer.parseInt(toinenKomento);
//            } catch (Exception e) {
//                System.out.println("Anna numero tai [x]!");
//                return;
//            }
//            if (tyomaaNro < 1 && tyomaaNro > this.peli.getTyomaat().size()) {
//                System.out.println("Ei moista työntekijänumeroa!");
//            }
//        }
//
//        this.peli.getPelaaja().lisaaTyontekijaTyomaalle(
//                this.peli.getPelaaja().annaTyontekijat().get(tyontekijaNro),
//                tyomaaNro);
    }
    
    private void poistaTyontekijaTyomaalta() {
        int tyontekijaNro = -1;
        int tyomaaNro = -1;
        
        System.out.println("Valitse tyomaa: [x]~poistu");
        for (int i = 0; i < this.peli.getPelaaja().annaTyomaat().size(); i++) {
            Tyomaa t = this.peli.getPelaaja().annaTyomaat().get(i);
            System.out.println(i + 1 + ". " + t);
        }
        String toinenKomento = lukija.nextLine();
        if (!toinenKomento.equals("x")) {
            try {
                tyomaaNro = Integer.parseInt(toinenKomento);
            } catch (Exception e) {
                System.out.println("Anna numero tai [x]!");
                return;
            }
            if (tyomaaNro < 1 && tyomaaNro > this.peli.getTyomaat().size()) {
                System.out.println("Ei moista työntekijänumeroa!");
            }
        }
        
    }
}
