# Toteutus

## Ohjelman yleisrakenne
Ohjelmaa ottaa syötteeksi yhden tai lukuisia MIDI-tiedostoja (sama tiedosto voi olla useammin kuin kerran jos halutaan muuttaa jotka Markovin ketjun lapsisolmuille määräytyy). Ohjelma käsittelee vain kanavalla 1 olevia nuottitietoja. Käyttäjä saa valita Markovin ketjun asteen (1-7, ohjelmassa "syvyys välillä 2-8) jonka jälkeen MIDI tiedostojen sisältämät nuotit lisätään Triehen. Tämän jälkeen käyttäjältä pyydetään tallennettavan .mid tiedoston nimeä ja tiedostoon tulevien nuottien lukumäärää (kuitenkin maksimissaan saman verran kuin ensimmäiseksi valitussa MIDI tiedostossa raidalla 1 olevien nuottien määrä), jonka jälkeen luodaan uusi MIDI tiedosto syötteistä ensimmäisen MID tiedoston ajoituksilla ja Markovin ketjuista saadulla tiedoilla. Uuden kappaleen ensimmäiset nuotit saadaan käymällä Markovin ketjua eteenpäin valiten satunnaisia alasolmuja (aste - 1 kpl).

Markovin ketjut on toteutettu Trie-tietorakenteella joka koostuu luokista Trie ja TrieSolmu. TrieSolmu sisältää tiedon äänenkorkeudesta ja kestosta, sekä sen alasolmuista. Trie puolestaan sisältää ketjun juuren, johon TrieSolmu ketjuja lisätään.

## Aikavaativuudet
### Tallentaminen O(3n * m)
- Tallentamisen aikavaativuus on O(3n * m), jossa **n** on nuottien määrä kappaleen MIDI raidassa 1, ja **m** tiedostojen lukumäärä. Kunkin kappaleen MIDI-tiedot lisätään ensin listalle, joka annetaan syötteeksi Trie rakenteen talletusmetodille, joka edelleen muodostaa syötteestä Markovin ketjun asteen pituisia ketjuja jotka sitten lisätään Trien juureen.
```
for each (kappale)
  lisaaMiditiedotTriehen(MIDlukija.lueMIDIRaita(kappale, 1)
  
  # lueMIDIRaita metodi tekee listan MIDI tiedoston nuoteista O(n)
  # lisaaMiditiedotTriehen metodi pilkkoo listan Markovin ketjun asteisiksi taulukoiksi ja tallentaa ne Trien juureen.
  Pilkkominen vaatii läpikäymisen jonka aikana taulukkoa täytetään joten sen aikavaativuus on O(n),
  ja koska tallettaminen vaatii kaikkien läpikäytyjen uudelleen läpikäyntiä sekin on O(n).
```
### Uuden musiikin tuottaminen O(n<sup>2</sup> + a)
- Ensimmäiset nuotit saadaan arpomalla Triestä aloitusarvot, jonka jälkeen jokaisella kerralla käydään Markovin ketjun asteen verran solmuja läpi. Myös jos edellisten nuottien ketjua ei löydy Markovin ketjusta, arvotaan uudet aloitusarvot.
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
- Tehdään MIDI tiedosto listan alkiosta ja ajoituksista siten, että tiedostoon kirjoitetaan näistä lyhyemmän verran tapahtumia. For loopin ulkopuolella prepataan tiedosto ja lisätään MIDI alku ja loppu yms tiedot. 
```
for i in range(0, lyhyempi.size()) {
  lista.add(NOTE_ON)
  lista.add(NOTE_OFF)
}
```
