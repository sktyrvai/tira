package sanaindeksi;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Sanna
 */
public class PuuTest {
    
    public PuuTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        //koivu = new Puu();
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
    
    /**
     * tyhjässä puussa ei ole lapsisomua
     */
    @Test
    public void tyhjaPuu(){
        char c = (char) ('a' + Math.round(26*Math.random())); // randomoi c
        Puu koivu = new Puu();
        assertTrue(koivu.getJuuri().lapsisolmu(c)==null);
    }
    
    @Test
    public void tyhjaJuuri(){
        Puu p = new Puu();
        assertTrue(p.getJuuri().getMerkki()==' ');
    }
    
    /**
     * Lisää puuhun sanoja taulukosta ja hakee sitten arvotun sanan arvottua alkua
     */
    
    @Test
    public void lisaaEtsi(){
        Puu p = new Puu();
        String[] sanat = {"vapaus", "sana", "sulo", "itseironinen", "keksitty"};
        for(int i = 0; i<sanat.length; i++){
            p.lisays(sanat[i]);
        }
        for(int i = 0; i<80; i++){
            int k = (int) Math.round((sanat.length-1)*Math.random()); //0< k <sanat.length
            int l = sanat[k].length() - (int) (Math.round((sanat[k].length()-1)*Math.random()));
            String etsi = sanat[k].substring(0, l);
            assertTrue(p.etsi(etsi)!= null);
        }
    }
}
