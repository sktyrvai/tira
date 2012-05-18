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
        
        Solmu j = new Solmu(ekaSana.charAt(0));
        Solmu s = new Solmu(ekaSana.charAt(1));
        j.uusiLapsi(s);
        j.uusiLapsi(new Solmu('k'));
        
        System.out.println("Hello");

        System.out.println(j);
        ArrayList<Solmu> l = j.getLapset();
        System.out.println("lapset:");
        for(Solmu lapsi: l){
            System.out.println(lapsi);
        }
        // tee solmu
        // tee puu yhdellä sanalla
        // lue tekstitiedosto
        // 
        
    }
    
    
}
