
package sanaindeksi;

/**
 *
 * @author Sanna Tyrväinen
 * @version
 */
public class Puu {
    private Solmu juuri;
    
    public Puu(){
        juuri = new Solmu(' ');        
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
     * Lisätään puuhun sana ja sanan viimeiseen merkkiin sanan päättyminen ja esiintymisrivi 
     * @param sana tekstistä luettu sana
     * @param rivi tekstin rivi, jossa sana esiintyi
     * 
     */
    public void lisays(String sana, int rivi){
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
                    nyt.addRivi(rivi);
                }          
        }
    }
    
    /**
     * etsitään sana puusta ja tulotetaan esiintymisrivit
     * palautetaan mielummin kaikki esiintymisrivit kerralla 
     * @param sana käyttäjän hakema sana
     * @return boolean löytyikö sana tai sanalla alkava sana tekstisä
     */
    
    public boolean etsi(String sana){
        Solmu nyt = this.juuri;
        for(int i = 0; i<sana.length(); i++){
            Solmu seur = nyt.lapsisolmu(sana.charAt(i));
            if(seur == null){
                return false;
            } else nyt = seur;
        } 
        System.out.print(nyt.Rivit);
        etsiRivit(nyt);
        
        /*for(Solmu s :nyt.getLapset()){
            if (s.getSananLoppu()){
                System.out.println(s.Rivit);
            }
        }  
        */
        System.out.println();
        return true;
    }
    
    private void etsiRivit(Solmu nyt){
        for(Solmu s: nyt.getLapset()){
            if(s.getSananLoppu()){
                System.out.print(s.Rivit);
            }
            etsiRivit(s);
        }
        
    }
    
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
