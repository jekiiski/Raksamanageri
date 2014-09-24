package fi.raksamanageri.domain;

import fi.raksamanageri.logiikka.SatunnaisGeneraattori;
import java.util.ArrayList;

/**
 * Peli sisältää peliä pelaavan pelaajan tiedot, uudet työntekijät sekä
 * uudet työmaat.
 */
public class Peli {

    private boolean voitto;
    private boolean vararikko;
    private Pelaaja pelaaja;
    private ArrayList<Tyomaa> vapaatTyomaat;
    private ArrayList<Tyontekija> vapaatTyontekijat;
    private SatunnaisGeneraattori sk;

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
        this.pelaaja.seuraavaVuoro();
    }
}
