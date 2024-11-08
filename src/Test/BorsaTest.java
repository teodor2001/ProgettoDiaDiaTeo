package Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BorsaTest {
    private Borsa borsa;

    @Before
    public void setUp() {
        borsa = new Borsa();
    }

    @Test
    public void testAddAttrezzo() {
        Attrezzo attrezzo = new Attrezzo("Martello", 3);
        assertTrue(borsa.addAttrezzo(attrezzo));
        assertEquals(3, borsa.getPeso());
        assertFalse(borsa.addAttrezzo(new Attrezzo("Chiave", 8)));
    }

    @Test
    public void testGetAttrezzo() {
        Attrezzo attrezzo = new Attrezzo("Martello", 3);
        borsa.addAttrezzo(attrezzo);
        assertEquals(attrezzo, borsa.getAttrezzo("Martello"));
        assertNull(borsa.getAttrezzo("Chiave"));
    }

    @Test
    public void testRemoveAttrezzo() {
        Attrezzo attrezzo1 = new Attrezzo("Martello", 3);
        Attrezzo attrezzo2 = new Attrezzo("Chiave", 2);
        borsa.addAttrezzo(attrezzo1);
        borsa.addAttrezzo(attrezzo2);
        assertEquals(attrezzo1, borsa.removeAttrezzo("Martello"));
        assertNull(borsa.getAttrezzo("Martello"));
        assertEquals(attrezzo2, borsa.getAttrezzo("Chiave"));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(borsa.isEmpty());
        borsa.addAttrezzo(new Attrezzo("Martello", 3));
        assertFalse(borsa.isEmpty());
    }

    @Test
    public void testHasAttrezzo() {
        Attrezzo attrezzo = new Attrezzo("Martello", 3);
        borsa.addAttrezzo(attrezzo);
        assertTrue(borsa.hasAttrezzo("Martello"));
        assertFalse(borsa.hasAttrezzo("Chiave"));
    }

    @Test
    public void testGetPeso() {
        Attrezzo attrezzo1 = new Attrezzo("Martello", 3);
        Attrezzo attrezzo2 = new Attrezzo("Chiave", 2);
        borsa.addAttrezzo(attrezzo1);
        borsa.addAttrezzo(attrezzo2);
        assertEquals(5, borsa.getPeso());
    }
}