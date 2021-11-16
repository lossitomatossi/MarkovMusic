# Toteutus

## Ohjelman yleisrakenne
Ohjelma ottaa syötteeksi yhden tai lukuisia MIDI-tiedostoja (sama tiedosto voi olla useammin kuin kerran jos halutaan muuttaa painoja, jotka Markovin ketjun lapsisolmuille määräytyy). Ohjelma käsittelee vain Track:issä 1 olevia nuottitietoja. Käyttäjä saa valita Markovin ketjun asteen (1-7, ohjelmassa "syvyys" välillä 2-8) jonka jälkeen MIDI-tiedostojen sisältämät nuotit lisätään Triehen. Tämän jälkeen käyttäjältä pyydetään tallennettavan .mid tiedoston nimeä ja tiedostoon tulevien nuottien lukumäärää (kuitenkin maksimissaan saman verran kuin ensimmäiseksi valitussa MIDI-tiedostossa raidalla 1 olevien nuottien määrä), jonka jälkeen luodaan uusi MIDI-tiedosto syötteistä ensimmäisen MIDI-tiedoston ajoituksilla ja Markovin ketjuista saadulla tiedoilla. Uuden kappaleen ensimmäiset nuotit saadaan käymällä Markovin ketjua eteenpäin valiten satunnaisia alasolmuja (aste - 1 kpl).

Markovin ketjut on toteutettu Trie-tietorakenteella joka koostuu luokista Trie ja TrieSolmu. TrieSolmu sisältää tiedon äänenkorkeudesta ja kestosta, sekä sen alasolmuista. Trie puolestaan sisältää ketjun juuren, johon TrieSolmu ketjuja lisätään.

## Aikavaativuudet
### Tallentaminen O(3n * m)
- Tallentamisen aikavaativuus on O(3n * m), jossa **n** on nuottien määrä kappaleen MIDI raidassa 1, ja **m** tiedostojen lukumäärä. Kunkin kappaleen MIDI-tiedot lisätään ensin listalle, joka annetaan syötteeksi Trie rakenteen talletusmetodille, joka edelleen muodostaa syötteestä Markovin ketjun asteen pituisia ketjuja jotka sitten lisätään Trien juureen. Jos viimeinen pätkä olisi lyhyempi kuin Markovin ketjun aste, ei sitä lisätä Triehen.
```
for each (kappale)
  lisaaMiditiedotTriehen(MIDlukija.lueMIDIRaita(kappale, 1)
  
  # lueMIDIRaita metodi tekee listan MIDI-tiedoston nuoteista O(n)
  # lisaaMiditiedotTriehen metodi pilkkoo listan Markovin ketjun asteisiksi taulukoiksi ja tallentaa ne Trien juureen.
  Pilkkominen vaatii läpikäymisen jonka aikana taulukkoa täytetään joten sen aikavaativuus on O(n),
  ja koska tallettaminen vaatii kaikkien läpikäytyjen uudelleen läpikäyntiä sekin on O(n).
```
### Uuden musiikin tuottaminen O(n<sup>3</sup> + a)
- Ensimmäiset nuotit saadaan arpomalla Triestä aloitusarvot, jonka jälkeen jokaisella kerralla käydään Markovin ketjun asteen verran solmuja läpi. Jos edellisten nuottien ketjua ei löydy Markovin ketjusta, arvotaan uudet aloitusarvot.
```
lista edelliset_nuotit = arvoAloitusArvot(); #O(a), a = aste-1 alkiota. 
                                             #Normaalisti O(n), mutta selkeyden vuoksi vaihdetaan kirjain a:ksi.
lista talletetut;

for i in range 0, montako_luodaan O(n) {
  if (etsiJonoa(edelliset_nuotit) { O(n)
      viimeisin_tallennettu = seuraava(edelliset_nuotit) O(n)
      talletetut.add(viimeisin_tallennettu) O(n)
      muutaTaulukko(edelliset, viimeisin_tallennettu) O(n)
  } else {
    edelliset_nuotit = arvoAloitusarvot(); O(a)
    talletetut.add(edelliset_nuotit) O(n)
  }
}
```

Aikavaativuus O(n<sup>2</sup>) saadaan seuraavista sisäkkäisistä for loopeista
```
for i in range 0, montako_luodaan O(n) 
  if (etsiJonoa(edelliset_nuotit) { O(n)
```

### Tuotetun musiikin tallentaminen O(n)
- Tehdään MIDI tiedosto listan alkiosta ja listasta ajoituksista siten, että tiedostoon kirjoitetaan näistä lyhyemmän verran tapahtumia. For loopin ulkopuolella prepataan tiedosto ja lisätään MIDI:n alku-, loppu- ja muut tiedot. 
```
for i in range(0, lyhyempi.size()) {
  lista.add(NOTE_ON)
  lista.add(NOTE_OFF)
}
```

## Puutteet ja parannusehdotukset
### Puutteet
- Ohjelma ei tarkista löytyykö MIDI tiedostosta Track 1.
- Vaikka ajoitukset ovat oikein, BPM (beats-per-minute) ei ole, jonka takia luotu musiikki on huomattavasti hitaampaa kuin alkuperäiskappaleessa.
- Jostain syystä ohjelmaa ajettaessa tulee turhaan tuloste "Komentoa **komento** ei ole olemassa". 
"Valitse **komennot** nahdaksesi komennot."
- Käyttöliittymän komento **komennot** ei listaa oikeita komentoja.

