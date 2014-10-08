package fi.raksamanageri.domain;

import fi.raksamanageri.tyokalut.SatunnaisGeneraattori;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

/**
 * Peli sisältää peliä pelaavan pelaajan tiedot, pelitilanteen, 
 * uudet työntekijät sekä uudet työmaat. 
 */
public class Peli implements java.io.Serializable {

    private boolean voitto;
    private boolean vararikko;
    private Pelaaja pelaaja;
    private ArrayList<Tyomaa> vapaatTyomaat;
    private ArrayList<Tyontekija> vapaatTyontekijat;
    private SatunnaisGeneraattori sk;
    private ArrayList<Patevyys> patevyydet;

    /**
     * Konstruktori ei tarvitse parametreja. 
     * Muuttujien alustus:
     * 1. Luodaan uusi pelaaja
     * 2. Asetetaan voitto ja vararikko tilaan false
     * 3. Alustetaan työntekijöiden ja työmaiden listat
     */
    public Peli() {
        this.pelaaja = new Pelaaja();
        this.voitto = false;
        this.vararikko = false;
        this.vapaatTyomaat = new ArrayList<Tyomaa>();
        this.vapaatTyontekijat = new ArrayList<Tyontekija>();
        this.sk = new SatunnaisGeneraattori();
        
        // Tässä versiossa pätevyyksiä ei vielä käytetä!
//        // alustetaan pätevyydet, vakiona 3 erilaista
//        this.patevyydet = new ArrayList<Patevyys>();
//        this.patevyydet.add(new Patevyys("Sähkö"));
//        this.patevyydet.add(new Patevyys("Putki"));
//        this.patevyydet.add(new Patevyys("Julkisivu"));
    }

    /**
     * Metodilla peliin lisätään uusi työmaa, jonka pelaaja voi halutessaan 
     * ottaa työn alle.
     * 
     * @param t lisättävä työmaa
     */
    public void lisaaUusiTyomaa(Tyomaa t) {
        this.vapaatTyomaat.add(t);
    }
    
    /**
     * Metodilla voidaan arpoa satunnaisgeneraattorilla uusi työmaa, jonka pelaaja
     * voi otta työn alle.
     */
    public void arvoUusiTyomaa() {
        this.vapaatTyomaat.add(this.sk.generoiUusiTyomaa());
    }
    
    /**
     * Metodilla voidaan arpoa uusi työntekijä, jonka pelaaja voi palkata. 
     */
    public void arvoUusiTyontekija() {
        this.vapaatTyontekijat.add(this.sk.generoiUusiTyontekija());
    }

    /**
     * Metodi poistaa parametrina annetun työmaan vapaiden työmaiden joukosta
     * 
     * @param t poistettava työmaa 
     */
    public void poistaUusiTyomaa(Tyomaa t) {
        if (this.vapaatTyomaat.contains(t)) {
            this.vapaatTyomaat.remove(t);
        }
    }
    
    /**
     * Metodi lisää uuden työntekijän, jonka pelaaja voi palkata.
     * 
     * @param te lisättävä työntekijä
     */
    public void lisaaUusiTyontekija(Tyontekija te) {
        this.vapaatTyontekijat.add(te);
    }
    
    /**
     * Metodilla poistetaan työntekijä vapaiden työntekijöiden listalta
     * 
     * @param te listalta poistettava työntekijä
     */
    public void poistaUusiTyontekija(Tyontekija te) {
        if (this.vapaatTyontekijat.contains(te)) {
            this.vapaatTyontekijat.remove(te);
        }
    }

    /**
     * Metodi palauttaa vapaat työmaat
     * 
     * @return vapaat työmaat 
     */
    public ArrayList<Tyomaa> getTyomaat() {
        return this.vapaatTyomaat;
    }

    /**
     * Metodi palauttaa vapaat työntekijät
     * 
     * @return vapaat työntekijät 
     */
    public ArrayList<Tyontekija> getVapaatTyontekijat() {
        return this.vapaatTyontekijat;
    }

    /**
     * Palauttaa pelin pelaajan
     * 
     * @return pelaaja 
     */
    public Pelaaja getPelaaja() {
        return this.pelaaja;
    }

