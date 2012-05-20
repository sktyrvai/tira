/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanaindeksi;
import java.util.ArrayList;

/**
 *
 * @author Sanna
 * 
 */
public class Solmu {
    private char merkki;
    private ArrayList<Solmu> Lapset;
    boolean sananLoppu;
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

    /* Lapsisolmu tutkii löytyykö annettu char solmun lapsista
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
