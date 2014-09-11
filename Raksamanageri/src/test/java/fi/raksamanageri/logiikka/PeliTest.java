package fi.raksamanageri.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliTest {
    
    public PeliTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void alussaNeljaUuttaTyomaata() {
        Peli p = new Peli("asdf");
        assertEquals(p.getTyomaat().size(), 4);
    }
    
    @Test
    public void tyomaidenLisaysToimii() {
        Peli p = new Peli("");
        p.luoUusiaTyomaita(4);
        assertEquals(p.getTyomaat().size(), 8);
    }
    
    @Test
    public void alussaKuusiUuttaTyontekijaa() {
        Peli p = new Peli("");
        assertEquals(p.getVapaatTyontekijat().size(), 6);
    }
    
    @Test
    public void tyontekijoidenLisaysToimii() {
        Peli p = new Peli("");
        p.luoUusiaTyontekijoita(6);
        assertEquals(p.getVapaatTyontekijat().size(), 12);
    }
}
