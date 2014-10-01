package fi.raksamanageri.domain;

import fi.raksamanageri.domain.Tyomaa;
import fi.raksamanageri.domain.Pelaaja;
import fi.raksamanageri.domain.Tyontekija;
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
        p = new Pelaaja();
    }
    
    @Test
    public void pelaajallaOikeaSummaRahaaAlussa() {
        assertEquals(p.annaRahamaara(), 10000);
    }
    
    @Test
    public void pelaajallaOikeaSummaRahaaKunLisataanRahaa() {
        p.muutaRahamaaraa(2003);
        assertEquals(p.annaRahamaara(), 12003);
    } 
    
    @Test
    public void pelaajallaOikeaSummaRahaaKunVahennetaan() {
        p.muutaRahamaaraa(-300);
        assertEquals(p.annaRahamaara(), 9700);
    }
    
    @Test
    public void pelaajallaEiOleAlussaTyontekijoita() {
        assertEquals(p.annaTyontekijat().isEmpty(), true);
    }
    
    @Test
    public void tyontekijanLisaysToimii() {
        Tyontekija t = new Tyontekija(true, "");
        p.lisaaTyontekija(t);
        assertEquals(p.annaTyontekijat().size(), 1);
    }
    
    @Test
    public void tyontekijanPoistoToimii() {
        Tyontekija t = new Tyontekija(true, "");
        p.lisaaTyontekija(t);
        p.poistaTyontekija(t);
        assertEquals(p.annaTyontekijat().isEmpty(), true);
    }
    
    @Test
    public void oikeanTyontekijanPoistoToimii() {
        Tyontekija a = new Tyontekija(true, "");
        Tyontekija b = new Tyontekija(false, "");
        p.lisaaTyontekija(a);
        p.lisaaTyontekija(b);
        p.poistaTyontekija(a);
        ArrayList l = p.annaTyontekijat();
        assertEquals(l.get(0), b);
    }
    
    @Test
    public void tyontekijanPoistoToimiiOikeallaSyotteella() {
       Tyontekija t = new Tyontekija(true, "");
       p.lisaaTyontekija(t);
       assertEquals(true, p.poistaTyontekija(t));
    }
    
    @Test
    public void olematontaTyontekijaEiVoiPoistaa() {
        Tyontekija t = new Tyontekija(true, "");
        Tyontekija k = new Tyontekija(false, "");
        p.lisaaTyontekija(k);
        assertEquals(false, p.poistaTyontekija(t));
    }
    
    @Test
    public void palkatLasketaanOikeinIlmanTyontekijoita() {
        p.seuraavaVuoro();
        assertEquals(p.annaRahamaara(), 10000);
    }
    
    @Test
    public void palkatLasketaanOikeinKunTyontekijoita() {
        p.lisaaTyontekija(new Tyontekija(true, ""));
        p.seuraavaVuoro();
        assertEquals(p.annaRahamaara(), 9000);
    }
    
    @Test
    public void tyomaanLisaysToimiiOikein() {
        Tyomaa te = new Tyomaa(12, "");
        this.p.lisääTyomaa(te);
        assertEquals(this.p.annaTyomaat().size(), 1);
    }
    
    @Test
    public void tyomaidenAntoToimiiOikein() {
        ArrayList<Tyomaa> l = new ArrayList<Tyomaa>();
        Tyomaa te = new Tyomaa(12, "");
        Tyomaa td = new Tyomaa(10, "asdf");
        l.add(te);
        l.add(td);
        this.p.lisääTyomaa(te);
        this.p.lisääTyomaa(td);
        assertEquals(this.p.annaTyomaat(), l);
    }
    
    @Test
    public void tyomaanPoistoToimiiOikein() {
        Tyomaa te = new Tyomaa(23, "");
        this.p.lisääTyomaa(te);
        this.p.poistaTyomaa(te);
        assertEquals(this.p.annaTyomaat().size(), 0);
    }
    
    @Test
    public void tyontekijaLisaysTyomaalleToimii() {
        Tyomaa te = new Tyomaa(23, "");
        Tyontekija tt = new Tyontekija(true, "");
        this.p.lisaaTyontekijaTyomaalle(tt, te);
        assertEquals(te.getTyontekijat().size(), 1);
    }
    
    @Test
    public void tyontekijanLisaysTyomaalleToimiiKaksi() {
        Tyomaa te = new Tyomaa(23, "");
        Tyontekija tt = new Tyontekija(true, "");
        this.p.lisaaTyontekijaTyomaalle(tt, te);
        assertEquals(tt.missaToissa(), te);
    }
    
    @Test
    public void tyontekijaPoistoTyomaaltaToimii() {
        Tyomaa te = new Tyomaa(23, "");
        Tyontekija tt = new Tyontekija(true, "");
        this.p.lisaaTyontekijaTyomaalle(tt, te);
        this.p.poistaTyontekijaTyomaalta(tt, te);
        assertEquals(te.getTyontekijat().size(), 0);
    }
    
    @Test
    public void tyontekijaPoistoTyomaaltaToimiiKaksi() {
        Tyomaa te = new Tyomaa(23, "");
        Tyontekija tt = new Tyontekija(true, "");
        this.p.lisaaTyontekijaTyomaalle(tt, te);
        this.p.poistaTyontekijaTyomaalta(tt, te);
        assertEquals(tt.missaToissa(), null);
    }
    
    @Test
    public void tyomaatPaivittyvatOikein() {
        Tyomaa te = new Tyomaa(23, "");
        Tyontekija tt = new Tyontekija(true, "");
        this.p.lisääTyomaa(te);
        this.p.lisaaTyontekijaTyomaalle(tt, te);
        this.p.seuraavaVuoro();
        assertEquals(te.getValmiina(), 10);
    }
    
    @Test
    public void lisaaTyontekijaTyomaalleLaitaToihinMetodi() {
        Tyomaa te = new Tyomaa(23, "");
        Tyontekija tt = new Tyontekija(true, "");
        this.p.lisaaTyontekijaTyomaalle(tt, te);
        assertEquals(tt.missaToissa(), te);
    }
    
    @Test
    public void pelaajaSaaRahaaKunTyomaaValmis() {
        Tyomaa maa = new Tyomaa(9, "");
        Tyontekija t = new Tyontekija(true, "");
        p.lisääTyomaa(maa);
        p.lisaaTyontekija(t);
        int rahatAlussa = this.p.annaRahamaara();
        int maaPalkkio = maa.getPalkkio();
        int palkat = t.getPalkka();
        this.p.lisaaTyontekijaTyomaalle(t, maa);
        this.p.seuraavaVuoro();
        int rahatVuoronJalkeen = this.p.annaRahamaara();
        assertEquals(rahatVuoronJalkeen, maaPalkkio+rahatAlussa-palkat);
    }
    
    @Test
    public void tyomaaPoistuuKunValmista() {
        Tyomaa maa = new Tyomaa(9, "");
        Tyontekija t = new Tyontekija(true, "");
        p.lisääTyomaa(maa);
        p.lisaaTyontekija(t);
        this.p.lisaaTyontekijaTyomaalle(t, maa);
        this.p.seuraavaVuoro();
        assertEquals(p.annaTyomaat().size(), 0);
    }
    
    @Test
    public void tyontekijatPoistuvatTyomaaltaKunValmista() {
        Tyomaa maa = new Tyomaa(9, "");
        Tyontekija t = new Tyontekija(true, "");
        p.lisääTyomaa(maa);
        p.lisaaTyontekija(t);
        this.p.lisaaTyontekijaTyomaalle(t, maa);
        this.p.seuraavaVuoro();
        assertEquals(null, t.missaToissa());
    }
    
}
