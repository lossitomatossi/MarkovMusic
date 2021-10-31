# Testaus

### Testikattavuus (ilman Main 99%)
- jotain ihmeellistä tapahtui MIDkirjoitin.java luokalle ja sen Junit testaaminen crashaa Javan, joten luokan omat testit jätetty tekemättä. Ohjelmaa toimii kuitenkin.
![](https://github.com/lossitomatossi/MarkovMusic/blob/main/dokumentaatio/kuvat/Jacoco.PNG "Jacoco testikattavuus")

### Testaustavat

- Käyttöliittymää testattu manuaalisesti sekä Junit testeillä
- Junit testit luokille

### Testien toistaminen

```./gradlew test jacocoTestReport```
Testikattavuus löytyy sijainnista: MarkovMusic\build\reports\jacoco\test\html\index.html

### Checkstyle
```./gradlew check```
Checkstyle korjausehdotukset löytyvät sijannista: MarkovMusic\build\reports\checkstyle\main.html