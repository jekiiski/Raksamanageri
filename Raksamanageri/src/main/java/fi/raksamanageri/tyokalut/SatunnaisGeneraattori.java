package fi.raksamanageri.tyokalut;

import fi.raksamanageri.domain.Tyomaa;
import fi.raksamanageri.domain.Tyontekija;
import java.util.Random;

/**
 * Satunnaisgeneraattori arpoo uusia työmaita, työntekijöitä sekä
 * rakennustarkastajan ja verotarkastajan vierailut
 * 
 */

public class SatunnaisGeneraattori implements java.io.Serializable {
    private Random random;
    private int tyomaaLaskuri;
    private int tyontekijaLaskuri;
    
    /**
     * Alustaa satunnaisgeneraattorin sekä sen sisäiset muuttujat
     */
    public SatunnaisGeneraattori() {
        this.random = new Random();
        this.tyomaaLaskuri = 1;
        this.tyontekijaLaskuri = 1;
    }
    
    /**
     * Luo uuden työmaan, laajuus arvotaan ja se kasvaa pelin edetessä
     * 
     * @return Luotu työmaa 
     */
    public Tyomaa generoiUusiTyomaa() {
        int laajuus = 40 + + this.tyomaaLaskuri + this.random.nextInt(20);
        String nimi = "TM" + this.tyomaaLaskuri;
        this.tyomaaLaskuri++;
        Tyomaa t = new Tyomaa(laajuus, nimi);
        return t;
    }
    
    /**
     * Arpoo uuden työntekijän
     * 
     * @return Arvottu työntekijä 
     */
    public Tyontekija generoiUusiTyontekija() {
        String nimi = "TT" + this.tyontekijaLaskuri;
        this.tyontekijaLaskuri++;
        Tyontekija t;
        if (this.random.nextInt(2) > 0) {
            t = new Tyontekija(true, nimi);
        } else {
            t = new Tyontekija(false, nimi); 
        }
        return t;
    }
    
    /**
     * Arpoo argumenttina annetun työmaan tietojen perusteella työmaalta
     * saatavan sopivan palkkion
     * 
     * @param t Työmaa jonka pohjalta palkkio arvotaan
     * 
     * @return Arvottu palkkio
     */
    public int generoiTyomaaPalkkio(Tyomaa t) {
        return (t.getLaajuus() + (-3 + this.random.nextInt(14))) * 60;
    }
    
    /**
     * Arpoo tulisiko rakennustarkastajan tulla käymään. 
     * Todennäköisyys 3,33%
     * 
     * @return Tuleeko rakennustarkastaja käymään 
     */
    public boolean rakennustarkastajaKylaan() {
        if (this.random.nextInt(30) == 0) {
            return true;
        }
        return false;
    }
    
    /**
     * Arpoo tulisiko verottajan tehdä tarkastus. 
     * Todennäköisyys 10%
     * 
     * @return Tekeekö verottaja tarkastuksen
     */
    public boolean verottajanTarkastus() {
        if (this.random.nextInt(10) == 0) {
            return true;
        }
        return false;
    }
    
}