    /**
     * Metodi päivittää peli-luokan seuraavan vuoron:
     * 1. Arvotaan käykö rakennustarkastaja
     * 1a. Jos käy niin lisätään työmaan laajuutta
     * 2. Arvotaan käykö verotarkastaja
     * 2a. Jos käy niin langetetaan jälkivero
     * 3. Luodaan 3 kpl uusia työmaita ja työntekijöitä
     * 4. Kutsutaan pelaajan seuraavaVuoro-metodia
     * 5. Tarkistetaan onko vararikko tai voitto
     * 
     * @see Pelaaja.seuraavaVuoro()
     */
    public ArrayList<String> seuraavaVuoro() {
        ArrayList<String> ulos = new ArrayList<String>();
        
        // Rakennustarkastajan käynti
        if (this.sk.rakennustarkastajaKylaan()) {
            String r = lisaaLaajuuttaHuonostaTyonjaljesta();
            if (!r.isEmpty()) {
                ulos.add(r);
            }
        }
        
        // verottajan käynti
        if (this.sk.verottajanTarkastus()) {
            String v = verotaUlkomaisistaTyontekijoista();
            if (!v.isEmpty()) {
                ulos.add(v);
            }
        }
        
        // uusien työmaiden generointi, vanhat poistetaan
        this.vapaatTyomaat.clear();
        for (int i=0; i<3; i++) {
            this.vapaatTyomaat.add(this.sk.generoiUusiTyomaa());
        }
 
        // uusien työntekijöiden generointi, vanhat poistetaan
        this.vapaatTyontekijat.clear();
        for (int i=0; i<3; i++) {
            this.vapaatTyontekijat.add(this.sk.generoiUusiTyontekija());
        }
        
        this.pelaaja.seuraavaVuoro();
        
        // päivitetään booleanmuuttujat
        if (this.pelaaja.annaRahamaara() <= -1) {
            this.vararikko = true;
        } else if (this.pelaaja.annaRahamaara() >= 1000000) {
            this.voitto = true;
        }
        
        return ulos;
    }

    /**
     * Yksityinen metodi jossa arvotaan sakko joka vähennetään pelaajalta. 
     * Tähän metodiin tulisi tulla vain seuraavaVuoro-metodin kautta
     * 
     * @see Peli.seuraavaVuoro()
     * 
     * @return viesti jossa kerrotaan veromätkyistä
     */
    private String verotaUlkomaisistaTyontekijoista() throws HeadlessException {
        String ulos = "";
        for (Tyomaa t : this.pelaaja.annaTyomaat()) {
            if (!t.onkoKaytettyVainKotimaisiaTyontekijoita()) {
                int sakko = t.getLaajuus() * 30;
                ulos = "Työmaalla " + t.getNimi()
                        + " et ole maksanut veroja ainakaan yhdeltä työntekijältä. "
                        + "Verottaja määrää sinulle veromätkyjä " + sakko;
                this.pelaaja.muutaRahamaaraa(-sakko);
            }
        }
        return ulos;
    }

    /**
     * Yksityine metodi, jossa arvotaan lisätyön määrä joka lisätään pelaajan
     * työmaalle. Tähän metodiin tulisi tulla vain seuraavaVuoro-metodin kautta
     * 
     * @see Peli.seuraavaVuoro()
     * 
     * @return viesti, jossa kerrotaan työmaan laajuuden lisäämisestä
     */
    private String lisaaLaajuuttaHuonostaTyonjaljesta() throws HeadlessException {
        String ulos = "";
        for (Tyomaa t : this.pelaaja.annaTyomaat()) {
            if (!t.onkoKaytettyVainKotimaisiaTyontekijoita()) {
                int lisaTyot = t.getLaajuus() / 3;
                ulos = "Työmaalla " + t.getNimi()
                        + " ulkomaiset työntekijä ovat tehneet niin huonoa "
                        + "työtä, että rakennustarkastaja määrää sinut "
                        + "teettämään " + lisaTyot + " yksikön verran lisää "
                        + "töitä";
                t.lisaaLaajuutta(lisaTyot);
            }
        }
        return ulos;
    }
    
    /**
     * Mikäli pelaaja on saanut kasaan 1000000 rahayksikköä peli on voitettu
     * 
     * @return voitto 
     */
    public boolean onkoVoitettu() {
        return this.voitto;
    }
    
    /**
     * Mikäli pelaajan rahat loppuvat, peli on hävitty
     * 
     * @return häviö
     */
    public boolean onkoHavittu() {
        return this.vararikko;
    }
}
