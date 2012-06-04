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
    
   
    private boolean perus(Taulukko taulukko){
        return (taulukko.getKoko() <= taulukko.getTaulukko().length);
    }
}
 
