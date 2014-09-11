package fi.raksamanageri.logiikka;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {
    private Pelaaja p;
    
    public PelaajaTest() {
    }
    
    @Before
    public void setUp() {
        p = new Pelaaja("");
    }
    
    
    @Test
    public void pelaajaSaaOikeanNimen() {
        Pelaaja k = new Pelaaja("asdf");
        assertEquals(k.getNimi(), "asdf");
    }
    
    @Test
    public void pelaajaSaaOikeanNimenIlmanSyotetta() {
        Pelaaja k = new Pelaaja("");
        assertEquals(k.getNimi(), "Nimetön");
    }
    
    @Test
    public void pelaajallaOikeaSummaRahaaAlussa() {
        assertEquals(p.paljonkoRahaa(), 10000);
    }
    
    @Test
    public void pelaajallaOikeaSummaRahaaKunLisataanRahaa() {
        p.muutaRahaMaaraa(2003);
        assertEquals(p.paljonkoRahaa(), 12003);
    } 
    
    @Test
    public void pelaajallaOikeaSummaRahaaKunVahennetaan() {
        p.muutaRahaMaaraa(-300);
        assertEquals(p.paljonkoRahaa(), 9700);
    }
    
    @Test
    public void pelaajallaEiOleAlussaTyontekijoita() {
        assertEquals(p.annaAlaiset().isEmpty(), true);
    }
    
    @Test
    public void tyontekijanLisaysToimii() {
        Tyontekija t = new Tyontekija(true);
        p.lisaaAlainen(t);
        assertEquals(p.annaAlaiset().size(), 1);
    }
    
    @Test
    public void tyontekijanPoistoToimii() {
        Tyontekija t = new Tyontekija(true);
        p.lisaaAlainen(t);
        p.poistaTyontekija(t);
        assertEquals(p.annaAlaiset().isEmpty(), true);
    }
    
    @Test
    public void oikeanTyontekijanPoistoToimii() {
        Tyontekija a = new Tyontekija(true);
        Tyontekija b = new Tyontekija(false);
        p.lisaaAlainen(a);
        p.lisaaAlainen(b);
        p.poistaTyontekija(a);
        ArrayList l = p.annaAlaiset();
        assertEquals(l.get(0), b);
    }
    
}
