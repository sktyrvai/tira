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
    public void testaaTyhjaa(){
        Lukija lukija = new Lukija(koivu);
        Taulukko taulu = lukija.lisaaTiedosto(new File("empty.txt"));
        assertTrue(koivu.etsi("anything")==null);
             
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
        
        alku = System.currentTimeMillis();
        koivu.etsi("brain");
        loppu = System.currentTimeMillis();
        System.out.println("etsi sanan brain puusta ajassa: " +(loppu-alku)+ "ms");
        
        alku = System.currentTimeMillis();
        koivu.etsi("onomatopoeettinenalkoholiliikelaulutanssikoreografia");
        loppu = System.currentTimeMillis();
        System.out.println("etsi sanan onomatopoeettinenalkoholiliikelaulutanssikoreografia puusta ajassa: " +(loppu-alku)+ "ms");
        
    }
    
    @Test
    public void vertaaLukuAikaaIso(){
        System.out.println();
        Lukija lukija = new Lukija(koivu);
        long alku = System.currentTimeMillis();
        lukija.lisaaTiedosto(new File("kalevala.txt"));
        long loppu = System.currentTimeMillis();  
        System.out.println("Kalevalan lukemiseen, 23 142 riviä, meni "+ (loppu-alku)+"ms");
        
        alku = System.currentTimeMillis();
        koivu.etsi("vanha");
        loppu = System.currentTimeMillis();
        System.out.println("etsi sanan vanha Kalevala-puusta ajassa: " +(loppu-alku)+ "ms");
        
        alku = System.currentTimeMillis();
        koivu.etsi("onomatopoeettinenalkoholiliikelaulutanssikoreografia");
        loppu = System.currentTimeMillis();
        System.out.println("etsi sanan onomatopoeettinenalkoholiliikelaulutanssikoreografia Kalevala-puusta ajassa: " +(loppu-alku)+ "ms");
    }
    
    @Test
    public void vertaaLukuAikaapieni(){
        System.out.println();
        Lukija lukija = new Lukija(koivu);
        long alku = System.currentTimeMillis();
        lukija.lisaaTiedosto(new File("testi.txt"));
        long loppu = System.currentTimeMillis();  
        System.out.println("Tiedoston lukemiseen, 11 riviä, meni "+ (loppu-alku)+ "ms");
        
        alku = System.currentTimeMillis();
        koivu.etsi("toine");
        loppu = System.currentTimeMillis();
        System.out.println("etsi sanan toine puusta ajassa: " +(loppu-alku)+ "ms");
        
        alku = System.currentTimeMillis();
        koivu.etsi("onomatopoeettinenalkoholiliikelaulutanssikoreografia");
        loppu = System.currentTimeMillis();
        System.out.println("etsi sanan onomatopoeettinenalkoholiliikelaulutanssikoreografia puusta ajassa: " +(loppu-alku)+ "ms");
    }
    
    @Test
    public void vertaaLukuAikaaEmilypieni(){
        System.out.println();
        Lukija lukija = new Lukija(koivu);
        long alku = System.currentTimeMillis();
        lukija.lisaaTiedosto(new File("testi4.txt"));
        long loppu = System.currentTimeMillis();  
        System.out.println("Tiedoston lukemiseen, 542 riviä, meni "+ (loppu-alku)+ "ms");
        
        alku = System.currentTimeMillis();
        koivu.etsi("count");
        loppu = System.currentTimeMillis();
        System.out.println("etsi sanan count puusta ajassa: " +(loppu-alku)+ "ms");
        
        alku = System.currentTimeMillis();
        koivu.etsi("onomatopoeettinenalkoholiliikelaulutanssikoreografia");
        loppu = System.currentTimeMillis();
        System.out.println("etsi sanan onomatopoeettinenalkoholiliikelaulutanssikoreografia puusta ajassa: " +(loppu-alku)+ "ms");
    }
    
    @Test
    public void vertaaLukuAikaaEmilykeski(){
        System.out.println();
        Lukija lukija = new Lukija(koivu);
        long alku = System.currentTimeMillis();
        lukija.lisaaTiedosto(new File("testi5.txt"));
        long loppu = System.currentTimeMillis();  
        System.out.println("Tiedoston lukemiseen, 899 riviä, meni "+ (loppu-alku)+ "ms");
        
        alku = System.currentTimeMillis();
        koivu.etsi("brain");
        loppu = System.currentTimeMillis();
        System.out.println("etsi sanan brain puusta ajassa: " +(loppu-alku)+ "ms");
        
        alku = System.currentTimeMillis();
        koivu.etsi("onomatopoeettinenalkoholiliikelaulutanssikoreografia");
        loppu = System.currentTimeMillis();
        System.out.println("etsi sanan onomatopoeettinenalkoholiliikelaulutanssikoreografia puusta ajassa: " +(loppu-alku)+ "ms");
    }
    
    // lue tiedosto ja etsi kaikki tiedoston sanat puusta
    // testaa hakuaikaa isoissa puissa.
    // nanoTime()
  
}
