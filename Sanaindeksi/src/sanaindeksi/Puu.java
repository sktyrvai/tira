
package sanaindeksi;

/**
 *
 * @author Sanna Tyrväinen
 * @version
 */
public class Puu {
    private Solmu juuri;
    //private Taulukko Teksti;
    
    public Puu(){
        juuri = new Solmu(' ');        
    }
    
    
    /*public void setTeksti(Taulukko Teksti){
        this.Teksti = Teksti;
    }
    * 
    */
    /**
     * Lisätään sana puuhun, jokaiseen sanan solmuun millä rivillä sijaitseee, ja sanan viimeiseen kirjaimeen sanan päättyminen
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
     * etsitään sana puusta ja tulotetaan esiintymisrivit
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
        //System.out.println();
        return nyt.getRivit();
    }
   
    
    /**
     * Saa tiedon tulostettavista riveistä ja tulostaa rivit. 
     * @param tieto solmun tieto riviesiintymisistään
     */
    /*private void tulostaRivit(String tieto){
        if(tieto.length() == 0){
            return;
        }
        String[] rivit = tieto.split(" ");
        for(int i = 0; i<rivit.length; i++){
            if(onkoNumero(rivit[i])){
                System.out.println("rivi "+ rivit[i] +" "+ Teksti.get(Integer.parseInt(rivit[i])));
            }
        }
    }
    * 
    */
    
    /**
     *Tarkistaa onko saatu String numero
     * 
     */
    
    private boolean onkoNumero(String num){
        for(char c: num.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
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
