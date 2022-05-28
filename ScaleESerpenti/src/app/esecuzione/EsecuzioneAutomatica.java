package app.esecuzione;

import java.util.LinkedList;

import app.esecuzione.dadi.Dado;
import app.esecuzione.giocatore.Giocatore;
import app.modalita.Modalita.Mod;
import app.tabellone.Tabellone;
import gui.window.finestraprincipale.FinestraPrincipaleAstratta;
import gui.window.finestraterminale.concrete.FinestraTerminale;

public class EsecuzioneAutomatica extends Esecuzione {

	public EsecuzioneAutomatica(LinkedList<Giocatore> giocatoriInGioco, Tabellone tabellone, 
				           Mod modalita, FinestraPrincipaleAstratta finestraPrincipale, 
			               FinestraTerminale terminale) {
		super(giocatoriInGioco, tabellone, modalita, finestraPrincipale, terminale);
	}

	
	@Override protected void esegui() {
		
		boolean victory = false;
		
		while( !victory ) {

			System.out.println(finestraPrincipale.getTurnoCorrente());
			Dado dado1, dado2;
			int combinazioneDadi = 0, lancio1, lancio2, nuovaCasella, turno=1;
			Giocatore giocatoreCorrente;
			
			for(int i=0;i<giocatoriInGioco.size();++i) {
				
				giocatoreCorrente = giocatoriInGioco.get(i);
				dado1 = new Dado(6); dado2 = new Dado(6);
				
				lancio1 = dado1.lancio();
				lancio2 = dado2.lancio();
				combinazioneDadi = lancio1 + lancio2;
				
				/** la pedina si muove verso la nuova casella */
				nuovaCasella = giocatoreCorrente.movementRequest(
						giocatoreCorrente.getCasellaCorrente(), combinazioneDadi);
				finestraPrincipale.repaint();
				
				terminale.espandiAttivita( giocatoreCorrente.toString() + 
									" ha lanciato i dadi: " + lancio1 + " " + lancio2);
				System.out.println(giocatoreCorrente.toString() + 
						" ha lanciato i dadi: " + lancio1 + " " + lancio2);
				giocatoreCorrente.setCasellaCorrente(nuovaCasella);
				
				terminale.espandiAttivita(giocatoreCorrente.toString() + " e' nella casella " 
										 + nuovaCasella );
				System.out.println(giocatoreCorrente.toString() + " e' nella casella " 
						 + nuovaCasella);
				terminale.repaintTerminale();
				
				finestraPrincipale.setGiocatoreCorrente(giocatoreCorrente.toString());
				finestraPrincipale.setDadi( "" +combinazioneDadi );
				
				if(nuovaCasella == finestraPrincipale.getMatriceTabellone()[0][0].getNumeroCasella()) {
					turno = turno+1;
					finestraPrincipale.setNuovoTurno(turno);
					victory = true;
				}

			}
			
			if(victory)
				break;
			
			turno = turno+1;
			finestraPrincipale.setNuovoTurno(turno);
			
			terminale.espandiAttivita("--- " + "Turno " + turno + " ---");
			terminale.repaintTerminale();

		}
	}


}
