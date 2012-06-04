
package sanaindeksi;
import java.util.ArrayList;

/**
 *
 * @author Sanna Tyrväinen
 * @version
 */
  
public class Solmu {

    private char merkki;
    private Taulukko Lapset;
    private boolean sananLoppu = false;
    /**
     * Rivit sisältää tiedot riveistä, joissa sana sijaitsee
     */
    ArrayList<Integer> Rivit;
    
    
    public Solmu(char merkki){
        this.merkki = merkki;
        Lapset = new Taulukko();  
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
    
  /**
   * Lisää Solmulle uuden lapsen, jos vastaavaa ei vielä ole.
   * @param s Lisättävä solmu. 
   */
    public void uusiLapsi(Solmu s){
        if(this.lapsisolmu(s.getMerkki())== null){
            Lapset.lisaa(s);
        }
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
            for(int i=1; i<= Lapset.getKoko();i++){
                Solmu s = (Solmu) Lapset.get(i);
                if(s.getMerkki() == c){
                    return s;
                }
            }
        }
        return null;
    }
    
    /*public Solmu[] getLapset(){
     * Solmu[] s = new Solmu[Lapset.getKoko];
     * for(int i = 1; i++; i< s.size()){
     *  s = Lapset.get[i]
     * } 
     * return s;
        return Lapset.getTaulukko();
    }
    * 
    */
    
    /**
     * Palauttaa taulukon, jossa vain solmun lapset 
     * @return taulukon s. s.size == Lapset.getKoko  
     */
    public Solmu[] getLapset(){
        Solmu[] s = new Solmu[Lapset.getKoko()];
        for( int i = 0; i< s.length; i++){
            s[i] = (Solmu) Lapset.get(i+1);
        }
        return s;
    }
    
    public ArrayList<Integer> getRivit(){
        return this.Rivit;
    }
    
    public boolean getSananLoppu(){
        return this.sananLoppu;   
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
