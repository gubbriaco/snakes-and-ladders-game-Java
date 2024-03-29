package app.esecuzione.giocatore;

import app.esecuzione.dadi.Dado;
import app.esecuzione.mazzo.carte.Carta;

public interface Giocatore {

	/** Gestisce la richiesta di movimento della pedina corrispondente per una
	 *  determinata combinazione di dadi */
	int movementRequest(int casellaCorrente, int combinazioneDadi);
	
	/** Gestisce la pesca di una carta da un apposito mazzo 
	 * @return Nuova Casella*/
	int pescaUnaCarta();
	
	/** Conserva la carta di tipologia "Divieto di Sosta" per essere utilizzata
	 *  successivamente per evitare la sosta in una casella di tipologia Sosta */
	void conservaCarta(Carta carta);
	
	/**
	 * Imposta la nuova casella corrente del giocatore al numero di casella casellaNuova
	 * @param casellaNuova Numero della nuova casella raggiunta dal giocatore 
	 * in questione
	 */
	void setCasellaCorrente(int casellaNuova);
	
	/**
	 * Restituisce il numero della casella corrente in cui e' posizionata la pedina
	 * del giocatore in questione.
	 * @return Numero della casella in cui e' posizionato il giocatore.
	 */
	int getCasellaCorrente();
	
	/**
	 * Restituisce quanti turni deve stare fermo il giocatore.
	 * @return Numero turni da rimanere fermo
	 */
	int getTurniFermo();
	
	/**
	 * Imposta quanti turni deve rimanere fermo il giocatore.
	 * @param turniFermo
	 */
	void setTurniFermo(int turniFermo);
	
	/**
	 * Restituisce la combinazione dei dadi ottenuta dal giocatore.
	 * @return Combinazione dei dadi
	 */
	int getCombinazioneDadi();
	
	/**
	 * Imposta la nuova combinazione dei dadi ottenuta dal giocatore.
	 * @param combinazioneDadi Nuova combinazione dei dadi
	 */
	void setCombinazioneDadi(int combinazioneDadi);
	
	/**
	 * Restituisce i dadi lanciati dal giocatore.
	 * @return Dadi utilizzati
	 */
	Dado[] getLancioDeiDadi();
	
	/**
	 * Imposta i nuovi lanci effettuati dal giocatore.
	 * @param dadi Dadi utilizzati
	 */
	void setLancioDeiDadi(Dado[] dadi);
	
	
}
