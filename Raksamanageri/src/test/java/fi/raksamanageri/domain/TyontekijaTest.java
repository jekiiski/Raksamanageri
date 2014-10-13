package fi.raksamanageri.domain;

import fi.raksamanageri.domain.Tyomaa;
//import fi.raksamanageri.domain.Patevyys;
import fi.raksamanageri.domain.Tyontekija;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TyontekijaTest {
    
    private Tyontekija koti;
    private Tyontekija ulko;
    
    public TyontekijaTest() {
    }
    
        @Before
    public void setUp() {
        this.koti = new Tyontekija(true, "");
        this.ulko = new Tyontekija(false, "");
    }
    
    @Test
    public void kotimainenTyontekijaKonstruktorissaOikeaPalkka() {
        assertEquals(this.koti.getPalkka(), 400);
    }
    
    @Test
    public void ulkomoinenTyontekijaKonstruktorissaOikeaPalkka() {
        assertEquals(this.ulko.getPalkka(), 300);
    }
    
    @Test
    public void kotimainenTyontekijaOikeaPalkkaMuutettaessa() {
        this.koti.setPalkka(1500);
        assertEquals(this.koti.getPalkka(), 1500);
    }
    
    @Test
    public void ulkomainenTyotekijaOikeaPalkkaMuutettaessa() {
        this.ulko.setPalkka(1000);
        assertEquals(this.ulko.getPalkka(), 1000);
    }
    
    @Test
    public void palkkaEiVoiOllaNegatiivinen() {
        this.koti.setPalkka(-100);
        assertEquals(this.koti.getPalkka(), 400);
    }
    
    @Test
    public void palkkaEiVoiOllaNolla() {
        this.ulko.setPalkka(0);
        assertEquals(this.ulko.getPalkka(), 300);
    }
    
    @Test
    public void kotimainenTyontekijaKonstruktorissaOikeaTyoteho() {
        assertEquals(this.koti.getTyoteho(), 10);
    }
    
    @Test
    public void ulkomainenTyontekijaKonstruktorissaOikeaTyoteho() {
        assertEquals(this.ulko.getTyoteho(), 11);
    }
    
    @Test
    public void kotimainenTyontekijaOikeaTyotehoMuutettaessa() {
        this.koti.setTyoTeho(15);
        assertEquals(this.koti.getTyoteho(), 15);
    }
    
    @Test
    public void ulkomainenTyontekijaOikeaTyotehoMuutettaessa() {
        this.ulko.setTyoTeho(1);
        assertEquals(this.ulko.getTyoteho(), 1);
    }
    
    @Test
    public void tyotehoEiVoiOllaNegatiivinen() {
        this.koti.setTyoTeho(-1);
        assertEquals(this.koti.getTyoteho(), 10);
    }
    
    @Test
    public void tyotehoEiVoiOllaNolla() {
        this.ulko.setTyoTeho(0);
        assertEquals(this.ulko.getTyoteho(), 11);
    }
    
//    @Test
//    public void patevyydenLisaysOnnistuu() {
//        Patevyys p = new Patevyys("sähkö");
//        this.koti.lisaaPatevyys(p);
//        assertEquals(p, this.koti.annaPatevyydet().get(0));
//    }
//    
//    @Test
//    public void useanPatevyydenLisaysToimii() {
//        this.ulko.lisaaPatevyys(new Patevyys("a"));
//        this.ulko.lisaaPatevyys(new Patevyys("k"));
//        assertEquals(this.ulko.annaPatevyydet().size(), 2);
//    }
    
    @Test
    public void toStringMetodiToimiiHalutustiKotimaisella() {
        String s = "Kotimainen työntekijä, palkka: 400, työteho: 10";
        assertEquals(this.koti.toString(), s);
    }
    
    @Test
    public void toStringMetodiToimiiHalutustiUlkomaisella() {
        String s = "Ulkomainen työntekijä, palkka: 300, työteho: 11";
        assertEquals(this.ulko.toString(), s);
    }
    
//    @Test
//    public void patevyydenLisaysNostaaTyotehoa() {
//        this.koti.lisaaPatevyys(new Patevyys("Putki"));
//        assertEquals(this.koti.getTyoteho(), 11);
//    }
//    
//    @Test
//    public void patevyydenLisaysNostaaPalkkaa() {
//        this.koti.lisaaPatevyys(new Patevyys("koe"));
//        assertEquals(this.koti.getPalkka(), 500);
//    }
    
    @Test
    public void tyontekijaTietaaMissaOnToissa() {
        Tyomaa t = new Tyomaa(10, "asdf");
        this.koti.laitaToihin(t);
        assertEquals(this.koti.missaToissa(), t);
    }
    
    @Test
    public void nimiOnOikein() {
        assertEquals(this.koti.getNimi(), "");
    }
}