### Parannusehdotukset
- Käyttöliittymään komennon 3 toteuttaminen jotta käyttäjä voi valita minkä perusteella ajoitukset valitaan.
- Mahdollisuus tehdä ajoituksista Markovin ketjuja.
- Käyttöliittymässä voi soittaa tällä hetkellä vain kappaleen bach-inventions, metodin voisi generalisoida ja antaa käyttäjälle listauksen joista valita tiedosto jonka haluaa soittaa.
- Tiedostojen tallennus projektin juuren sijaan musiikki/MIDI kansioon.

# Tietoa MIDI-tiedostoista

MIDI-tiedostot ovat tapa nauhoittaa/toistaa ääntä siten, että jokainen ääni on jaettu omalle kanavalleen. Tämän dokumentin on tarkoitus auttaa ymmärtämään niiden käyttöä asiaan perehtymättömille.

## MIDI tiedoston lataaminen ohjelman käytettäväksi
Sequence sequence = MidiSystem.getSequence(new File(polku));

## Mistä Sequence koostuu
Sequence.getTracks() palauttaa muodossa Track[] taulukon jossa jokainen alkio on Track muuttuja. Yksittäinen Track sisältää kaikki yksittäiset tapahtumat musiikissa. Helppo vertailukohta on pianon koskettimet: Jokainen koskettimen painallus ja nosto, niiden ajankohdat, äänenkorkeudet ja kuinka nopea tapahtuma on kyseessä. 

Tapahtumat koostuvat MidiEvent olioista, ja niiden tapahtumahetken saa event.getTick() metodilla. MidiEvent:in voi muuttaa MidiMessage:ksi event.getMessage() metodilla, jonka voi edelleen muuttaa ShortMessage:ksi helpottamaan tarkastelua. Message sisältää Byte muodossa tiedon sävelkorkeudesta, sekä nopeudesta. [Lähde](https://pages.uoregon.edu/emi/37.php) Tämän vuoksi sävelkorkeus voidaan tallettaa 128 kokoiseen taulukkoon.

Allaoleva koodinpätkä auttaa selvittämään lisätietoa MIDI olioista. [Stackoverflow](https://stackoverflow.com/questions/3850688/reading-midi-files-in-java) (käännetty ja lyhennetty jotta dokumentaatio pysyy suomenkielisenä ja selkeänä)


```
Nuottien tekstinimet voi asettaa taulukkoon nuottien_nimet,
koska sävelten tarkastelu paljain silmin ei kerro musiikista suuremmin.
{"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"} # C on oktaavin alin ja H/B ylin nuotti

int sävel = sm.getData1();
int oktaavi = (sävel / 12) - 1;
int nuotti = sävel % 12;
String nuottiTekstinä = nuottien_nimet[nuotti];
int nopeus = sm.getData2();

if (sm.getCommand() == NOTE_ON)  ## kertoo alkaako vai loppuuko nuotti
```
B ja H ovat samat, ja esim Em ja D#
ovat sama äänenkorkeus, "#" tarkoittaa että siirrytään korkeampaan ääneen ja "m" tarkoittaa mollia,
eli siirtymistä matalampaan ääneen. Asialla väliä vain musiikkiteorian kannalta, muuten siirtyminen on vain 1 ylös tai 1 alas.

## Muuta tietoa
Jokainen Track alkaa viestillä ```Command:192``` ja loppuu ``` Other message: class javax.sound.midi.Track$ImmutableEndOfTrack```

## Melodian löytäminen
Melodian löytäminen ohjelman sisällä on huomattavasti vaikeampaa kuin mitä tämän projektin alle kuuluisi. Tutkimuksessa [Melodic track identification in midi files](https://www.researchgate.net/publication/228938711_Melodic_track_identification_in_midi_files) huomattiin että jokaiselle tyylilajille tarvittaisiin lukuisia kappaleita, jotta voitaisiin MIDI-tiedoston perusteella tunnistaa mikä Track sisältää melodian. Tutkimuksessa myös mainittiin se, ettei sinfonia kappaleissa ole vain tiettyä melodiaa, joten tämän projektin tarpeisiin melodia etsitään MIDI-tiedostoja manuaalisesti tutkien.

## Lähteet
- Trie https://en.wikipedia.org/wiki/Trie
- Markovin ketju https://en.wikipedia.org/wiki/Markov_chain ja https://fi.wikipedia.org/wiki/Markovin_ketju
- Aikavaativuudet https://www.ohjelmointiputka.net/oppaat/opas.php?tunnus=alg_2
- Electronic Music Interactive Edition 2
https://pages.uoregon.edu/emi/37.php
- https://www.researchgate.net/publication/228938711_Melodic_track_identification_in_midi_files
Rizo, David & León, Pedro & Pertusa, Antonio & Iñesta, Jose. (2006). Melodic track identification in midi files.
- [Reading MIDI files in java](https://stackoverflow.com/questions/3850688/reading-midi-files-in-java)
- MIDI tiedostojen yksityiskohdat [Official specifications](https://www.midi.org/specifications/category/gm-specifications)
### Musiikin lähteet
- https://tabs.ultimate-guitar.com/tab/oasis/wonderwall-chords-27596
- https://www.kunstderfuge.com/bach/harpsi.htm#Inventions
