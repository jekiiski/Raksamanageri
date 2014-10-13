package fi.raksamanageri.domain;

/**
 * Luokka kuvaa työmaalla työskentelevää työntekijää, jonka palkan maksaa pelaaja
 * @author eikkari
 */
public class Tyontekija implements java.io.Serializable {

    private int palkka;
    private final boolean kotimainen;
    private int tyoteho;
    private Tyomaa tyoMaa;
    private String nimi;
    private static int KOTIMAINEN_PALKKA = 400;
    private static int ULKOMAINEN_PALKKA = 300;
    private static int KOTIMAINEN_TYOTEHO = 10;
    private static int ULKOMAINEN_TYOTEHO = 11;

    /**
     * Konstruktorissa määritellään työntekijä. Kotimainen on tehokkaampi ja kalliimpi, 
     * mutta ulkomainen kiertää veroja ja herättää rakennustarkastajan huomion.
     * 
     * @param onkoKotimainen true jos kotimainen
     * @param nimi työntekijän nimi
     */
    public Tyontekija(boolean onkoKotimainen, String nimi) {
        this.kotimainen = onkoKotimainen;
        this.tyoMaa = null;
        this.nimi = nimi;

        if (onkoKotimainen) {
            this.palkka = KOTIMAINEN_PALKKA;
            this.tyoteho = KOTIMAINEN_TYOTEHO;
        } else {
            this.palkka = ULKOMAINEN_PALKKA;
            this.tyoteho = ULKOMAINEN_TYOTEHO;
        }
    }

    /**
     * Palauttaa työntekijän vaatiman palkan
     * @return palkka
     */
    public int getPalkka() {
        return this.palkka;
    }

    /**
     * Metodilla voidaan asettaa työntekijälle uusi palkka
     * 
     * @param maara uusi palkka
     */
    public void setPalkka(int maara) {
        if (maara > 0) {
            this.palkka = maara;
        }
    }

    /**
     * Palauttaa työntekijän työtehon
     * 
     * @return työteho
     */
    public int getTyoteho() {
        return this.tyoteho;
    }

    /**
     * Metodilla voidaan muuttaa työntekijän työtehoa
     * 
     * @param tyoteho uusi työteho 
     */
    public void setTyoTeho(int tyoteho) {
        if (tyoteho > 0) {
            this.tyoteho = tyoteho;
        } 
    }

    /**
     * Palauttaa true, mikäli kyseessä on kotimainen työntekijä
     * 
     * @return true jos kotimainen
     */
    public boolean onkoKotimainen() {
        return this.kotimainen;
    }
    
    /**
     * Metodilla työntekijä voidaan laittaa töihin työmaalle.
     * 
     * @param maa työmaa, jonne työntekijä menee töihin
     */
    public void laitaToihin(Tyomaa maa) {
        this.tyoMaa = maa;
    }
    
    /**
     * Metodilla työntekijä poistetaan työmaalta. Työntekijä on vapaalla.
     */
    public void poistaTyomaalta() {
        this.tyoMaa = null;
    }
    
    /**
     * Palauttaa työmaan, jossa työntekijä on töissä. Mikäli työntekijä
     * ei ole töissä palauttaa metodi null.
     * 
     * @return työmaa missä töissä 
     */
    public Tyomaa missaToissa() {
        return this.tyoMaa;
    }
    
    /**
     * Palauttaa pelaajan nimen.
     * 
     * @return nimi
     */
    public String getNimi() {
        return this.nimi;
    }
    
    @Override
    public String toString() {
        String koti = "";
        if (this.onkoKotimainen()) {
            koti = "Kotimainen";
        } else {
            koti = "Ulkomainen";
        }
        return koti + " työntekijä, palkka: " + this.palkka
                + ", työteho: " + this.tyoteho;
    }

}
