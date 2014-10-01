package fi.raksamanageri.domain;

import fi.raksamanageri.domain.Tyomaa;
import fi.raksamanageri.domain.Tyontekija;
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
        this.t = new Tyomaa(10, "");
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
    
    @Test
    public void palkkioYlittaaAlarajan() {
        int raja = t.getPalkkio() - (t.getLaajuus()-3)*40;
        boolean ok = false;
        if (raja >= 0) {
            ok = true;
        }
        assertEquals(ok, true);
    }
    
    @Test
    public void palkkioAlittaaYlarajan() {
        int raja = t.getPalkkio() - (t.getLaajuus()+10)*40;
        boolean ok = false;
        if (raja <= 0) {
            ok = true;
        }
        assertEquals(ok, true);
    }
    
    @Test
    public void tyontekijanLisaysKasvattaaKokonaistehokkuutta() {
        Tyontekija te = new Tyontekija(true, "");
        this.t.lisaaTyontekija(te);
        assertEquals(this.t.getKokonaisTehokkuus(), 10);
    }
    
    @Test
    public void tyontekijanLisaysKasvattaaKokonaistehokkuuttaUlkomainen() {
        Tyontekija te = new Tyontekija(false, "");
        this.t.lisaaTyontekija(te);
        assertEquals(this.t.getKokonaisTehokkuus(), 8);
    }
    
    @Test
    public void tyontekijaPoistoLaskeeKokonaistehokkuutta() {
        Tyontekija t1 = new Tyontekija(true, "");
        Tyontekija t2 = new Tyontekija(false, "");
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
    
    @Test
    public void kaytettyKotimaistaToimiiYksi() {
        this.t.lisaaTyontekija(new Tyontekija(true, ""));
        this.t.seuraavaVuoro();
        assertEquals(t.onkoKaytettyVainKotimaisiaTyontekijoita(), true);
    }
    
    @Test
    public void kaytettyKotimaistaToimiiKaksi() {
        this.t.lisaaTyontekija(new Tyontekija(false, ""));
        this.t.seuraavaVuoro();
        assertEquals(t.onkoKaytettyVainKotimaisiaTyontekijoita(), false);
    }
    
    @Test
    public void seuraavaVuoroLisaaValmistaTyota() {
        this.t.lisaaTyontekija(new Tyontekija(true, ""));
        t.seuraavaVuoro();
        assertEquals(t.getValmiina(), 10);
    }
    
    @Test
    public void tyontekijaOnToissaTyomaalla() {
        Tyontekija te = new Tyontekija(true, "");
        this.t.lisaaTyontekija(te);
        assertEquals(te.missaToissa(), this.t);
    }
    
    @Test
    public void tyontekijanPoistoTyomaaltaToimiiOikeinTyontekijalla() {
        Tyontekija te = new Tyontekija(true, "");
        this.t.lisaaTyontekija(te);
        this.t.poistaTyontekija(te);
        assertEquals(te.missaToissa(), null);
    }
    
    @Test
    public void eiVoiLisataOlemassaOlevaaPatevyytta() {
        Patevyys p = new Patevyys("a");
        this.t.lisaaVaadittavaPatevyys(p);
        this.t.lisaaVaadittavaPatevyys(p);
        assertEquals(this.t.annaVaaditutPatevyydet().size(), 1);
    }
    
    @Test
    public void patevyydenLisaysToimii() {
        this.t.lisaaVaadittavaPatevyys(new Patevyys("a"));
        assertEquals(this.t.annaVaaditutPatevyydet().size(), 1);
    }
    
    @Test
    public void getNimiMetodiToimii() {
        assertEquals("", this.t.getNimi());
    }
    
    @Test
    public void uudenPalkkionAsettaminenToimii() {
        int nykyinenPalkkio = this.t.getPalkkio();
        this.t.setPalkkio(-1);
        assertNotSame(t.getPalkkio(), nykyinenPalkkio);
    }
}
