
package sanaindeksi;

/**
 * Trie-puu, johon voi lisätä sanoja ja niitä ja niiden alkuja voi etsiä. Tuntee juurisolmunsa.
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
     * etsitään sana puusta ja palautetaan sanan viimeisen kirjaimen solmun rivitiedot
     * @param sana käyttäjän hakema sana
     * @return String[] jos sana löytyi palauta viimeisen solmun rivitiedot
     */    
    public Taulukko[] etsi(String sana){
        System.out.println();
        System.out.println("Etsitään sanaa " +sana);
        Solmu nyt = this.juuri;
        for(int i = 0; i<sana.length(); i++){
            Solmu seur = nyt.lapsisolmu(sana.charAt(i));
            if(seur == null){
             System.out.println("Ei löytynyt: " + sana + " :(");
                return null;
            } else nyt = seur;
        }
        return nyt.getRivit();
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
