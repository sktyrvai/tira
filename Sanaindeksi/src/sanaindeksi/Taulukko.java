
package sanaindeksi;

import java.lang.reflect.Array;

/**
 *
 * @author sktyrvai
 */
public class Taulukko {
    private int lkm;
    private Object[] sanat;

    
    //object?
    //yleistä kaikkiin luokkiin?
    
    public Taulukko(){
        //sanat = new E[5];
        //this.c = c;
        sanat = new Object[5];
    }

    
    
    /*public Taulukko(int koko){
        sanat = new E[koko];
    }
    * 
    */
    
    /**
     * Lisää uuden alkoin taulukkoon. Jos taulukko on täysi ennen lisäystä, kaksinkertaista taulukon koko.
     * @param uusi taulukkoon lisättävä alkio
     */
    public void lisaa(Object uusi){
        if(lkm == sanat.length-1){
            kopioi();
        }
        lkm++;
        sanat[lkm] = uusi;                
    }
    
    /*
     * kopioi taulukon kaksikertaa isompaan taulukkoon
     */
    private void kopioi(){
       Object[] uusi = new Object[2*sanat.length];
        for(int i = 0; i< sanat.length; i++){
            uusi[i] = sanat[i];
        }
        sanat = uusi;
    }
    /**
     * Palauttaa pyydetyn rivin. HUOM! Taulukon ensimmäinen paikka on tyhjä. 
     * @param int i
     * @return String sanat[i]. i. rivi 
     */
    
    public Object getRivi(int i){
        return this.sanat[i];
    }
}
