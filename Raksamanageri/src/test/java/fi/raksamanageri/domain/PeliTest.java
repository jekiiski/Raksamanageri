package fi.raksamanageri.domain;

import fi.raksamanageri.domain.Tyomaa;
import fi.raksamanageri.domain.Peli;
import fi.raksamanageri.domain.Tyontekija;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliTest {
    private Peli p;
    
    public PeliTest() {
        this.p = new Peli();
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void uudenTyomaanLisaysToimii() {
        Tyomaa t = new Tyomaa(10, "");
        this.p.lisaaUusiTyomaa(t);
        assertEquals(this.p.getTyomaat().size(), 1);
    }
    
    @Test
    public void uudenTyomaanArpominenToimii() {
        this.p.arvoUusiTyomaa();
        assertEquals(this.p.getTyomaat().size(), 1);
    }
    
    @Test
    public void uudenTyontekijanLisaysToimii() {
        Tyontekija te = new Tyontekija(false, "");
        this.p.lisaaUusiTyontekija(te);
        assertEquals(this.p.getVapaatTyontekijat().size(), 1);
    }
    
    @Test
    public void uudenTyontekijanArpominenToimii() {
        this.p.arvoUusiTyontekija();
        assertEquals(this.p.getVapaatTyontekijat().size(), 1);
    }
    
    @Test
    public void tyomaanPoistoToimii() {
        Tyomaa t = new Tyomaa(10, "");
        this.p.lisaaUusiTyomaa(t);
        this.p.poistaUusiTyomaa(t);
        assertEquals(this.p.getTyomaat().size(), 0);
    }
    
    @Test
    public void tyontekijanPoistoToimii() {
        Tyontekija te = new Tyontekija(false, "");
        this.p.lisaaUusiTyontekija(te);
        this.p.poistaUusiTyontekija(te);
        assertEquals(this.p.getVapaatTyontekijat().size(), 0);
    }
    
    @Test
    public void metodiGetTyomaatToimii() {
        ArrayList<Tyomaa> l = new ArrayList<Tyomaa>();
        Tyomaa t = new Tyomaa(12, "asdf");
        l.add(t);
        this.p.lisaaUusiTyomaa(t);
        assertEquals(l, this.p.getTyomaat());
    }
    
   
}
