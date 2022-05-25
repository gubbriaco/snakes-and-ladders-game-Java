package gui.window.finestraprincipale;

import java.io.File;

import app.difficolta.Difficolta;
import app.modalita.Modalita;
import gui.factory.FinestraFactory;
import gui.factory.FinestraFactoryIF;
import gui.window.FinestraAstratta;
import gui.window.FinestraIF;

@SuppressWarnings({"serial", "unused"})
public abstract class FinestraPrincipaleAstratta extends FinestraAstratta {
	
	/**terminale che verra' inizializzato per la sessione di gioco in questione*/
	private FinestraFactoryIF terminaleFactory;
	private FinestraIF terminale;
	
	protected Modalita.Mod modalita; 
	protected int numeroGiocatori;
	//protected Difficolta difficolta;
	protected int[] dimensioniTabellone;
	protected int nrRighe, nrColonne;
	
	/**File in cui verra' salvata la nuova sessione di gioco o usato come 
	 * ripristino di una sessione di gioco salvata sul calcolatore*/
	private File file;
	
	
	/**
	 * Costruttore utile per inizializzare una nuova sessione di gioco.
	 * @param modalita Modalita' di gioco (Automatica o Manuale)
	 * @param numeroGiocatori Numero di giocatori che interaggiranno con la 
	 *        nuova sessione di gioco
	 * @param difficolta Difficolta' con cui verra' inizializzato il gioco.
	 */
	public FinestraPrincipaleAstratta(Modalita.Mod modalita, int numeroGiocatori, int[] dimensioniTabellone ) {
		this.modalita = modalita;
		this.numeroGiocatori = numeroGiocatori;
		this.dimensioniTabellone = dimensioniTabellone;
		nrRighe = dimensioniTabellone[0];
		nrColonne = dimensioniTabellone[1];
		 
		/**creo il terminale tramite il factory method*/
		terminaleFactory = new FinestraFactory();
		terminale = terminaleFactory.createFinestra("FinestraTerminaleAstratta", "", null, -1, dimensioniTabellone);
		/**inizializzo la finestra terminale tramite il template method*/
		terminale.inizializzaFinestra();
		
		/**Il file che conterra' i dati della nuova sessione di gioco verra' 
		 * salvato sul Desktop*/
		file = new File(System.getProperty("user.home") + "/Desktop");
		
	}
	
	/**Costruttore utile al ripristino di una sessione di gioco salvata sul 
	 * calcolatore*/
	public FinestraPrincipaleAstratta(File file) {
		/**Viene salvato il file per ripristinare la sessione di gioco 
		 * precedente*/
		this.file = file;
	}
	
	protected FinestraPrincipaleAstratta() {}
	
	/**
	 * Inizializza un nuovo tabellone o un tabellone gia' inizializzato in una 
	 * sessione di gioco salvata sul calcolatore ad un numero di righe 
	 * {@link FinestraPrincipaleAstratta#nrRighe} e ad un numero di colonne
	 * {@link FinestraPrincipaleAstratta#nrColonne}
	 * @param nrRighe Numero di righe del tabellone
	 * @param nrColonne Numero di colonne del tabellone
	 */
    protected abstract void inizializzaTabellone(int nrRighe, int nrColonne);
	
	

}
