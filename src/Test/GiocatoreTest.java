package Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GiocatoreTest {
    private Giocatore giocatore;

    @Before
    public void setUp() {
        giocatore = new Giocatore();
    }

    @Test
    public void testCfu() {
        giocatore.setCfu(20);
        assertEquals(20, giocatore.getCfu());
    }

    @Test
    public void testBorsa() {
        Borsa borsa = new Borsa();
        giocatore.setBorsa(borsa);
        assertEquals(borsa, giocatore.getBorsa());
    }

    @Test
    public void testPrendereAttrezzo() {
        Attrezzo attrezzo = new Attrezzo("Martello", 3);
        assertTrue(giocatore.prendereAttrezzo(attrezzo));
        assertTrue(giocatore.getBorsa().hasAttrezzo("Martello"));
    }

    @Test
    public void testPosareAttrezzo() {
        Attrezzo attrezzo = new Attrezzo("Martello", 3);
        giocatore.prendereAttrezzo(attrezzo);
        assertEquals(attrezzo, this.giocatore.posareAttrezzo("Martello"));
        assertFalse(giocatore.getBorsa().hasAttrezzo("Martello"));
    }
}