# Tietoa MIDI-tiedostoista

MIDI tiedostot ovat tapa nauhoittaa/toistaa ääntä siten, että jokainen ääni on jaettu omalle kanavalleen. Tämän dokumentin on tarkoitus auttaa ymmärtämään niiden käyttöä asiaan perehtymättömille.

## MIDI tiedoston lataaminen ohjelman käytettäväksi
Sequence sequence = MidiSystem.getSequence(new File(polku));

## Mistä Sequence koostuu
Sequence.getTracks() palauttaa muodossa Track[] taulukon jossa jokainen alkio on Track muuttuja. Yksittäinen Track sisältää kaikki yksittäiset tapahtumat musiikissa. Helppo vertailukohta on pianon koskettimet: Jokainen koskettimen painallus ja nosto, niiden ajankohdat, äänenkorkeudet ja kuinka nopea tapahtuma on kyseessä. 

Tapahtumat koostuvat MidiEvent olioista, ja niiden tapahtumahetken saa event.getTick() metodilla. MidiEvent:in voi muuttaa MidiMessage:ksi event.getMessage() metodilla, jonka voi edelleen muuttaa ShortMessage:ksi helpottamaan tarkastelua. Message sisältää Byte muodossa tiedon sävelkorkeudesta, sekä nopeudesta. [1](https://pages.uoregon.edu/emi/37.php) Tämän vuoksi sävelkorkeus voidaan tallettaa 128 kokoiseen taulukkoon.

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
Melodian löytäminen ohjelman sisällä on huomattavasti vaikeampaa kuin mitä tämän projektin alle kuuluisi. Tutkimuksessa [Melodic track identification in midi files (2)](https://www.researchgate.net/publication/228938711_Melodic_track_identification_in_midi_files) huomattiin että jokaiselle tyylilajille tarvittaisiin lukuisia kappaleita jotta voitaisiin MIDI tiedoston perusteella tunnistaa mikä Track sisältää melodian. Tutkimuksessa myös mainittiin se, ettei sinfonia kappaleissa ole vain tiettyä melodiaa, joten tämän projektin tarpeisiin melodia etsitään MIDI-tiedostoja manuaalisesti tutkien.

## Lähteet
- (1) Electronic Music Interactive Edition 2
https://pages.uoregon.edu/emi/37.php
- (2) https://www.researchgate.net/publication/228938711_Melodic_track_identification_in_midi_files
Rizo, David & León, Pedro & Pertusa, Antonio & Iñesta, Jose. (2006). Melodic track identification in midi files. The objective of this work is to find the melodic line in MIDI files. Usually, the melodic line is stored in a single track, while the other tracks contain the accom-paniment. The detection of the track that contains the melodic line can be very useful for a number of ap-plications, such as melody matching when searching in MIDI databases. The system was developed using WEKA. First, a set of descriptors from each track of the target melody is extracted. These descriptors are the input to a random forest classifier that assigns a proba-bility of being a melodic line to each track. The tracks with a probability under a given threhold are filtered out, and the one with the highest probability is selected as the melodic line of that melody. Promising results were obtained testing different MIDI databases.
