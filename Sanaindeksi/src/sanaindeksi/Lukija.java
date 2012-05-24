

package sanaindeksi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanna
 */
public class Lukija {
    private Puu puu;
    
    public Lukija(Puu puu){
        this.puu = puu;
    }
    
    public void lisaaTiedosto(File tiedosto){
        
        Scanner lukija = null;
        try {
            lukija = new Scanner(tiedosto);
        } catch (FileNotFoundException ex) {
            //System.out.println(tiedosto + "ei löytynyt");
        }
       
        int r = 0;        
        while(lukija.hasNextLine()){
            r++;
            String rivi = lukija.nextLine();
            String[] sanat = rivi.split(" ");
            for(int i = 0; i< sanat.length; i++){
                puu.lisays(sanat[i], r);
            }
            System.out.println(rivi);          
        }
        
    }
    
}
