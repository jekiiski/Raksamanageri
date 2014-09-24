package fi.raksamanageri.domain;

import java.util.ArrayList;

/**
 * Luokka kuvaa pelajaa ja antaa pelin kannalta tärkeät metodit käyttöön
 */
public class Pelaaja {

    private int rahaMaara;
    private static final int ALKURAHA = 10000;
    private final ArrayList<Tyontekija> tyonTekijat;
    private final ArrayList<Tyomaa> tyomaat;

    /**
     * Konstruktori ei tarvitse parametreja. Se alustaa pelaajan rahat 10000:een
     * ja alustaa pelaajan sisäiset muuttujat
     */
    public Pelaaja() {
        this.rahaMaara = ALKURAHA;
        this.tyonTekijat = new ArrayList<Tyontekija>();
        this.tyomaat = new ArrayList<Tyomaa>();
    }

    /**
     * Palauttaa pelaajan tämänhetkisen rahamäärän
     * @return rahamäärä
     */
    public int annaRahamaara() {
        return this.rahaMaara;
    }

    /**
     * Muuttaa pelaajan rahamäärää annetun määrän verran. Jos annettu määrä on
     * negatiivinen, vähennetään annettu määrä pelaajan rahoista
     * 
     * @param maara kuinka paljon rahamäärää muutetaan 
     */
    public void muutaRahamaaraa(int maara) {
        this.rahaMaara += maara;
    }

    /**
     * Metodi lisää pelaajalle työntekijän
     * 
     * @param tyontekija lisättävä Työntekijä-luokan olio
     */
    public void lisaaTyontekija(Tyontekija tyontekija) {
        this.tyonTekijat.add(tyontekija);
    }

    /**
     * Metodi poistaa pelaajalta työntekijän, mikäli semmoinen on.
     * 
     * @param tyontekija poistettava työntekijä
     * 
     * @return true, mikäli työntekijä oli pelaajalla. Jos työntekijää ei ollut
     * palautetaan false
     */
    public boolean poistaTyontekija(Tyontekija tyontekija) {
        if (this.tyonTekijat.contains(tyontekija)) {
            this.tyonTekijat.remove(tyontekija);
            return true;
        }
        return false;
    }

    /**
     * Antaa pelaajan kaikki työntekijät ArrayList-muodossa
     * 
     * @return työntekijät 
     */
    public ArrayList<Tyontekija> annaTyontekijat() {
        return this.tyonTekijat;
    }

    /**
     * Metodilla lisätään pelaajalle työmaa, johon voi sijoittaa työntekijöitä
     * 
     * @param maa lisättä Työmaa 
     */
    public void lisääTyomaa(Tyomaa maa) {
        this.tyomaat.add(maa);
    }

    /**
     * Palauttaa kaikki pelaajan työmaat ArrayListin muodossa
     * 
     * @return työmaat 
     */
    public ArrayList<Tyomaa> annaTyomaat() {
        return this.tyomaat;
    }

    /**
     * Pelaajan työmaiden listasta poistetaan parametrina saatu työmaa
     * 
     * @param maa poistettava työmaa 
     */
    public void poistaTyomaa(Tyomaa maa) {
        if (this.tyomaat.contains(maa)) {
            this.tyomaat.remove(maa);
        }
    }

    /**
     * Metodilla lisätään työntekijä työmaalle
     * 
     * @param tt työmaalle lisättävä työntekijä
     * @param tm työmaa jonne työntekijä lisätään
     */
    public void lisaaTyontekijaTyomaalle(Tyontekija tt, Tyomaa tm) {
        tm.lisaaTyontekija(tt);
        tt.laitaToihin(tm);
    }

    /**
     * Metodilla poistetaan työntekijä työmaalta
     * 
     * @param tt työntekijä, joka poistetaan työmaalta
     * @param tm työmaa, josta työntekijä poistetaan
     */
    public void poistaTyontekijaTyomaalta(Tyontekija tt, Tyomaa tm) {
        tm.poistaTyontekija(tt);
        tt.poistaTyomaalta();
    }
    
    /**
     * Päivittää pelaajan tiedot ja siirtyy seuraavaan vuoroon:
     * 1. Pelaajan rahoista vähennetään työntekijöiden palkat
     * 2. Pelaajan työmaiden edistymiset päivitetään
     */
    public void seuraavaVuoro() {
        laskePalkat();
        paivitaTyomaat();
    }

    private void laskePalkat() {
        int palkat = 0;
        for (Tyontekija t : this.tyonTekijat) {
            palkat += t.getPalkka();
        }
        muutaRahamaaraa(-palkat);
    }

    private void paivitaTyomaat() {
        for (int i = 0; i < this.tyomaat.size(); i++) {
            this.tyomaat.get(i).seuraavaVuoro();
            
            // jos työmaa tulee valmiiksi
            if (this.tyomaat.get(i).getLaajuus() <= this.tyomaat.get(i).getValmiina()) {
                // lisää palkkio pelaajan rahoihin
                muutaRahamaaraa(this.tyomaat.get(i).getPalkkio());
                
                // poista työntekijät työmaalta
                for (int j=0; j<this.tyomaat.get(i).getTyontekijat().size(); j++) {
                    this.tyomaat.get(i).getTyontekijat().get(j).poistaTyomaalta();
                    this.tyomaat.get(i).poistaTyontekija(this.tyomaat.get(i).getTyontekijat().get(j));
                }
                // ja poista itse työmaa
                this.tyomaat.remove(i);
            }
        }
    }
}
