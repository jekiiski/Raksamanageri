package fi.raksamanageri.logiikka;

import java.util.ArrayList;

public class Pelaaja {

    private int rahaMaara;
    private static final int ALKURAHA = 10000;
    private final ArrayList<Tyontekija> tyonTekijat;
    private final ArrayList<Tyomaa> tyomaat;

    public Pelaaja() {
        this.rahaMaara = ALKURAHA;
        this.tyonTekijat = new ArrayList<Tyontekija>();
        this.tyomaat = new ArrayList<Tyomaa>();
    }

    public int annaRahamaara() {
        return this.rahaMaara;
    }

    public void muutaRahamaaraa(int maara) {
        this.rahaMaara += maara;
    }

    public void lisaaTyontekija(Tyontekija tyontekija) {
        this.tyonTekijat.add(tyontekija);
    }

    public boolean poistaTyontekija(Tyontekija tyontekija) {
        if (this.tyonTekijat.contains(tyontekija)) {
            this.tyonTekijat.remove(tyontekija);
            return true;
        }
        return false;
    }

    public ArrayList<Tyontekija> annaTyontekijat() {
        return this.tyonTekijat;
    }

    public void lisääTyomaa(Tyomaa maa) {
//        if (!this.tyomaat.contains(maa)) {
            this.tyomaat.add(maa);
//        }
    }

    public ArrayList<Tyomaa> annaTyomaat() {
        return this.tyomaat;
    }

    public void poistaTyomaa(Tyomaa maa) {
        if (this.tyomaat.contains(maa)) {
            this.tyomaat.remove(maa);
        }
    }
    
//    public void lisaaTyontekijaTyomaalle(Tyontekija tt, int tyomaaIndeksi) {
//        if (tyomaaIndeksi >=0 && tyomaaIndeksi < this.tyomaat.size()) {
//            this.tyomaat.get(tyomaaIndeksi).lisaaTyontekija(tt);
//        }
//    }
    
//    public void poistaTyontekijaTyomaalta(Tyontekija tt, int tyomaaIndeksi) {
//        if (tyomaaIndeksi >=0 && tyomaaIndeksi < this.tyomaat.size()) {
//            this.tyomaat.get(tyomaaIndeksi).poistaTyontekija(tt);
//        }
//    }
    
    public void lisaaTyontekijaTyomaalle(Tyontekija tt, Tyomaa tm) {
        tm.lisaaTyontekija(tt);
        tt.laitaToihin(tm);
    }
    
    public void poistaTyontekijaTyomaalta(Tyontekija tt, Tyomaa tm) {
        tm.poistaTyontekija(tt);
        tt.poistaTyomaalta();
    }
    
    public void seuraavaVuoro() {
        laskePalkat();
        paivitaTyomaat();
    }

    private void laskePalkat() {
        int palkat = 0;
        for (Tyontekija t : this.tyonTekijat) {
            palkat += t.getPalkka();
        }
        muutaRahamaaraa(-palkat);
    }
    
    private void paivitaTyomaat() {
        for (Tyomaa t : this.tyomaat) {
            t.seuraavaVuoro();
            if (t.getLaajuus() <= t.getValmiina()) {
                muutaRahamaaraa(t.getPalkkio());
                this.tyomaat.remove(t);
            }
        }
    }
}
