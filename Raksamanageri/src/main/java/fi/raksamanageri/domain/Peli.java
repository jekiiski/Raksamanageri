package fi.raksamanageri.domain;

import fi.raksamanageri.logiikka.SatunnaisGeneraattori;
import fi.raksamanageri.logiikka.Tiedostonkasittelija;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

/**
 * Peli sisältää peliä pelaavan pelaajan tiedot, uudet työntekijät sekä
 * uudet työmaat.
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
     * Konstruktori ei tarvitse parametreja. Tässä alustetaan peli ja sen muuttujat
     */
    public Peli() {
        this.pelaaja = new Pelaaja();
        this.voitto = false;
        this.vararikko = false;
        this.vapaatTyomaat = new ArrayList<Tyomaa>();
        this.vapaatTyontekijat = new ArrayList<Tyontekija>();
        this.sk = new SatunnaisGeneraattori();
        
        // alustetaan pätevyydet, vakiona 3 erilaista
        this.patevyydet = new ArrayList<Patevyys>();
        this.patevyydet.add(new Patevyys("Sähkö"));
        this.patevyydet.add(new Patevyys("Putki"));
        this.patevyydet.add(new Patevyys("Julkisivu"));
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
     * Metodi päivittää peli-luokan seuraavan vuoron. 
     * 1. Päivitetään pelaajan työmaat
     * 2. Kutsutaan pelaajan seuraavaVuoro()-metodia
     * 
     * @see Pelaaja.seuraavaVuoro()
     */
    public void seuraavaVuoro() {
        // Rakennustarkastajan käynti
        // IMPLEMENTOINTI KESKEN
        if (this.sk.rakennustarkastajaKylaan()) {
            for (Tyomaa t : this.pelaaja.annaTyomaat()) {
                if (!t.onkoKaytettyVainKotimaisiaTyontekijoita()) {
                    int lisaTyot = t.getLaajuus() / 3;
                    JOptionPane.showMessageDialog(null, "Työmaalla " + t.getNimi()
                            + " ulkomaiset työntekijä ovat tehneet niin huonoa "
                            + "työtä, että rakennustarkastaja määrää sinut "
                            + "teettämään " + lisaTyot + " yksikön verran lisää "
                            + "töitä",
                            "Rakannustarkastajan tarkastus", WARNING_MESSAGE);
                    t.lisaaLaajuutta(lisaTyot);
                }
            }
        }
        
        // verottajan käynti
        if (this.sk.verottajanTarkastus()) {
            for (Tyomaa t : this.pelaaja.annaTyomaat()) {
                if (!t.onkoKaytettyVainKotimaisiaTyontekijoita()) {
                    int sakko = t.getLaajuus() * 30;
                    JOptionPane.showMessageDialog(null, "Työmaalla " + t.getNimi()
                            + " et ole maksanut veroja ainakaan yhdeltä työntekijältä. "
                            + "Verottaja määrää sinulle veromätkyjä " + sakko,
                            "Verottajan tarkastus", WARNING_MESSAGE);
                    this.pelaaja.muutaRahamaaraa(-sakko);
                }
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
        
        
        // GUI ilmoittaa pelaajalle vararikosta ja voitosta
        if (this.pelaaja.annaRahamaara() < 0) {
            this.vararikko = true;
        } else if (this.pelaaja.annaRahamaara() > 1000000) {
            this.voitto = true;
        }
    }
    
    public boolean onkoVoitettu() {
        return this.voitto;
    }
    
    public boolean onkoHavittu() {
        return this.vararikko;
    }
}
