package fi.raksamanageri.logiikka;

import java.util.Random;

public class SatunnaisGeneraattori {
    private Random random;
    
    public SatunnaisGeneraattori() {
        this.random = new Random();
    }
    
    public Tyomaa generoiUusiTyomaa() {
        int laajuus = 6 + this.random.nextInt(20);
        Tyomaa t = new Tyomaa(laajuus);
        return t;
    }
    
    public Tyontekija generoiUusiTyontekija() {
        Tyontekija t;
        if (this.random.nextInt(2) > 0) {
            t = new Tyontekija(true);
        } else {
            t = new Tyontekija(false); 
        }
        return t;
    }
    
}
