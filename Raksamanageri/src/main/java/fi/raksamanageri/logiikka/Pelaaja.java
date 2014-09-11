package fi.raksamanageri.logiikka;

import java.util.ArrayList;

public class Pelaaja {
    private final String nimi;
    private int rahaMaara;
    private static final int ALKURAHA = 10000;
    private final ArrayList tyonTekijat;
    
    
    public Pelaaja(String nimi) {
        if (nimi.isEmpty()) {
            this.nimi = "Nimetön";
        } else {
            this.nimi = nimi;
        }
        this.rahaMaara = ALKURAHA;
        this.tyonTekijat = new ArrayList<Tyontekija>();
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public int paljonkoRahaa() {
        return this.rahaMaara;
    }
    
    public void muutaRahaMaaraa(int maara) {
        // voidaan yhdellä käskyllä lisätä tai poistaa rahaa
        this.rahaMaara+=maara;
    }
    
    public void lisaaAlainen(Tyontekija tyontekija) {
        this.tyonTekijat.add(tyontekija);
    }
    public boolean poistaTyontekija(Tyontekija tyontekija) {
        if (this.tyonTekijat.contains(tyontekija)) {
            this.tyonTekijat.remove(tyontekija);
            return true;
        }
        return false;
    }
    
    public ArrayList<Tyontekija> annaAlaiset() {
        return this.tyonTekijat;
    }
}
