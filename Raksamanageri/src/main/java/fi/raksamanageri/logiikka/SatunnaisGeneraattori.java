package fi.raksamanageri.logiikka;

import fi.raksamanageri.domain.Tyomaa;
import fi.raksamanageri.domain.Tyontekija;
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
        int laajuus = 40 + this.random.nextInt(20);
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
    
    public int generoiTyomaaPalkkio(Tyomaa t) {
        return (t.getLaajuus() + (-3 + this.random.nextInt(14))) * 40;
    }
    
    public boolean rakennustarkastajaKylaan() {
        if (this.random.nextInt(3) == 0) {
            return true;
        }
        return false;
    }
    
    public boolean verottajanTarkastus() {
        if (this.random.nextInt(5) == 0) {
            return true;
        }
        return false;
    }
    
}
