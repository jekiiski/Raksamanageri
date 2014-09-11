package fi.raksamanageri.logiikka;

import java.util.Random;

public class Tyomaa {
    private final Random random;
    private final int palkkio;
    private int laajuus;
    private int valmiina;
    private int kokonaisTehokkuus;
    private boolean kaytettyKotimaista;
    
    
    public Tyomaa(int laajuus) {
        this.kokonaisTehokkuus = 0;
        this.kaytettyKotimaista = true;
        this.random = new Random();
        this.laajuus = laajuus;
        this.valmiina = 0;
        
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
    
    public void lisaaTyontekija(Tyontekija t) {
        if (!t.onkoKotimainen()) {
            this.kaytettyKotimaista = false;
        }
        this.kokonaisTehokkuus += t.getTyoteho();
    }
    
    public void poistaTyontekija(Tyontekija t) {
        this.kokonaisTehokkuus -= t.getTyoteho();
    }
    
    public void seuraavaVuoro() {
        this.valmiina += this.kokonaisTehokkuus;
    }
    
    public void lisaaLaajuutta(int maara) {
        this.laajuus += maara;
    }
}
