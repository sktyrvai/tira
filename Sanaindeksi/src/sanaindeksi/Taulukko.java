
package sanaindeksi;

import java.lang.reflect.Array;

/**
 * Dynaaminen taulukko, joka kaksinkertaistaa kokonsa, kun täynnä. Taulukon ensimmäinen paikka on tyhjä ts. indeksointi alkaa yhdestä. Säilyttää olioita.
 * @author sktyrvai
 */

public class Taulukko {
    /**
     * Taulukon alkioiden lukumäärä.
     */
    private int lkm;
    /**
     * Varsinainen taulukko.
     */
    private Object[] taul;

   
    
    public Taulukko(){     
        taul = new Object[5];
    }
    
    public Taulukko(int k){
        taul = new Object[k+1];
    }
     
    /**
     * Lisää uuden alkoin taulukkoon. Jos taulukko on täysi ennen lisäystä, kaksinkertaista taulukon koko.
     * @param uusi taulukkoon lisättävä alkio
     */
    
    public void lisaa(Object uusi){
        if(lkm == taul.length-1){
            kopioi();
        }
        lkm++;
        taul[lkm] = uusi;                
    }
    
    /**
     * Kopioi taulukon kaksikertaa isompaan taulukkoon
     */
    private void kopioi(){
       Object[] uusi = new Object[2*taul.length];
        for(int i = 0; i< taul.length; i++){
            uusi[i] = taul[i];
        }
        taul = uusi;
    }
    
    /**
     * Tarkistaa onko taulukko tyhjä.
     * @return true, jos taulukko on tyhjä
     */
    
    public boolean isEmpty(){
        if(lkm == 0){
            return true;
        }
        return false;
    }
    /**
     * Palauttaa pyydetyn alkion. HUOM! Taulukon ensimmäinen paikka on tyhjä. 
     * @param int i
     * @return Object sanat[i]. i. alkio 
     */
    
    public Object get(int i){
        return this.taul[i];
    }
    
    /**
     * Palauttaa Taulukossa olevien alkioiden määrän.
     * @return lkm
     */
    public int getKoko(){
        return this.lkm;
    }
    
    /**
     * Palauttaa taulukon.
     * @return Object[] 
     */
    public Object[] getTaulukko(){
        return this.taul;
        //lyhennetäänkö?
    }
    
    
}
