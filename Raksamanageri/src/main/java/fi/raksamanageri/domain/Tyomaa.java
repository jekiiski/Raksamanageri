package fi.raksamanageri.domain;

import fi.raksamanageri.tyokalut.SatunnaisGeneraattori;
import java.util.ArrayList;

/**
 * Luokka kuvaa työmaata, jolle pelaaja palkkaa työntekijöitä. Kun työntekijät
 * saavat työmaan tehtyä, pelaajalle siirtyy työmaan palkkio.
 *
 * @author eikkari
 */
public class Tyomaa implements java.io.Serializable {

    private int palkkio;
    private int laajuus;
    private int valmiina;
    private int kokonaisTehokkuus;
    private boolean kaytettyKotimaista;
    private ArrayList<Tyontekija> tyontekijat;
    private String nimi;
    private SatunnaisGeneraattori sk;
    private ArrayList<Patevyys> vaaditutPatevyydet;

    /**
     * Alustaa työmaan.
     *
     * @param laajuus kuinka laaja työmaa on
     * @param nimi työmaan nimi
     */
    public Tyomaa(int laajuus, String nimi) {
        this.kokonaisTehokkuus = 0;
        this.kaytettyKotimaista = true;
        this.laajuus = laajuus;
        this.valmiina = 0;
        this.tyontekijat = new ArrayList<Tyontekija>();
        this.nimi = nimi;
        this.sk = new SatunnaisGeneraattori();
        this.palkkio = this.sk.generoiTyomaaPalkkio(this);
        this.vaaditutPatevyydet = new ArrayList<Patevyys>();

    }

    /**
     * Metodilla voidaan työmaalle lisätä vaadittava pätevyys. Työmaalle ei voi
     * lisätä pätevyyttä joka sillä jo on vaatimuksena
     *
     * @param p Lisättävä pätevyys
     */
    public void lisaaVaadittavaPatevyys(Patevyys p) {
        if (!this.vaaditutPatevyydet.contains(p)) {
            this.vaaditutPatevyydet.add(p);
        }
    }

    /**
     * Palauttaa ArrayList-muodossa Patevyys-oliot joita työmaa vaatii
     * 
     * @return Pätevyys
     * 
     * @see Patevyys
     */
    public ArrayList<Patevyys> annaVaaditutPatevyydet() {
        return this.vaaditutPatevyydet;
    }

    /**
     * Palauttaa int arvon, kuinka paljon työmaasta on valmiina
     *
     * @return valmiina
     */
    public int getValmiina() {
        return this.valmiina;
    }

    /**
     * Palauttaa kaikkien työmaalla työskentelevien työntekijöiden
     * työtehokkuuden summan.
     *
     * @return kokonaistehokkuus
     */
    public int getKokonaisTehokkuus() {
        return this.kokonaisTehokkuus;
    }

    /**
     * Palauttaa työmaan valmistumisesta saatavan palkkion.
     *
     * @return palkkio
     */
    public int getPalkkio() {
        return this.palkkio;
    }

    /**
     * Palauttaa työmaan laajuuden
     *
     * @return laajuus
     */
    public int getLaajuus() {
        return this.laajuus;
    }

    /**
     * Jos työmaalla on käytetty kerrankin ulkomaista työntekijää, metodi
     * palauttaa false, muuten true.
     *
     * @return olivatko kaikki työntekijät kotimaisia
     */
    public boolean onkoKaytettyVainKotimaisiaTyontekijoita() {
        return this.kaytettyKotimaista;
    }

    /**
     * Palauttaa työmaalla työskentelevät työntekijät
     *
     * @return työntekijät
     */
    public ArrayList<Tyontekija> getTyontekijat() {
        return this.tyontekijat;
    }

    /**
     * Metodilla lisätään työmaalle uusia työntekijöitä
     *
     * @param t lisättävä työntekijä
     */
    public void lisaaTyontekija(Tyontekija t) {
        this.kokonaisTehokkuus += t.getTyoteho();
        t.laitaToihin(this);
        this.tyontekijat.add(t);
    }

    /**
     * Metodilla poistetaan työmaalla työskentelevä työntekijä
     *
     * @param t työmaan työntekijä
     */
    public void poistaTyontekija(Tyontekija t) {
        this.kokonaisTehokkuus -= t.getTyoteho();
        t.poistaTyomaalta();
        this.tyontekijat.remove(t);
    }

    /**
     * Metodi valmistaa työmaan seuraavaan vuoroon:
     * 1. kokonaistehokkuus lisätään valmiiksi 
     * 2. tarkistetaan, oliko työmaalla ulkomaisia työntekijöitä
     */
    public void seuraavaVuoro() {
        this.valmiina += this.kokonaisTehokkuus;

        // tarkitetaan kotimaisuusaste vasta nyt
        for (Tyontekija t : this.tyontekijat) {
            if (!t.onkoKotimainen()) {
                this.kaytettyKotimaista = false;
            }
        }
    }

    /**
     * Metodilla lisätään työmaan laajuutta. Jos rakennustarkastaja huomaa
     * korjaamisen aihetta työnjäljessä, voidaan työn laajuutta lisätä. Lisäys
     * ei nosta työmaasta saatavaa palkkiota.
     *
     * @param maara lisättävä määrä
     */
    public void lisaaLaajuutta(int maara) {
        this.laajuus += maara;
    }

    /**
     * Palauttaa työmaan nimen
     *
     * @return nimi
     */
    public String getNimi() {
        return this.nimi;
    }

    /**
     * Metodilla voidaan asettaa työmaalle uusi palkkio.
     *
     * @param palkkio uusi palkkio
     */
    public void setPalkkio(int palkkio) {
        this.palkkio = palkkio;
    }

    @Override
    public String toString() {
        return "Tyomaa, laajuus: " + getLaajuus() + ", tehty: "
                + getValmiina() + ", palkkio: " + getPalkkio()
                + " käytetty kotimaista: " + this.kaytettyKotimaista;
    }
}
