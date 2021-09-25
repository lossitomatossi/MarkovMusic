package MarkovMusic.Tietorakenteet;

import java.util.Objects;

/**
 *
 * @author tompp
 */
public class Bigram {
    String s1;
    String s2;
    Integer i1;
    Integer i2;
    
    /**
     * String muotoisten bigramien alustus, k�ytet��n esim nuottien nimill�
     * @param s1 Bigram parin ensimmainen muuttuja
     * @param s2 Bigram parin toinen muuttuja
     */
    public Bigram(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        this.i1 = -1;
        this.i2 = -1;
    }
    
    /**
     * Numero bigramien alustaja, kaytossa jos halutaan vertailla nuottien korkeutta
     * @param i1
     * @param i2
     */
    public Bigram(Integer i1, Integer i2) {
        this.i1 = i1;
        this.i2 = i2;
        this.s1 = "";
        this.s2 = "";
    }

    /**
     *
     * @return Getteri
     */
    public String getS1() {
        return s1;
    }

    public Integer getI1() {
        return i1;
    }
    /**
     *
     * @return Getteri
     */
    public String getS2() {
        return s2;
    }

    public Integer getI2() {
        return i2;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.s1);
        hash = 37 * hash + Objects.hashCode(this.s2);
        hash = 37 * hash + Objects.hashCode(this.i1);
        hash = 37 * hash + Objects.hashCode(this.i2);
        return hash;
    }

    /**
     *
     * @param obj
     * @Metodi Metodi bigram objektien vertailuun jota tarvitaan parien lukum��r�n laskemiseen
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bigram other = (Bigram) obj;
        if (!Objects.equals(this.s1, other.s1)) {
            return false;
        }
        if (!Objects.equals(this.s2, other.s2)) {
            return false;
        }
        if (!Objects.equals(this.i1, other.i1)) {
            return false;
        }
        if (!Objects.equals(this.i2, other.i2)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (i1 == -1) {
            return "TekstiBigram(" + s1 +"," + s2 +")";
        }
        return "NumeroBigram(" + i1 +"," + i2 +")";
    }
    
    
    
}
