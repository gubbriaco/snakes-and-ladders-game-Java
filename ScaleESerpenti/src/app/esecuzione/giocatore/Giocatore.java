package app.esecuzione.giocatore;

import app.esecuzione.mazzo.Carta;

public interface Giocatore {

	/** Gestisce la richiesta di movimento della pedina corrispondente per una
	 *  determinata combinazione di dadi */
	int movementRequest(int casellaCorrente, int combinazioneDadi);
	
	/** Gestisce la pesca di una carta da un apposito mazzo */
	void pescaUnaCarta();
	
	/** Conserva la carta di tipologia "Divieto di Sosta" per essere utilizzata
	 *  successivamente per evitare la sosta in una casella di tipologia Sosta */
	void conservaCarta(Carta carta);
	
	/**
	 * Imposta la nuova casella corrente del giocatore al numero di casella casellaNuova
	 * @param casellaNuova Numemero della nuova casella raggiunta dal giocatore 
	 * in questione
	 */
	void setCasellaCorrente(int casellaNuova);
	
	/**
	 * Restituisce il numero della casella corrente in cui e' posizionata la pedina
	 * del giocatore in questione.
	 * @return Numero della casella in cui e' posizionato il giocatore.
	 */
	int getCasellaCorrente();
	
}