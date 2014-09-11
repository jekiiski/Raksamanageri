package fi.raksamanageri.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TyomaaTest {
    
    private Tyomaa t;
    
    public TyomaaTest() {
    }
    
    @Before
    public void setUp() {
        this.t = new Tyomaa(10);
    }
    
    @Test
    public void alussaValmiinaNolla() {
        assertEquals(this.t.getValmiina(), 0);
    }
    
    @Test
    public void alussaKokonaisTehokkuusNolla() {
        assertEquals(this.t.getKokonaisTehokkuus(), 0);
    }
    
    @Test
    public void laajuusAlussaOikein() {
        assertEquals(this.t.getLaajuus(), 10);
    }
    
//    @Test
//    public void palkkioOnLaskettuOikein() {
//        int alaraja = (this.t.getLaajuus()-3)*100;
//        int ylaraja = (this.t.getLaajuus()+10)*100;
//        
//    }
    
    @Test
    public void tyontekijanLisaysKasvattaaKokonaistehokkuutta() {
        Tyontekija te = new Tyontekija(true);
        this.t.lisaaTyontekija(te);
        assertEquals(this.t.getKokonaisTehokkuus(), 10);
    }
    
    @Test
    public void tyontekijanLisaysKasvattaaKokonaistehokkuuttaUlkomainen() {
        Tyontekija te = new Tyontekija(false);
        this.t.lisaaTyontekija(te);
        assertEquals(this.t.getKokonaisTehokkuus(), 8);
    }
    
    @Test
    public void tyontekijaPoistoLaskeeKokonaistehokkuutta() {
        Tyontekija t1 = new Tyontekija(true);
        Tyontekija t2 = new Tyontekija(false);
        this.t.lisaaTyontekija(t1);
        this.t.lisaaTyontekija(t2);
        this.t.poistaTyontekija(t2);
        assertEquals(this.t.getKokonaisTehokkuus(), 10);
    }
    
    @Test
    public void laajuudenLisaysToimii() {
        this.t.lisaaLaajuutta(15);
        assertEquals(this.t.getLaajuus(), 25);
    }
}
