package fi.raksamanageri.domain;

import java.util.ArrayList;

/**
 * Luokka kuvaa työmaalla työskentelevää työntekijää, jonka palkan maksaa pelaaja
 * @author eikkari
 */
public class Tyontekija {

    private int palkka;
    private final boolean kotimainen;
    private int tyoteho;
    private ArrayList patevyydet;
    private Tyomaa tyoMaa;
    private String nimi;

    /**
     * Konstruktorissa määritellään työntekijä. Kotimainen on tehokkaampi ja kalliimpi, 
     * mutta ulkomainen kiertää veroja ja herättää rakennustarkastajan huomion.
     * 
     * @param onkoKotimainen true jos kotimainen
     * @param nimi työntekijän nimi
     */
    public Tyontekija(boolean onkoKotimainen, String nimi) {
        this.kotimainen = onkoKotimainen;
        this.patevyydet = new ArrayList<Patevyys>();
        this.tyoMaa = null;
        this.nimi = nimi;

        if (onkoKotimainen) {
            this.palkka = 1000;
            this.tyoteho = 10;
        } else {
            this.palkka = 400;
            this.tyoteho = 8;
        }
    }

    /**
     * Palauttaa työntekijän kaikki pätevyydet
     * 
     * @return pätevyydet 
     */
    public ArrayList<Patevyys> annaPatevyydet() {
        return this.patevyydet;
    }

    /**
     * Metodilla lisätään työntekijälle pätevyys. Jokainen lisäys nostaa työntekijän
     * palkkaa.
     * 
     * @param patevyys lisättävä pätevyys 
     */
    public void lisaaPatevyys(Patevyys patevyys) {
        if (!this.patevyydet.contains(patevyys)) {
            this.patevyydet.add(patevyys);
            this.tyoteho++;
            this.palkka += 100;
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
