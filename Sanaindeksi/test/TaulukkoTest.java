/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.*;
import static org.junit.Assert.*;
import sanaindeksi.Taulukko;

/**
 *
 * @author Sanna
 */
public class TaulukkoTest {
    
    public Taulukko taulukko;
    
    public TaulukkoTest() {
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
    public void tyhja(){
        taulukko = new Taulukko();
        assertTrue(taulukko.isEmpty() && taulukko.getKoko() ==0);
        assertTrue(perus(taulukko));
    }
    
    @Test
    public void testailu(){
        taulukko = new Taulukko(3);
        taulukko.lisaa("poi");
        taulukko.lisaa("pui");
        taulukko.lisaa("piu");
        taulukko.lisaa("mui");
        taulukko.lisaa("poks");
        assertTrue(taulukko.get(4).equals("mui") && perus(taulukko));
    }
    
    /*
     *lisätää tyhjään taulukkoon 100-200 alkiota, koko pysyy oikeana 
     */
    @Test
    public void koko(){
        taulukko = new Taulukko();
        int k = (int) (Math.round(100*Math.random())+100);
        for(int i = 0; i<k; i++){
            taulukko.lisaa("eka");
        }
        assertTrue(taulukko.getKoko() == k);
    }
    
   
    private boolean perus(Taulukko taulukko){
        return (taulukko.getKoko() <= taulukko.getTaulukko().length);
    }
}
 
