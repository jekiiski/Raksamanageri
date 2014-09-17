package fi.raksamanageri.logiikka;

import java.util.ArrayList;

public class Peli {

    private boolean voitto;
    private boolean vararikko;
    private Pelaaja pelaaja;
    private ArrayList<Tyomaa> vapaatTyomaat;
    private ArrayList<Tyontekija> vapaatTyontekijat;
    private SatunnaisGeneraattori sk;

    public Peli() {
        this.pelaaja = new Pelaaja();
        this.voitto = false;
        this.vararikko = false;
        this.vapaatTyomaat = new ArrayList<Tyomaa>();
        this.vapaatTyontekijat = new ArrayList<Tyontekija>();
        this.sk = new SatunnaisGeneraattori();
    }

    public void lisaaUusiTyomaa(Tyomaa t) {
        this.vapaatTyomaat.add(t);
    }
    
    public void arvoUusiTyomaa() {
        this.vapaatTyomaat.add(this.sk.generoiUusiTyomaa());
    }
    
    public void arvoUusiTyontekija() {
        this.vapaatTyontekijat.add(this.sk.generoiUusiTyontekija());
    }

    public void poistaUusiTyomaa(Tyomaa t) {
        if (this.vapaatTyomaat.contains(t)) {
            this.vapaatTyomaat.remove(t);
        }
    }
    
    public void lisaaUusiTyontekija(Tyontekija te) {
        this.vapaatTyontekijat.add(te);
    }
    
    public void poistaUusiTyontekija(Tyontekija te) {
        if (this.vapaatTyontekijat.contains(te)) {
            this.vapaatTyontekijat.remove(te);
        }
    }

    public ArrayList<Tyomaa> getTyomaat() {
        return this.vapaatTyomaat;
    }

    public ArrayList<Tyontekija> getVapaatTyontekijat() {
        return this.vapaatTyontekijat;
    }

    public Pelaaja getPelaaja() {
        return this.pelaaja;
    }

    public void seuraavaVuoro() {

    }
}
