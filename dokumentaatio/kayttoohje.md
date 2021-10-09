# Käyttöohje

## Käynnistäminen
Ohjelman voi käynnistää komentoriviltä komennolla ```gradlew run``` tai Apache Netbeans IDE:llä allaolevasta kohdasta jos Gradle pluginit on asennettu.

![netbeans käynnistys](https://github.com/lossitomatossi/MarkovMusic/blob/main/dokumentaatio/kuvat/netbeans%20run.PNG)

## Käyttäminen
Ohjelma aloittaa tervehtimällä käyttäjää.
```
Tervetuloa MarkovMusic ohjelmaan!
Anna komento (jos haluat nähdä komennot kirjoita komennot):
```
### Ohjelman komennot (isoilla ja pienillä merkeillä ei ole väliä)
| Komento | Toiminto |
| ------------- |------------- |
| aloita | aloittaa Markovin ketjujen muodostamisen |
| komennot | listaa ohjelman tietämät komennot |
| kappaleet | listaa kansiossa /musiikki/kappaleet olevat tiedostot |
| sointutiedostot | listaa kansiossa /musiikki/sointutiedostot olevat tiedostot |
| MIDIT | listaa kansiossa /musiikki/MID olevat tiedostot |
| soita | soittaa käyttäjän valitseman MID tiedoston |
| stop | lopettaa MID tiedoston soittamisen |
| lue | lukee käyttäjän valitsemat tekstitiedostot listalle |
| bigram | muodostaa listalla olevista teksteistä bigrameja (alkuaskel Markovin ketjuja varten) |
| poistu | sulkee ohjelman |

Jos käyttäjän syöte on jotain muuta, käyttäjä saa virheviestin:
```
Komentoa ```kayttajan komento``` ei ole olemassa.
Valitse "komennot" nahdaksesi komennot.
Anna komento (jos haluat nähdä komennot kirjoita komennot):
```

Muissa tapauksissa ohjelma kysyy käyttäjän syötettä ohjeviestien saattamina.
