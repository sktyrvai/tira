/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.*;
import static org.junit.Assert.*;
import sanaindeksi.Solmu;

/**
 *
 * @author Sanna
 */
public class SolmuTest {
    
    Solmu merimies;
    
    public SolmuTest() {
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
    public void alussaTyhja(){
        merimies = new Solmu((char) ('a' + Math.round(25*Math.random())));
        assertTrue(merimies.getLapset().isEmpty() && merimies.getRivit().isEmpty());
    }
    
    @Test
    public void lapsisolmuTest(){
        merimies = new Solmu((char) ('a' + Math.round(25*Math.random())));
        
        char a = (char) ('a' + Math.round(25*Math.random()));
        char b = (char) ('a' + Math.round(25*Math.random()));
        char c = (char) ('a' + Math.round(25*Math.random()));
                
        merimies.uusiLapsi(new Solmu(a));
        merimies.uusiLapsi(new Solmu(b));
        merimies.uusiLapsi(new Solmu(c));
                       
        char lapsi = (char) ('a' + Math.round(25*Math.random()));
        
        Solmu s = merimies.lapsisolmu(lapsi);
        if(s != null){
            assertTrue(s.getMerkki()== lapsi);
        } else assertTrue(lapsi != a && lapsi != b && lapsi != c);
    }
    
    /*
     * mietipä vielä miten testaat ääkkösiä...
     */
    @Test
    public void Aakkosia(){
        merimies = new Solmu((char) ('a' + Math.round(25*Math.random())));
        
        char[] d = {'ä', 'ö', 'å'};
        for (int i=0; i<10 ; i++ ){
            merimies.uusiLapsi(new Solmu(d[ (int) Math.round(Math.random()*2)]));
        }
        assertTrue(merimies.getLapset().size() <= 3);
    }
    
    @Test
    public void lastenMaara(){
        merimies = new Solmu((char) ('a' + Math.round(25*Math.random())));
        
        char[] d = {'ä', 'ö', 'å', 'a', 'b', 'a', 'a', 'c', 'å', 'k'};
        for (int i=0; i<10 ; i++ ){
            merimies.uusiLapsi(new Solmu(d[i]));
        }
        assertTrue(merimies.getLapset().size() == 7);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
