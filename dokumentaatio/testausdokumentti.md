# Testaus

### Testikattavuus (ilman Main 100%)
![](https://github.com/lossitomatossi/MarkovMusic/blob/main/dokumentaatio/kuvat/Jacoco.PNG "Jacoco testikattavuus")

### Testaustavat

- Käyttöliittymää testattu manuaalisesti sekä Junit testeillä
- Junit testit luokille

### Testien toistaminen

```./gradle test jacocoTestReport```
Testikattavuus löytyy sijainnista: MarkovMusic\build\reports\jacoco\test\html\index.html

### Checkstyle
```./gradle check```
Checkstyle korjausehdotukset löytyvät sijannista: MarkovMusic\build\reports\checkstyle\main.html