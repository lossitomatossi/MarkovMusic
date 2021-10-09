# Testaus

### Testikattavuus (ilman kayttoliittymaa ~70%)
![](https://github.com/lossitomatossi/MarkovMusic/blob/main/dokumentaatio/kuvat/Jacoco.PNG "Jacoco testikattavuus")

### Testaustavat

- Käyttöliittymää testattu manuaalisesti ja suurin osa sovelluslogiikasta tavoitteena jättää käyttöliittymän ulkopuolelle
- Käyttöliittymässä voi kokeilla Markovin ketjujen toteutusta komennolla "m" ja "n"
- Junit testit luokille

### Testien toistaminen

```gradlew test jacocoTestReport```
Testikattavuus löytyy sijainnista: MarkovMusic\build\reports\jacoco\test\html\index.html 
### Checkstyle
```gradlew check```
Checkstyle korjausehdotukset löytyvät sijannista:
MarkovMusic\build\reports\checkstyle\main.html

### Graafinen näkymä testauksen tuloksille
