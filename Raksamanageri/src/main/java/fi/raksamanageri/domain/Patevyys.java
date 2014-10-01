package fi.raksamanageri.domain;

/**
 * Luokka sisältää tekstimuotoisen pätevyyden. Pätevyydet nostavat työntekijän
 * palkkaa ja mahdollistavat työnteon työmailla jotka vaativat erityisen pätevyyden
 * ilman, että rakennustarkastaja suuttuu
 * @author eikkari
 */
public class Patevyys implements java.io.Serializable {
    private String nimi;
    
    /**
     * Konstruktori, jossa nimetään pätevyys. Tyypillisiä pätevyyksiä ovat esim. 
     * "sähkötyöt", "putkityöt" ja "julkisivut"
     * 
     * @param nimi pätevyydelle annettu nimi
     */
    public Patevyys(String nimi) {
        this.nimi = nimi;
    }
    
    public String getNimi() {
        return this.nimi;
    }
}
