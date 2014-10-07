/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.raksamanageri.tyokalut;

import fi.raksamanageri.tyokalut.SatunnaisGeneraattori;
import fi.raksamanageri.domain.Tyomaa;
import fi.raksamanageri.domain.Tyontekija;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author eikkari
 */
public class SatunnaisGeneraattoriTest {
    
    private SatunnaisGeneraattori sk;
    
    public SatunnaisGeneraattoriTest() {
        this.sk = new SatunnaisGeneraattori();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // satunnaisuuden vuoksi seuraavat testit ovat tehty kuten ovat!!!
    
    @Test
    public void generoiUusiTyomaaOikeaLaajuusYksi() {
        Tyomaa t = this.sk.generoiUusiTyomaa();
        int maksimilaajuus = 40+19;
        boolean ok = false;
        if (maksimilaajuus - t.getLaajuus() >= 0) {
            ok = true;
        }
        assertEquals(ok, true);
    }
    
    @Test
    public void generoiUusiTyomaaOikeaLaajuusKaksi() {
        Tyomaa t = this.sk.generoiUusiTyomaa();
        int minimilaajuus = 40;
        boolean ok = false;
        if (t.getLaajuus() - minimilaajuus >= 0) {
            ok = true;
        }
        assertEquals(ok, true);
    }
    
    @Test
    public void generoiUusiTyomaaPalauttaaTyomaan() {
        Object t = this.sk.generoiUusiTyomaa();
        Tyomaa k = new Tyomaa(10, "");
        boolean samaObjekti = false;
        if (t.getClass() == k.getClass()) {
            samaObjekti = true;
        }
        assertEquals(samaObjekti, true);
    }
    
    @Test
    public void generoiUusiTyontekijaPalauttaaTyontekijan() {
        Object t = this.sk.generoiUusiTyontekija();
        Tyontekija k = new Tyontekija(true, "");
        boolean samat = false;
        if (t.getClass() == k.getClass()) {
            samat = true;
        }
        assertEquals(samat, true);
    }
    
    @Test
    public void generoiTyomaaPalkkioOnRajojenSisalla() {
        int testattava = this.sk.generoiTyomaaPalkkio(new Tyomaa(10, ""));
        int maksimi = (10 - 3 + 13) * 60;
        int minimi = (10 - 3) * 60;
        boolean max = false;
        boolean min = false;
        if (maksimi - testattava >= 0) {
            max = true;
        }
        if (testattava - minimi >= 0) {
            min = true;
        }
        assertEquals(max, true);
        assertEquals(min, true);
    }
    
    @Test
    public void rakennustarkastajaTuleeEdesJoskus() {
        boolean kylaan = false;
        for (int i=0; i<200; i++) {
            if (kylaan == false) {
                kylaan = this.sk.rakennustarkastajaKylaan();
            }
            if (kylaan) {
                break;
            }
        }
        assertEquals(kylaan, true);
    }
    
    @Test
    public void verottajaTuleeEdesJoskusTarkastamaan() {
        boolean tarkastaa = false;
        for (int i=0; i<200; i++) {
            if (!tarkastaa) {
                tarkastaa = this.sk.verottajanTarkastus();
            }
            if (tarkastaa) {
                break;
            }
        }
        assertEquals(tarkastaa, true);
    }
    
}
