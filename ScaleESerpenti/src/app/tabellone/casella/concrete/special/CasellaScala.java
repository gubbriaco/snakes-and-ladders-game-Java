package app.tabellone.casella.concrete.special;

import java.awt.Color;

import app.tabellone.casella.CasellaAstratta;

@SuppressWarnings("serial")
public class CasellaScala extends CasellaAstratta {

	public CasellaScala(int numeroCella) {
		super(numeroCella);
	}

	@Override public void draw() {
		this.setOpaque(true);
		this.setBackground(Color.BLUE.brighter());
		this.setForeground(Color.BLACK.darker());
	}

}