
package sanaindeksi;

/**
 *
 * @author Sanna Tyrväinen
 * @version
 */
public class Puu {
    private Solmu juuri;
    private Taulukko Teksti;
    
    public Puu(){
        juuri = new Solmu(' ');        
    }
    
    
    public void setTeksti(Taulukko Teksti){
        this.Teksti = Teksti;
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
   
    
    /*public String etsi(String sana){
        Solmu nyt = this.juuri;
        for(int i = 0; i<sana.length(); i++){
            Solmu seur = nyt.lapsisolmu(sana.charAt(i));
            if(seur == null){
                return "Ei löytynyt";
            } else nyt = seur;
        } 
        String all = nyt.getRivit();
        all = all + haeRivit(nyt);
        
        /*for(Solmu s :nyt.getLapset()){
            if (s.getSananLoppu()){
                System.out.println(s.Rivit);
            }
        }        
        System.out.println();
        return all;
    }    
    private String haeRivit(Solmu nyt){
        String riv = "";
        for(Solmu s: nyt.getLapset()){
            if(s.getSananLoppu()){
                System.out.print(s.getRivit());
            }
            riv = riv + haeRivit(s);
        }    
        return riv;
    }
    * 
   */    
    
    public boolean etsi(String sana){
        System.out.println();
        System.out.println("Etsitään sanaa " +sana);
        Solmu nyt = this.juuri;
        for(int i = 0; i<sana.length(); i++){
            Solmu seur = nyt.lapsisolmu(sana.charAt(i));
            if(seur == null){
             System.out.println("Ei löytynyt: " + sana + " :(");
                return false;
            } else nyt = seur;
        }
        tulostaRivit(nyt.getRivit());
        //System.out.println(nyt.getRivit());
        //tulosta
        haeRivit(nyt);
        System.out.println();
        return true;
    }
    
    private void haeRivit(Solmu nyt){
        for(Solmu s: nyt.getLapset()){
            if(s.getSananLoppu()){
                //System.out.println(s.getRivit());
                tulostaRivit(s.getRivit());
            }
            haeRivit(s);
        }
    }
    
    private void tulostaRivit(String tieto){
        String[] rivit = tieto.split(" ");
        //for(int i = 0; i< rivit.length;i++){
          //  System.out.print(rivit[i]+ ", ");
        //}
        for(int i = 0; i<rivit.length; i++){
            if(onkoNumero(rivit[i])){
                //System.out.println("Rivillä " +Integer.parseInt(rivit[i])+ " pitäisi esiintyvä etsitty sana rivi");
                //System.out.println("Tekstin dynaamiusen taulukon koko " + Teksti.getKoko());
                System.out.println("rivi "+ rivit[i] +" "+ Teksti.get(Integer.parseInt(rivit[i])));
            }
        }
    }
    
    
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
