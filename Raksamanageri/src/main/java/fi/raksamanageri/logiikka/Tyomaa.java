package fi.raksamanageri.logiikka;

import java.util.ArrayList;
import java.util.Random;

public class Tyomaa {
    private final Random random;
    private final int palkkio;
    private int laajuus;
    private int valmiina;
    private int kokonaisTehokkuus;
    private boolean kaytettyKotimaista;
    private ArrayList<Tyontekija> tyontekijat;
    private String nimi;
    
    
    public Tyomaa(int laajuus, String nimi) {
        this.kokonaisTehokkuus = 0;
        this.kaytettyKotimaista = true;
        this.random = new Random();
        this.laajuus = laajuus;
        this.valmiina = 0;
        this.tyontekijat = new ArrayList<Tyontekija>();
        this.nimi = nimi;
        
        // palkkio on laajuus - 3 ... laajuus + 10 * 100
        this.palkkio = (this.laajuus + (-3 + this.random.nextInt(14))) * 100;
    }
    
    public int getValmiina() {
        return this.valmiina;
    }
    
    public int getKokonaisTehokkuus() {
        return this.kokonaisTehokkuus;
    }
    
    public int getPalkkio() {
        return this.palkkio;
    }
    
    public int getLaajuus() {
        return this.laajuus;
    }
    
    public boolean onkoKaytettyVainKotimaisiaTyontekijoita() {
        return this.kaytettyKotimaista;
    }
    
    public ArrayList<Tyontekija> getTyontekijat() {
        return this.tyontekijat;
    }
    
    public void lisaaTyontekija(Tyontekija t) {
//        if (!t.onkoKotimainen()) {
//            this.kaytettyKotimaista = false;
//        }
        this.kokonaisTehokkuus += t.getTyoteho();
        t.laitaToihin(this);
        this.tyontekijat.add(t);
    }
    
    public void poistaTyontekija(Tyontekija t) {
        this.kokonaisTehokkuus -= t.getTyoteho();
        t.poistaTyomaalta();
        this.tyontekijat.remove(t);
    }
    
    public void seuraavaVuoro() {
        this.valmiina += this.kokonaisTehokkuus;
        
        // tarkitetaan kotimaisuusaste vasta nyt
        for (Tyontekija t : this.tyontekijat) {
            if (!t.onkoKotimainen()) {
                this.kaytettyKotimaista = false;
            }
        }
    }
    
    public void lisaaLaajuutta(int maara) {
        this.laajuus += maara;
    }
    
    @Override
    public String toString() {
        return "Tyomaa, laajuus: " + getLaajuus() + ", tehty: "
                + getValmiina() + ", palkkio: " + getPalkkio()
                + " käytetty kotimaista: " + this.kaytettyKotimaista;
    }
}
