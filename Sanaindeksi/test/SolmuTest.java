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
    public void testi(){
        Solmu merimies = new Solmu((char) ('a' + Math.round(26*Math.random())));
        merimies.uusiLapsi(new Solmu('u'));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
