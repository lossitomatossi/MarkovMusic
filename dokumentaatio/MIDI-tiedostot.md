# Tietoa MIDI-tiedostoista

MIDI tiedostot ovat tapa nauhoittaa/toistaa ääntä siten, että jokainen ääni on jaettu omalle kanavalleen. Tämän dokumentin on tarkoitus auttaa ymmärtämään niiden käyttöä asiaan perehtymättömille.

## MIDI tiedoston lataaminen ohjelman käytettäväksi
Sequence sequence = MidiSystem.getSequence(new File(polku));

## Mistä Sequence koostuu
Sequence.getTracks() palauttaa muodossa Track[] taulukon jossa jokainen alkio on Track muuttuja. Yksittäinen Track sisältää kaikki yksittäiset tapahtumat musiikissa. Helppo vertailukohta on pianon koskettimet: Jokainen koskettimen painallus ja nosto, niiden ajankohdat, äänenkorkeudet ja kuinka nopea tapahtuma on kyseessä. 

Tapahtumat koostuvat MidiEvent olioista, ja niiden tapahtumahetken saa event.getTick() metodilla. MidiEvent:in voi muuttaa MidiMessage:ksi event.getMessage() metodilla, jonka voi edelleen muuttaa ShortMessage:ksi helpottamaan tarkastelua.

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
Jokainen Track alkaa viestillä ``Command:192``` ja loppuu ``` Other message: class javax.sound.midi.Track$ImmutableEndOfTrack```
