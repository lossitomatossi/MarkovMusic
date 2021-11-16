# Testaus

### Testikattavuus (ilman Main 99%)

![](https://github.com/lossitomatossi/MarkovMusic/blob/main/dokumentaatio/kuvat/Jacoco.PNG "Jacoco testikattavuus")


Automaattiset testit voidaan toistaa projektin juuressa komennolla ```./gradlew test jacocoTestReport```

Testikattavuus löytyy sijainnista: MarkovMusic\build\reports\jacoco\test\html\index.html

- jotain ihmeellistä tapahtui MIDkirjoitin.java luokalle ja sen Junit testaaminen crashaa Javan, joten luokan omat testit jätetty tekemättä. Ohjelman toiminta kuitenkin tarkistettu, ja projektin juureen on tallennettu MIDI-tiedostoja jotka aukeavat/soivat kuten normaalit .mid tiedostot.

### Checkstyle
```./gradlew check```
Checkstyle korjausehdotukset löytyvät sijannista: MarkovMusic\build\reports\checkstyle\main.html

## Testaustavat
### Yleisesti
Ohjelmaa toteuttaessa kaikkien metodien kohdalla on yritetty eriyttää suurin osa toiminnallisuuksista omiksi toiminnoikseen, jotta Junit testit osuisivat mahdollisimman moneen toiminnallisuuteen. Tämä tarkoittaa myös sitä että rivikattavuus on järkevä metriikka testien oikeellisuuden tarkistamiseen.

### Käyttöliittymä
Käyttöliittymä on luokka jolle annetaan Scanner olio, joten test/Kayttoliittyma testaa käyttäjän toiminnallisuuksia, jotta manuaalinen tarkastelu ei ole tarpeen. Manuaalinen tarkastelu on kuitenkin toteutettu kehitysvaiheessa manuaalisilla komennoilla jotka on loppupalautuksesta poistettu. Käyttöliittymän metodeille on toteutettu tarkistukset ettei käyttäjä voi valita tiedostoja joita ei ole olemassa, ja jos tiedostoja ei ole valittu käyttäjä saa virheilmoituksen.

### Suorituskyky
Suorituskyky testejä ei ole toteutettu, sen sijaan ohjelman toimiminen toivotulla tavalla on todistettu projektin juureen talletetuilla 
1.-, 2.-, 3.- ja 6. asteen ketju.mid tiedostoilla joita kuuntelemalla huomaa että Markovin ketjun asteen noustessa kappaleet alkavat kuulostaa enemmän oikealta musiikilta kuin satunnaisilta koskettimien kosketuksilta.
