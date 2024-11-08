package Test;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;

public class PartitaTest {
	private Partita partita;

	@Before
	public void setUp() {
        partita = new Partita();
        partita.setCfu(20);
	}

	@Test
	public void testVinta() {
		partita.setStanzaCorrente(this.partita.getStanzaVincente());
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
