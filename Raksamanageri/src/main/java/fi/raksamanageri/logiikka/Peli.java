package fi.raksamanageri.logiikka;

import java.util.ArrayList;

public class Peli {
    private boolean voitto;
    private boolean vararikko;
    private Pelaaja pelaaja;
    private ArrayList tyomaat;
    private ArrayList vapaatTyontekijat;
    private SatunnaisGeneraattori sk;
    
    public Peli(String pelaajanNimi) {
        this.pelaaja = new Pelaaja(pelaajanNimi);
        this.voitto = false;
        this.vararikko = false;
        this.tyomaat = new ArrayList<Tyomaa>();
        this.vapaatTyontekijat = new ArrayList<Tyontekija>();
        this.sk = new SatunnaisGeneraattori();
        
        luoUusiaTyomaita(4);
        luoUusiaTyontekijoita(6);
    }
    
    public void luoUusiaTyomaita(int lukuMaara) {
        for (int i=0; i<lukuMaara; i++) {
            this.tyomaat.add(this.sk.generoiUusiTyomaa());
        }
    }
    
    public void luoUusiaTyontekijoita(int lukuMaara) {
        for (int i=0; i<lukuMaara; i++) {
            this.vapaatTyontekijat.add(this.sk.generoiUusiTyontekija());
        }
    }
    
    public ArrayList<Tyomaa> getTyomaat() {
        return this.tyomaat;
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
