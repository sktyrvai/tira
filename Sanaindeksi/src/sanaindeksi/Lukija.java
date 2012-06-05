

package sanaindeksi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanna
 * @version 280512
 */
public class Lukija {
    private Puu puu;
    public Taulukko Rivit;
    public Lukija(Puu puu){
        this.puu = puu;
        
    }
    
    /**
     * Lisää tiedostossa olevat sanat puuhun ja merkitsee loppusolmuihin sijaintirivit
     * @param tiedosto käyttäjän antama tekstitiedosto 
     */
    public void lisaaTiedosto(File tiedosto){
        //tämä pitää oikeasti tehdä muualla kuin tässä
        Rivit = new Taulukko();
        Scanner lukija = null;
        try {
            lukija = new Scanner(tiedosto);
        } catch (FileNotFoundException ex) {
            System.out.println(tiedosto + " ei löytynyt");
        }
        
        int r = 0;        
        while(lukija.hasNextLine()){
            r++;
            String rivi = lukija.nextLine();
            Rivit.lisaa(rivi);
            String[] sanat = rivi.split(" ");
            for(int i = 0; i< sanat.length; i++){
                puu.lisays(sanat[i], r);
            }
            System.out.println(rivi);          
        }
        System.out.println("tekstin sisältävän dynaamisen taulukon koko " +Rivit.getKoko());
        this.puu.setTeksti(Rivit);
    }
    
}
