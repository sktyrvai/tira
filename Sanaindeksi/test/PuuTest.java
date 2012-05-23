/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.*;
import static org.junit.Assert.*;
import sanaindeksi.Puu;

/**
 *
 * @author Sanna
 */
public class PuuTest {
    //Puu koivu;
    
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
