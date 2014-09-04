# Aihekuvaus

**Aihe:** Yksinpelattava tietokonepeli, jossa pelaaja johtaa rakennusyritystä. Peli toteutetaan vuoropohjaisena managerointipelinä.

Pelissä pelaaja saa perinnöksi rahaa, jolla pelaaja perustaa rakennusyrityksen. Pelaajan tavoitteena on saada alkupääoma kasvamaan miljoonaan rahayksikköön. Yrityksensä omistajana pelaajan tulee palkata itselleen työvoimaa joka suorittaa pelaajan valitsemia työtehtäviä. Työtehtäviä ilmestyy satunnaisesti pelaajalle valittavaksi.

Pelaaja voi palkata työvoimaksi paikallista työvoimaa tai ulkomaista työvoimaa. Ulkoimainen työvoima on halvempaa, sillä he eivät maksa veroja mutta toisaalta he eivät ole yhtä tehokkaita. Erityistä osaamista vaativia lisenssejä pelaaja voi ostaa itselleen jolloin lisenssit siirtyvät automaattisesti pelaajan työvoiman käyttöön.

Koska pelissä voi kiertää veroja on pelaajan mahdollista palkata muita pelaamista helpottavia hahmoja yritykseensä. Edellisestä johtuen myös verottaja ja rakennusvalvoja kiinnostuvat pelaajasta.

**Käyttäjät:** Pelaaja, Tekoäly

**Pelaajan toiminnot:**

* Aloita uusi peli
* Lataa vanha peli
 * Onnistuu, mikäli pelitalennus löytyy
* Tulosta statistiikka
* Palkkaa työvoimaa
 * Onnistuu jos pelaajan rahat riittävät
* Valitse työtehtävä
* Sijoita työvoimaa työtehtävään
 * Onnistuu, mikäli pelaajalla on työvoimaa
 * Voi vaatia lisenssejä
* Osta lisenssi
* Palkkaa erikoishenkilöjä (Kirjanpitäjä, Työnjohtaja...)
* Tallenna peli

**Tekoälyn toiminnot:**

* Generoi uusi työtehtävä
* Satunnainen verotarkastus
* Satunnainen rakennusvalvoja vierailu
