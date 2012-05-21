
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
    private boolean sananLoppu = false;
    private ArrayList<Integer> Rivit;
    // ArrayList ei liene tehokkain ratkaisu tähän, mut riittänee alkuun
    
    public Solmu(char merkki){
        this.merkki = merkki;
        Lapset = new ArrayList<Solmu>();  
        Rivit = new ArrayList<Integer>();
    }
    
    public void setMerkki(char merkki){
        this.merkki = merkki;        
    }
    
    public char getMerkki(){
        return this.merkki;
    }
    
    public void setSananLoppu(boolean arvo){
        this.sananLoppu = arvo;
    }
    
 
    public void uusiLapsi(Solmu s){
        Lapset.add(s);
    }
    
    public void addRivi(int i){
        Rivit.add((Integer) i);
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
        String apu = "";
        if(Rivit != null){
            for(Integer rivi: Rivit){
                apu = apu + " " +rivi;
            }
        }
        return this.getMerkki()+" "+ apu;
    }
            
   
    
}
