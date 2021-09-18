# Viikkoraportti 2

## Mitä olen tehnyt

### Tuntikirjanpito
| Aihe          | Ajankäyttö    | Päivä |
| ------------- |-------------  |-------|
| Ohjelmointia ja junit testejä | 4 h  | pe-la yö |
| Gradle pluginit mm checkstyle | 1 h | la |
| Checkstyle virheiden korjaus ja jacoco testikattavuuden parannus | 1 h | la |
| Markovin ketjuihin paremmin perehtyminen | 0.5 h | la |
| Koodia, projektin mmäärittelya ja testejä | 7 h | la |

## Edistyminen
- Käyttöliittymästä puuttuu paljon metodeita ja selityksiä, mutta sillä saa jo luettua tiedostoja (tällä hetkellä pakotettu vain yhteen tiedostoon).
- Luetusta tekstitiedosta saa tekstimuodossa nuotit, jokaisen peräkkäisen nuottiparin ja niiden lukumäärät.
- Tekstimuotoisten nuottiparien muodostus tukee useamman tiedoston samanaikaista käsittelyä jotta Markovin ketjuista saadaan monipuolisempia. Huono puoli tekstinuoteissa on se että ne antavat sointukierron mutta ajoitusdataa ei ole.

## Mitä opin
- Gradlen conffausta, lisää Markovin ketjuista, sen kuinka monimutkaiseksi Markovin ketjut musiikissa helposti menevät.

## Vaikeuksia
- Checkstylen määrittäminen siten ettei se huomio käyttöliittymää (onnistui), sama Jacocolla ei onnistunut
- Muistaa tehdä Javadoc suomeksi kun luo Netbeansillä automaattisesti testit metodeille.

## Seuraavaksi
- Nuottiparien todennäköisyydet Markovin ketjuja varten.
- Käyttöliittymä kutsumaan metodeja jottei koodi ole niin pitkää ja tällä viikolla kovakoodattujen metodien yleistäminen.
- Markovin ketju luokan koodaaminen
- Tutkiminen MIDI tiedostojen soittamiseen javalla.
