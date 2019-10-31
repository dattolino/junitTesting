package it.unical.ingsw.intermediate_test_a.model;

public class Impiccato {

	public static final int MAX_TENTATIVI = 5;
	public static final int VITTORIA = 1;
	public static final int SCONFITTA = 2;

	private String parolaSegreta;
	private char[] parolaCorrente;
	private boolean[] caratteriUtilizzati = new boolean[26];
	private int risultato = 0;
	private int tentativi = 0;

	public Impiccato(String parolaSegreta) {
		this.parolaSegreta = parolaSegreta;
		parolaCorrente = new char[parolaSegreta.length()];
		for (int i = 0; i < parolaSegreta.length(); i++) {
			parolaCorrente[i] = '_';
		}
	}

	// esempio impiccato.play('m')
	// restituisce vero se la partita è finita, falso altrimenti 
	// risultato è inizializzato a 0 e diventa VITTORIA in caso venga compleata la parola entro MAX_TENTATIVI
	// o SCONFITTA se vengono esauriti i tentativi
	public boolean play(char c) {
		if (c < 'a' || c > 'z') {
			throw new InvalidPlayException("Carattere non valido");
		}
		if (caratteriUtilizzati[c - 'a']) {
			throw new InvalidPlayException("Carattere già utilizzato");
		}
		if (risultato!=0) {
			throw new InvalidPlayException("La partita è finita");
		}
		caratteriUtilizzati[c - 'a'] = true;

		boolean caratterePresente = false;
		boolean vinto = true;
		for (int i = 0; i < parolaSegreta.length(); i++) {
			if (parolaSegreta.charAt(i) == c) {
				parolaCorrente[i] = c;
				caratterePresente = true;
			}
			if (parolaCorrente[i] == '_') {
				vinto = false;
			}
		}
		if (!caratterePresente) {
			tentativi++;
		}
		if (vinto) {
			risultato = VITTORIA;
			return true;
		}

		if (tentativi == MAX_TENTATIVI) {
			risultato = SCONFITTA;
			return true;
		}
		return false;

	}

	public int getRisultato() {
		return risultato;
	}

	public void print() {
		System.out.println("Parola segr: " + parolaSegreta);
		System.out.print("Parola corr: ");
		for (char c : parolaCorrente) {
			System.out.print(c);

		}
		System.out.println();
	}
	
	public char[] getParolaCorrente() {
		return parolaCorrente;
	}

}
