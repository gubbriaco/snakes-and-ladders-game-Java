package app.tabellone.cella.concrete.special;

import java.awt.Color;

import app.tabellone.cella.CasellaAstratta;

@SuppressWarnings("serial")
public class CasellaSerpente extends CasellaAstratta {

	public CasellaSerpente(int numeroCella) {
		super(numeroCella);
	}

	@Override public void draw() {
		this.setOpaque(true);
		this.setBackground(new Color(102,51,0));
		this.setForeground(Color.BLACK.darker());
	}

}
