package fi.raksamanageri.logiikka;

import java.util.Random;

public class SatunnaisGeneraattori {
    private Random random;
    private int tyomaaLaskuri;
    private int tyontekijaLaskuri;
    
    public SatunnaisGeneraattori() {
        this.random = new Random();
        this.tyomaaLaskuri = 1;
        this.tyontekijaLaskuri = 1;
    }
    
    public Tyomaa generoiUusiTyomaa() {
        int laajuus = 6 + this.random.nextInt(20);
        String nimi = "TM" + this.tyomaaLaskuri;
        this.tyomaaLaskuri++;
        Tyomaa t = new Tyomaa(laajuus, nimi);
        return t;
    }
    
    public Tyontekija generoiUusiTyontekija() {
        String nimi = "TT" + this.tyontekijaLaskuri;
        this.tyontekijaLaskuri++;
        Tyontekija t;
        if (this.random.nextInt(2) > 0) {
            t = new Tyontekija(true, nimi);
        } else {
            t = new Tyontekija(false, nimi); 
        }
        return t;
    }
    
}
