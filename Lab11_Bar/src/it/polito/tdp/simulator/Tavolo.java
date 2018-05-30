package it.polito.tdp.simulator;

public class Tavolo {
	
	private int dimensione;
	private int timeout;
	
	public Tavolo(int dimensione, int timeout) {

		this.dimensione = dimensione;
		this.timeout = timeout;
	}
	
	public int getDimensione() {
		return dimensione;
	}
	
	public void setDimensione(int dimensione) {
		this.dimensione = dimensione;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	
	

}
