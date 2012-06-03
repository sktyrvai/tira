
package sanaindeksi;

import java.lang.reflect.Array;

/**
 *
 * @author sktyrvai
 */
public class Taulukko {
    private int lkm;
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
    
    /*
     * kopioi taulukon kaksikertaa isompaan taulukkoon
     */
    private void kopioi(){
       Object[] uusi = new Object[2*taul.length];
        for(int i = 0; i< taul.length; i++){
            uusi[i] = taul[i];
        }
        taul = uusi;
    }
    
    public boolean isEmpty(){
        if(lkm == 0){
            return true;
        }
        return false;
    }
    /**
     * Palauttaa pyydetyn alkion. HUOM! Taulukon ensimmäinen paikka on tyhjä. 
     * @param int i
     * @return String sanat[i]. i. alkio 
     */
    
    public Object get(int i){
        return this.taul[i];
    }
    
    public int getKoko(){
        return this.lkm;
    }
    
    public Object[] getTaulukko(){
        return this.taul;
        //lyhennetäänkö?
    }
    
    
}
