package Test;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	@SuppressWarnings("unused")
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	@SuppressWarnings("unused")
	private Labirinto labirinto;
	private Partita partita;

	@Before
	public void setUp() {
        partita = new Partita();
        labirinto = new Labirinto();
        stanzaCorrente = partita.getStanzaCorrente();
        stanzaVincente = partita.getStanzaVincente();
        partita.setCfu(20);
	}

	@Test
	public void testVinta() {
		partita.setStanzaCorrente(stanzaVincente);
		assertTrue(partita.vinta());
		
	}
	
	@Test
	public void testIsFinitaCase1()
	{
		partita.setCfu(0);
		assertTrue(partita.isFinita());
		
	}
	
	@Test
	public void testIsFinitaCase2()
	{
		partita.setFinita();
		assertTrue(partita.isFinita());
		
	}

}
