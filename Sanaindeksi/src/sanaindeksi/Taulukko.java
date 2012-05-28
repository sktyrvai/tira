
package sanaindeksi;

/**
 *
 * @author sktyrvai
 */
public class Taulukko {
    private int lkm;
    private String[] sanat;
    
    //object?
    //yleistä kaikkiin luokkiin?
    
    public Taulukko(){
        sanat = new String[5];
    }
    
    public Taulukko(int koko){
        sanat = new String[koko];
    }
    
    /**
     * Lisää uuden alkoin taulukkoon. Jos taulukko on täysi ennen lisäystä, kaksinkertaista taulukon koko.
     * @param uusi taulukkoon lisättävä alkio
     */
    public void lisaa(String uusi){
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
        String[] uusi = new String[2*sanat.length];
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
    
    public String getRivi(int i){
        return this.sanat[i];
    }
}
