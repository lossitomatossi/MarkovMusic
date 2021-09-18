package MarkovMusic.Tietorakenteet;

import java.util.Objects;

/**
 *
 * @author tompp
 */
public class Bigram {
    Object o1;
    Object o2;
    
    /**
     * String muotoisten bigramien alustus, k�ytet��n esim nuottien nimill�
     * @param s1 Bigram parin ensimmainen muuttuja
     * @param s2 Bigram parin toinen muuttuja
     */
    public Bigram(String s1, String s2) {
        this.o1 = s1;
        this.o2 = s2;
    }
    
    /**
     * Numero bigramien alustaja, kaytossa jos halutaan vertailla nuottien korkeutta
     * @param i1
     * @param i2
     */
    public Bigram(Integer i1, Integer i2) {
        this.o1 = i1;
        this.o2 = i2;
    }

    /**
     *
     * @return Getteri
     */
    public Object getO1() {
        return o1;
    }

    /**
     *
     * @return Getteri
     */
    public Object getO2() {
        return o2;
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
        if (!Objects.equals(this.o1, other.o1)) {
            return false;
        }
        if (!Objects.equals(this.o2, other.o2)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return Hashcode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.o1);
        hash = 41 * hash + Objects.hashCode(this.o2);
        return hash;
    }
    
    
    
}