

package sanaindeksi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Lukee tiedostoja ja lisää puuhun tekstiä sanakerrallaan. Siistii lisättävistä sanoista erikoismerkit, numerot yms pois.
 * @author Sanna
 * @version 280512
 */
public class Lukija {

    /**
     * Puu, johon Lukija lukee tekstitiedostot.
     */
    private Puu Puu;   
    /**
     * Luettujen tiedostojen lukumäärä -1.
     */
    private int tiedostoja;
    /**
     * Aputaulukko, jota käytetään saatujen tekstitiedostojen rivittämiseen.
     */
    private Taulukko Rivit;
    
    public Lukija(Puu puu){
        this.Puu = puu;
        this.tiedostoja = 0;
        
    }
    
    /**
     * Lisää tiedostossa olevat sanat puuhun ja merkitsee loppusolmuihin sijaintirivit
     * @param tiedosto käyttäjän antama tekstitiedosto 
     */
    public Taulukko lisaaTiedosto(File tiedosto){
        Rivit = new Taulukko();
        Scanner lukija = null;
        try {
            lukija = new Scanner(tiedosto, "utf-8");
        } catch (FileNotFoundException ex) {
            System.out.println(tiedosto + " ei löytynyt");
        }
        
        int r = 0;        
        while(lukija.hasNextLine()){
            r++;
            String rivi = lukija.nextLine();
            Rivit.lisaa(rivi);
            //rivi = rivi.toLowerCase();
            //rivi = rivi.replace('"',' ');
            String[] sanat = rivi.split(" ");
            for(int i = 0; i< sanat.length; i++){
                String s = this.siistiSana(sanat[i]);  
                Puu.lisays(s, r, tiedostoja);
            }
            //System.out.println(rivi);          
        }
        System.out.println("tekstin sisältävän dynaamisen taulukon koko " +Rivit.getKoko()); //poista tämä
        tiedostoja ++;
        return Rivit;
    }
    
   /**
    * Poistaa saadusta Stringistä välimerkit, välit, numerot ynnä muut epäkirjaimet.
    * @param sana
    * @return s 
    */
    
    private String siistiSana(String sana){
        String s = "";
        sana = sana.toLowerCase();
        for(int i = 0; i<sana.length(); i++){
            char c = sana.charAt(i);
            if(Character.isLetter(c)){
                s = s+ Character.toString(c); 
            }                   
        }
        
        return s;
    }
    
}
