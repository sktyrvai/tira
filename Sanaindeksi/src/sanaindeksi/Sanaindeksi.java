/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanaindeksi;

import java.util.ArrayList;

/**
 *
 * @author Sanna Tyrväinen
 * @version 18052012
 */
public class Sanaindeksi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ekaSana = "testaus";
        
        Puu puu = new Puu();
        puu.lisays(ekaSana);
        System.out.println(puu);
        puu.lisays("testi");
        puu.lisays("tempaus");
        System.out.println(puu);
        if(puu.etsi("pop")){
            System.out.println("Puu sisältää sanan test");
        }
        
        // TODO:
        //
        // lue tekstitiedosto
        // tee testejä
        //
        // lisää sanojen loppuun tieto rivistä
        // laita teksti String-taulukkoon
        
    }
    
    
}
