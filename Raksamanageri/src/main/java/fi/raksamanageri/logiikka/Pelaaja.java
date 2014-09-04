package fi.raksamanageri.logiikka;

import java.util.ArrayList;

public class Pelaaja {
    private String nimi;
    private int rahaMaara;
    private static final int ALKURAHA = 10000;
    private ArrayList alaiset;
    
    
    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.rahaMaara = ALKURAHA;
        this.alaiset = new ArrayList<Tyontekija>();
    }
    
    public int paljonkoRahaa() {
        return this.rahaMaara;
    }
    
    public void muutaRahaMaaraa(int maara) {
        // voidaan yhdellä käskyllä lisätä tai poistaa rahaa
        this.rahaMaara+=maara;
    }
    
    public void lisaaAlainen(Tyontekija tyontekija) {
        this.alaiset.add(tyontekija);
    }
    
    public ArrayList<Tyontekija> annaAlaiset() {
        return this.alaiset;
    }
}
