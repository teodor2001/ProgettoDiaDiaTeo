package Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
    private Stanza stanza;
    private Stanza stanzaAdiacente;
    private Attrezzo attrezzo;
    
    @Before
    public void setUp() {
        this.stanza = new Stanza("Aula N10");
        this.stanzaAdiacente = new Stanza("Aula N11");
        this.attrezzo = new Attrezzo("martello", 3);
    }

    @Test
    public void testGetNome() {
        assertEquals("Aula N10", this.stanza.getNome());
    }

    @Test
    public void testImpostaEGetStanzaAdiacente() {
        this.stanza.impostaStanzaAdiacente("nord", stanzaAdiacente);
        assertEquals(stanzaAdiacente, this.stanza.getStanzaAdiacente("nord"));
    }

    @Test
    public void testGetStanzaAdiacenteInesistente() {
        assertNull(this.stanza.getStanzaAdiacente("sud"));
    }

    @Test
    public void testAddAttrezzo() {
        assertTrue(this.stanza.addAttrezzo(attrezzo));
    }

    @Test
    public void testHasAttrezzoFalse() {
        assertFalse(this.stanza.hasAttrezzo("cacciavite"));
    }

    @Test
    public void testGetAttrezzo() {
        this.stanza.addAttrezzo(attrezzo);
        assertEquals(attrezzo, this.stanza.getAttrezzo("martello"));
    }

    @Test
    public void testRemoveAttrezzo() {
        this.stanza.addAttrezzo(attrezzo);
        assertTrue(this.stanza.removeAttrezzo(attrezzo));
        assertFalse(this.stanza.hasAttrezzo("martello"));
    }

    @Test
    public void testRemoveAttrezzoNonPresente() {
        assertFalse(this.stanza.removeAttrezzo(attrezzo));
    }

    @Test
    public void testGetDirezioni() {
        this.stanza.impostaStanzaAdiacente("nord", stanzaAdiacente);
        String[] direzioni = this.stanza.getDirezioni();
        assertEquals(1, direzioni.length);
        assertEquals("nord", direzioni[0]);
    }

    @Test
    public void testLimiteMassimoAttrezzi() {
        // Aggiungo 10 attrezzi (il massimo consentito)
        for(int i = 0; i < 10; i++) {
            assertTrue(this.stanza.addAttrezzo(new Attrezzo("attrezzo" + i, 1)));
        }
        // L'undicesimo attrezzo non dovrebbe essere aggiunto
        assertFalse(this.stanza.addAttrezzo(new Attrezzo("attrezzoDiTroppo", 1)));
    }

    @Test
    public void testLimiteMassimoDirezioni() {
        // Aggiungo 4 stanze adiacenti (il massimo consentito)
        for(int i = 0; i < 4; i++) {
            this.stanza.impostaStanzaAdiacente("direzione" + i, new Stanza("stanza" + i));
        }
        // Verifico che ci siano effettivamente 4 direzioni
        assertEquals(4, this.stanza.getDirezioni().length);
    }

    @Test
    public void testToString() {
        this.stanza.addAttrezzo(attrezzo);
        this.stanza.impostaStanzaAdiacente("nord", stanzaAdiacente);
        String descrizione = this.stanza.toString();
        assertTrue(descrizione.contains("Aula N10"));
        assertTrue(descrizione.contains("nord"));
        assertTrue(descrizione.contains("martello"));
    }
}