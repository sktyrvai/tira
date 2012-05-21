
package sanaindeksi;
import java.util.ArrayList;

/**
 *
 * @author Sanna Tyrväinen
 * @version 18052012
 */
public class Solmu {
    private char merkki;
    private ArrayList<Solmu> Lapset;
    boolean sananLoppu = false;
    // ArrayList ei liene tehokkain ratkaisu tähän, mut riittänee alkuun
    
    public Solmu(char merkki){
        this.merkki = merkki;
        Lapset = new ArrayList<Solmu>();       
    }
    
    public void setMerkki(char merkki){
        this.merkki = merkki;        
    }
    
    public char getMerkki(){
        return this.merkki;
    }
    
 
    public void uusiLapsi(Solmu s){
        Lapset.add(s);
    }

    /** 
     * Lapsisolmu tutkii löytyykö annettu char solmun lapsista
     * @param c tutkitaaan löytyykö lapsisolmu, jossa character c
     * @return Solmu, jossa character on tai null, jos sellaista ei löydy
     * 
     */
    public Solmu lapsisolmu(char c){
        if(! Lapset.isEmpty()){       
            for(Solmu lapsi: Lapset){
                if(lapsi.getMerkki() == c){
                    return lapsi;
                }
            }
        }
        return null;
    }
    
    public ArrayList<Solmu> getLapset(){
        return Lapset;
    }
    
    public String toString(){
        return ""+ this.getMerkki();
    }
            
   
    
}
