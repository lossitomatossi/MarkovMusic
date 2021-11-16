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

Version 1.0 mukainen komentojärjestys uuden musiikin luomiselle on 1, 2, 4 (kuitenkin huomioiden ohjelman pyytämät valinnat kunkin komennon aikana). Muiden komentojen järjestyksellä ei ole väliä.

### Ohjelman komennot (isoilla ja pienillä merkeillä ei ole väliä)
| Komento | Toiminto |
| ------------- |------------- |
| 1 | pyytää käyttäjää valitsemaan tiedostot joiden perusteella Markovin ketjut luodaan |
| 2 | pyytää käyttäjältä Markovin ketjun syvyyden, eli asteen ja muodostaa Trie rakenteen |
| 3 | **ei toteutettu** tilaisuus kysyä käyttäjältä minkä perusteella tallennettavan kappaleen ajoitukset valitaan |
| 4 | pyytää käyttäjältä tallennettavan tiedoston nimen ja nuottien lukumäärän, jonka jälkeen muodostaa uutta musiikkia Markovin ketjujen perusteella ja tallettaa MIDI-tiedoston projektin juureen |
| komennot | listaa ohjelman tietämät komennot |
| soita | soittaa bach-inventions.mid tiedoston |
| stop | lopettaa MID tiedoston soittamisen |
| poistu | sulkee ohjelman |

Jos käyttäjän syöte on jotain muuta, käyttäjä saa virheviestin:
```
Komentoa ```kayttajan komento``` ei ole olemassa.
Valitse "komennot" nahdaksesi komennot.
Anna komento (jos haluat nähdä komennot kirjoita komennot):
```

Muissa tapauksissa ohjelma kysyy käyttäjän syötettä ohjeviestien saattamina. Versiossa 1.0 jostain syystä ylläoleva virheviesti tulee onnistuneidenkin komentojen jälkeen, tästä ei kuitenkaan tarvitse välittää.

## Uusien MIDI tiedostojen lisääminen ohjelmalle
Ohjelma odottaa kaikkien MIDI-tiedostojen löytyvän sijainnista /musiikki/MID. Kappaleista jotka tänne lisätään pitäisi varmistaa että niistä löytyy Track 1, koska ohjelma olettaa melodian löytyvän siltä MIDI-raidalta.

## Tallennettujen MIDI-tiedostojen kuuntelu
Ohjelma tallentaa luodut MIDI-tiedostot projektin juureen joten niitä ei voi kuunnella vielä ohjelmalla. Jos/kun käyttöliittymän metodi soita generalisoidaan, voidaan kappaleet kuunnella jos ne sijaitsevat kansiossa /musiikki/MID. Kuitenkin versiossa 1.0 kappaleiden kuuntelu pitää tehdä jollain ulkoisella ohjelmalla kuten Windows Media Player tai vastaava.