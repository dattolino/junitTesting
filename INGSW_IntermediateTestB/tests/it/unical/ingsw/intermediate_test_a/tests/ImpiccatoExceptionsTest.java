package it.unical.ingsw.intermediate_test_a.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.ingsw.intermediate_test_a.model.Impiccato;
import it.unical.ingsw.intermediate_test_a.model.InvalidPlayException;

public class ImpiccatoExceptionsTest {
	
	private static Impiccato imp;
	
	@BeforeClass
	public static void init() {
		imp = new Impiccato("ciccio");
	}
	
	@Before
	public void reset() {
		imp = new Impiccato("ciccio");
	}

	@Test(expected = InvalidPlayException.class)
	public void doubleMTest() {
		imp.play('m');
		imp.play('m');
	}
	
	@Test(expected = InvalidPlayException.class)
	public void numberTest() {
		imp.play('1');
	}
	
	@Test(expected = InvalidPlayException.class)
	public void gameEndTest() {
		imp.play('c');
		imp.play('i');
		imp.play('o');
		imp.play('g');
	}
	
	@After
	public void endTest() {
		System.out.println("Test terminato.");
	}
	
	@AfterClass
	public static void endSessionTest() {
		System.out.println("Tutti i test sono terminati.");
	}

}
