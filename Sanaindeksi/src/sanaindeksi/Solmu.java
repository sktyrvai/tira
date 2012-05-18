/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanaindeksi;
import java.util.ArrayList;

/**
 *
 * @author Sanna
 */
public class Solmu {
    private char merkki;
    private ArrayList<Solmu> Lapset;
    // ArrayList ei liene tehokkain ratkaisu tähän, mut riittänee alkuun
    
    public Solmu(char merkki){
        this.merkki = merkki;
        Lapset = new ArrayList<Solmu>();       
    }
    
    public void setSolmu(char merkki){
        this.merkki = merkki;        
    }
    
    public char getSolmu(){
        return this.merkki;
    }
    
    public void uusiLapsi(Solmu s){
        Lapset.add(s);
    }
    
    public ArrayList<Solmu> getLapset(){
        return Lapset;
    }
    
    public String toString(){
        return " " + this.getSolmu();
    }
            
   
    
}
