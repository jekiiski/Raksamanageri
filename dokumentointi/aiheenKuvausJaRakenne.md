# Aihekuvaus

**Aihe:** Yksinpelattava tietokonepeli, jossa pelaaja johtaa rakennusyritystä. Peli toteutetaan vuoropohjaisena managerointipelinä.

Pelissä pelaaja saa perinnöksi rahaa, jolla pelaaja perustaa rakennusyrityksen. Pelaajan tavoitteena on saada alkupääoma kasvamaan miljoonaan rahayksikköön. Yrityksensä omistajana pelaajan tulee palkata itselleen työvoimaa joka työskentelee pelaajan valitsemilla työmailla. Työtehtäviä ilmestyy satunnaisesti pelaajalle valittavaksi.

Pelaaja voi palkata työvoimaksi paikallista työvoimaa tai ulkomaista työvoimaa. Ulkomainen työvoima on halvempaa, sillä he eivät maksa veroja. Kuitenkin he ovat tehokkaampia mutta tekevät huonompaa työjälkeä.

Koska pelissä voi kiertää veroja, voi verotarkastaja mätkäistä pelaajalle lisäveron ulkomaisen työvoiman käytöstä. Samaten rakennustarkastaja voi määrätä osan työmaasta uudelleentehtäväksi ulkomaisesta työvoimasta johtuen.

**Käyttäjät:** Pelaaja, Peli

**Pelaajan toiminnot:**

* Aloita uusi peli
* Lataa vanha peli
 * Onnistuu, mikäli pelitalennus löytyy
* Palkkaa työvoimaa
 * Onnistuu jos pelaajan rahat riittävät
* Valitse tyomaa
* Sijoita työvoimaa työmaalle
 * Onnistuu, mikäli pelaajalla on työvoimaa
 * Onnistuu, mikäli pelaajalla on valittuna työmaa
* Hallitse tyovoimaa
 * Sijoita työntekijä työmaalle
* Hallitse työmaita
 * Työmaan voi jättää kesken sakkoa vastaan
* Tallenna peli

**Pelin toiminnot:**

* Generoi uusi työtehtävä
* Generoi uusi työntekijä
* Satunnainen verotarkastus
* Satunnainen rakennustarkastajan käynti

