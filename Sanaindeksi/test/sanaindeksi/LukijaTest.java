package sanaindeksi;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Sanna
 */
public class LukijaTest {
    Puu koivu;
    public LukijaTest() {
        koivu = new Puu();
        Solmu.setTiedLkm(1);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testaaPerus(){
        Lukija lukija = new Lukija(koivu);
        File tiedosto = new File("testi.txt");
        Taulukko taulu = lukija.lisaaTiedosto(tiedosto);
        
        Taulukko[] tulos = koivu.etsi("toinen");
        assertTrue(1==tulos[0].getKoko());
        
        tulos = koivu.etsi("kamelilauma");
        assertTrue(null == tulos);      
    }
    
    @Test
    public void testaaTyhjaaTiedostoa(){
        Lukija lukija = new Lukija(koivu);
        lukija.lisaaTiedosto(new File("empty.txt"));
        assertTrue(koivu.etsi("anything") == null);
             
    }
     
    @Test
    public void testaaSiistijaa(){
        Lukija lukija = new Lukija(koivu);
        assertTrue(lukija.siistiSana("....").equals(""));
        assertTrue(lukija.siistiSana("4Kfg?").equals("kfg"));
        assertTrue(lukija.siistiSana("! ä+IT!!11i").equals("äiti"));
        assertFalse(lukija.siistiSana("AAAu+'%_%doh").equals("Aaaudoh"));
        assertTrue(lukija.siistiSana("Tämä Ån pitkähkö 7e571 lause, mutta ei se mitaan!!?").equals("tämäånpitkähköelausemuttaeisemitaan"));
        assertTrue(lukija.siistiSana("").equals(""));
    } 
    
    
    @Test
    public void testaaLukuaikaa(){
        System.out.println();
        Lukija lukija = new Lukija(koivu);
        Solmu.setTiedLkm(2);
        long alku = System.currentTimeMillis();
        lukija.lisaaTiedosto(new File("testi4.txt"));
        lukija.lisaaTiedosto(new File("testi5.txt"));
        long loppu = System.currentTimeMillis();
        System.out.println("Kaksi tekstitiedostoa, rivejä 542 ja 898. Kesti " + (loppu-alku)+ "ms");
        
        alku = System.nanoTime();
        koivu.etsi("brain");
        loppu = System.nanoTime();
        System.out.println("etsi sanan brain puusta ajassa: " +(loppu-alku)+ "* 10^-6 ms");
        
        alku = System.nanoTime();
        koivu.etsi("onomatopoeettinenalkoholiliikelaulutanssikoreografia");
        loppu = System.nanoTime();
        System.out.println("etsi sanan onomatopoeettinenalkoholiliikelaulutanssikoreografia puusta ajassa: " +(loppu-alku)+ "*10^-6 ms");
        
    }
    
    @Test
    public void vertaaLukuAikaaIso(){
        System.out.println();
        Lukija lukija = new Lukija(koivu);
        long alku = System.currentTimeMillis();
        lukija.lisaaTiedosto(new File("kalevala.txt"));
        long loppu = System.currentTimeMillis();  
        System.out.println("Kalevalan lukemiseen, 23 142 riviä, meni "+ (loppu-alku)+"ms");
    }
     @Test
     public void vertaaHakuAikaaIso(){
        long alku = System.nanoTime();
        koivu.etsi("vanha");
        long loppu = System.nanoTime();
        System.out.println("etsi sanan vanha Kalevala-puusta ajassa: " +(loppu-alku)+ "*10^-6 ms");
        
        alku = System.nanoTime();
        koivu.etsi("onomatopoeettinenalkoholiliikelaulutanssikoreografia");
        loppu = System.nanoTime();
        System.out.println("etsi sanan onomatopoeettinenalkoholiliikelaulutanssikoreografia Kalevala-puusta ajassa: " +(loppu-alku)+ "*10^-6 ms");
        
        alku = System.nanoTime();
        koivu.etsi("onomatopoeettinenalkoholiliikelaulutanssikoreografia vanha");
        loppu = System.nanoTime();
        System.out.println("etsi sanat vanha ja  onomatopoeettinenalkoholiliikelaulutanssikoreografia Kalevala-puusta ajassa: " +(loppu-alku)+ "*10^-6 ms");
        
        
    }
    
    @Test
    public void vertaaLukuAikaapieni(){
        System.out.println();
        Lukija lukija = new Lukija(koivu);
        long alku = System.currentTimeMillis();
        lukija.lisaaTiedosto(new File("testi.txt"));
        long loppu = System.currentTimeMillis();  
        System.out.println("Tiedoston lukemiseen, 11 riviä, meni "+ (loppu-alku)+ "ms");
        
        alku = System.nanoTime();
        koivu.etsi("toine");
        loppu = System.nanoTime();
        System.out.println("etsi sanan toine puusta ajassa: " +(loppu-alku)+ "*10^-6 ms");
        
        alku = System.nanoTime();
        koivu.etsi("onomatopoeettinenalkoholiliikelaulutanssikoreografia");
        loppu = System.nanoTime();
        System.out.println("etsi sanan onomatopoeettinenalkoholiliikelaulutanssikoreografia puusta ajassa: " +(loppu-alku)+ "*10^-6 ms");
    }
    
    @Test
    public void vertaaLukuAikaaEmilypieni(){
        System.out.println();
        Lukija lukija = new Lukija(koivu);
        long alku = System.currentTimeMillis();
        lukija.lisaaTiedosto(new File("testi4.txt"));
        long loppu = System.currentTimeMillis();  
        System.out.println("Tiedoston lukemiseen, 542 riviä, meni "+ (loppu-alku)+ "ms");
    }
    
    @Test
    public void vertaaHakuAikaaEmilypieni(){
        
        long alku = System.nanoTime();
        koivu.etsi("count");
        long loppu = System.nanoTime();
        System.out.println("etsi sanan count puusta ajassa: " +(loppu-alku)+ "*10^-6 ms");
        
        alku = System.nanoTime();
        koivu.etsi("onomatopoeettinenalkoholiliikelaulutanssikoreografia");
        loppu = System.nanoTime();
        System.out.println("etsi sanan onomatopoeettinenalkoholiliikelaulutanssikoreografia puusta  (542 riviä) ajassa: " +(loppu-alku)+ "*10^-6 ms");
        
        alku = System.nanoTime();
        koivu.etsi("onomatopoeettinenalkoholiliikelaulutanssikoreografia count");
        loppu = System.nanoTime();
        System.out.println("etsi sanat count ja  onomatopoeettinenalkoholiliikelaulutanssikoreografia puusta  (542 riviä) ajassa: " +(loppu-alku)+ "*10^-6 ms");
    }
    
    @Test
    public void vertaaLukuAikaaEmilykeski(){
        System.out.println();
        Lukija lukija = new Lukija(koivu);
        long alku = System.currentTimeMillis();
        lukija.lisaaTiedosto(new File("testi5.txt"));
        long loppu = System.currentTimeMillis();  
        System.out.println("Tiedoston lukemiseen, 899 riviä, meni "+ (loppu-alku)+ "ms");
    }
    
    @Test            
    public void vertaaHakuAikaaEmilykeski(){
        
        long alku = System.nanoTime();
        koivu.etsi("brain");
        long loppu = System.nanoTime();
        System.out.println("etsi sanan brain puusta ajassa: " +(loppu-alku)+ "*10^-6 ms");
        
        alku = System.nanoTime();
        koivu.etsi("onomatopoeettinenalkoholiliikelaulutanssikoreografia");
        loppu = System.nanoTime();
        System.out.println("etsi sanan onomatopoeettinenalkoholiliikelaulutanssikoreografia puusta (899) ajassa: " +(loppu-alku)+ "*10^-6 ms");
        
        alku = System.nanoTime();
        koivu.etsi("onomatopoeettinenalkoholiliikelaulutanssikoreografia count");
        loppu = System.nanoTime();
        System.out.println("etsi sanat count ja  onomatopoeettinenalkoholiliikelaulutanssikoreografia puusta  (899 riviä) ajassa: " +(loppu-alku)+ "*10^-6 ms");
        
        alku = System.nanoTime();
        koivu.etsi("of the of hone");
        loppu = System.nanoTime();
        System.out.println("etsi sanat of the hone puusta  (899 riviä) ajassa: " +(loppu-alku)+ "* 10^-6 ms");
        
        
    }
  
}
