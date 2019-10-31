package it.unical.ingsw.intermediate_test_a.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.ingsw.intermediate_test_a.model.Impiccato;

public class ImpiccatoAdvancedTest {
	
	private static Impiccato imp;
	
	@BeforeClass
	public static void initialize() {
		imp = new Impiccato("ciccio");
	}
	
	@Before
	public void reset() {
		imp = new Impiccato("ciccio");
	}

	@Test
	public void winWorks() {
		imp.play('c');
		imp.play('i');
		imp.play('o');
		assertEquals(1, imp.getRisultato());
	}
	
	@Test(timeout = 1000)
	public void loseWorks() {
		imp.play('c');
		imp.play('d');
		imp.play('e');
		imp.play('f');
		imp.play('g');
		imp.play('h');
		
		assertEquals(2, imp.getRisultato());
	}
	
	@Test
	public void playWorks() {
		imp.play('i');
		imp.play('o');
		String tmp="_i__io";
		String parolaCorrente = new String(imp.getParolaCorrente());
		assertEquals(tmp, parolaCorrente);
	}

}
