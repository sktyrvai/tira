
package sanaindeksi;

/**
 * Trie-puu, johon voi lisätä sanoja ja niitä ja niiden alkuja voi etsiä. Tuntee juurisolmunsa.
 * @author Sanna Tyrväinen
 * @version
 */
public class Puu {
    /**
     * Puun juurisolmu.
     */
    private Solmu juuri;
    
    
    public Puu(){
        juuri = new Solmu(' ');   //lisää tähän tiedlkm?     
    }
    
    /**
     * Lisätään sana puuhun ja sanan viimeiseen kirjaimeen sanan päättyminen
     * @param sana tekstistä luettu sana
     */
    public void lisays(String sana){
        Solmu nyt = this.juuri;
        
        for(int i = 0; i< sana.length(); i++ ){
            Solmu seur = nyt.lapsisolmu(sana.charAt(i));
            if(seur == null){
                Solmu x = new Solmu(sana.charAt(i));
                nyt.uusiLapsi(x);
                nyt = x;
            } else nyt = seur;
            if(i== sana.length()-1){
                    nyt.setSananLoppu(true);
                }          
        }
    }
    
    /**
     * Lisätään sana puuhun, jokaiseen sanan solmuun millä rivillä sijaitseee, ja sanan viimeiseen kirjaimeen sanan päättyminen
     * @param sana tekstistä luettu sana
     * @param rivi tekstin rivi, jossa sana esiintyi
     * @param tied mones tiedosto kyseessä (indeksointi alkaa nollasta)
     * 
     */
    public void lisays(String sana, int rivi, int tied){
        Solmu nyt = this.juuri;
        
        for(int i = 0; i< sana.length(); i++ ){
            Solmu seur = nyt.lapsisolmu(sana.charAt(i));
            if(seur == null){
                Solmu x = new Solmu(sana.charAt(i));
                nyt.uusiLapsi(x);
                nyt = x;
                nyt.addRivi(rivi, tied);
            } else{ 
                nyt = seur;            
                nyt.addRivi(rivi, tied);
            }
            if(i== sana.length()-1){
                    nyt.setSananLoppu(true);
                }          
        }
    }
    
    /**
     * Etsii sanan puusta ja palautetaan sanan viimeisen kirjaimen solmun rivitiedot.
     * @param sana käyttäjän hakema sana
     * @return String[] jos sana löytyi palauta viimeisen solmun rivitiedot
     */    
    public Taulukko[] etsiSana(String sana){
        //System.out.println();
        //System.out.println("Etsitään sanaa " +sana);
        Solmu nyt = this.juuri;
        for(int i = 0; i<sana.length(); i++){
            Solmu seur = nyt.lapsisolmu(sana.charAt(i));
            if(seur == null){
                return null;
            } else nyt = seur;
        }
        //System.out.println("Löytyi vika solmu: "+ nyt);
        return nyt.getRivit();
    }
    
    /**
     * Etsii puusta useamman sanan, vertailee näiden rivitietoja ja palauttaa tiedon riveistä, joissa kaikki esiintyvät.
     * @param sanat
     * @return uusi
     */
    public Taulukko[] etsi(String hakusanat){
        String[] sanat = hakusanat.split(" ");
        Taulukko[] taul1 = etsiSana(sanat[0]);
        
        Taulukko[] uusi = taul1;
        
        if(taul1 == null){
            return null;
        }
        
        for(int i =1; i< sanat.length;i++){
            Taulukko[] taul2 = etsiSana(sanat[i]);
            if(taul2 == null){
                return null;
            }
            uusi = new Taulukko[taul2.length];           
            for(int k = 0; k<uusi.length; k++){
                uusi[k] = new Taulukko();
            }
            for(int j = 0; j<taul2.length; j++){
                int a = 1;
                int b = 1;               
                while(a <= taul1[j].getKoko() && b <= taul2[j].getKoko()){
                    if(0 == ((Integer) taul1[j].get(a)).compareTo((Integer) taul2[j].get(b))){
                        uusi[j].lisaa(taul2[j].get(b));
                        a++;
                        b++;
                    }else 
                        if((Integer) taul1[j].get(a) > (Integer) taul2[j].get(b)){
                        b++;
                    }else if((Integer) taul1[j].get(a) < (Integer) taul2[j].get(b)){ 
                        a++;
                    }
                }                
            }
            taul1 = taul2;
        }
        return uusi; 
    }
   

    /**
     * Palauttaa puun juuren.
     * @return puun juuren 
     */
    public Solmu getJuuri(){
        return this.juuri;
    }
    
    /*Esa Junttilan Trie-puun tulostus
     * http://www.cs.helsinki.fi/u/ejunttil/opetus/tiraharjoitus/treeprint.txt 
    */
    
    public String toString() {
	return this.toStringHelp(this.juuri, "");
    }

    private String toStringHelp(Solmu node, String indentation) {
	if (node == null) return "";
	else {
		String str = "";
		str += "\n" + indentation + "--->" + node;
		for(Solmu lapsi: node.getLapset()){
			str += toStringHelp(lapsi, indentation + "     |");
		}
		str += "\n" + indentation;
		return str;
	}
    }
        
}
