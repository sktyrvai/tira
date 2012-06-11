
package sanaindeksi;
import java.util.ArrayList;

/**
 * Solmu, joka säilyttää merkkiä ja siihen päättyvän sanan rivitietoja. Säilyttää lapsiaan Taulukossa. 
 * @author Sanna Tyrväinen
 * @version
 */
  
public class Solmu {

    private char merkki;
    private Taulukko Lapset;
    private boolean sananLoppu = false;  
    private Taulukko[] rivitiedot;
    private static int tiedlkm;
     
    
    public static void setTiedLkm(int uusiLuku){
        tiedlkm=uusiLuku;
    }
  
    public Solmu(char merkki){
        //if(tiedlkm < 0)
          //  throw new RuntimeException("Et ole asettanut tiedostojen määrää");
        this.merkki = merkki;
        Lapset = new Taulukko();
        this.rivitiedot = new Taulukko[tiedlkm];
       for(int i = 0; i<rivitiedot.length; i++){
           this.rivitiedot[i] = new Taulukko();
        }
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
    /**
     * Lisää solmulle uuden riviesiintymisen
     * @param i mones rivi
     * @param tied Monennesta tiedostosta rivi on.   
     */
    
    public void addRivi(int i, int tied){        
        this.rivitiedot[tied].lisaa((Integer) i);
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
    
    public Taulukko[] getRivit(){
        return this.rivitiedot;
    }
    
    public boolean getSananLoppu(){
        return this.sananLoppu;   
    }
           
    private String tulostuksenApu(){
        String apu = "Rivitiedosto: ";
        for(int i = 0; i<rivitiedot.length; i++){
            apu = apu + i+":  ";
            for(int k = 1; k <= rivitiedot[i].getKoko(); k++){
                apu = apu + " "+rivitiedot[i].get(k);
            }
            apu = apu + " ";
        }

        return apu;
    }
    /**
     * 
     * @return Solmussa olevan merkin ja sen rivitiedot tiedostottain 
     */
    
    public String toString(){        
        return this.getMerkki()+" "+ this.tulostuksenApu();
    }
            
   
    
}
