package it.polito.tdp.simulator;

import java.util.Random;

public class Event implements Comparable<Event> {
	
	int time;
	int num_persone;
	int minuti_permanenza;
	float tolleranza;
	EventType tipo;
	Tavolo tavolo;

	public Event(int time, int num_persone, int minuti_permanenza, float tolleranza,EventType tipo,Tavolo tavolo) {

		this.time = time;
		this.num_persone = num_persone;
		this.minuti_permanenza = minuti_permanenza;
		this.tolleranza = tolleranza;
		this.tipo = tipo;
		this.tavolo = tavolo;
		
	}
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public int getNum_persone() {
		return num_persone;
	}
	
	public void setNum_persone(int num_persone) {
		this.num_persone = num_persone;
	}
	public int getMinuti_permanenza() {
		return minuti_permanenza;
	}
	public void setMinuti_permanenza(int minuti_permanenza) {
		this.minuti_permanenza = minuti_permanenza;
	}
	public float getTolleranza() {
		return tolleranza;
	}
	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}
	
	public EventType getTipo() {
		return tipo;
	}

	public void setTipo(EventType tipo) {
		this.tipo = tipo;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

	public boolean controlloTime() {
		int random = (int) (Math.random()*10);
		
		if(this.time >= 1 && this.time <= 10) {
			this.setTime(random);
			return true;
		}
		
		return false;
	}
	

	public boolean controlloNum_persone() {
		int random = (int) (Math.random()*10);
		
		if(this.num_persone >= 1 && this.num_persone <= 10) {
			this.setNum_persone(random);
			return true;
		}
		
		return false;
	}
	

	public boolean controlloMinuti_permanenza() {
		Random rand = new Random();
		int random = rand.nextInt((120 - 60) + 1) + 60;

		if(random >= 60 && random <= 120) {
			this.setMinuti_permanenza(random);
			return true;
		}
		
		return false;
	}
	
	public boolean controlloTolleranza() {
		float random = (float) ((Math.random()*10) - 0.1);

		if(random >= 0.0 && random <= 0.9) {
			this.setTolleranza(random);
			return true;
		}
		
		return false;
	}

	@Override
	public int compareTo(Event arg0) {
		if(arg0.getTime() > this.time)
			return -1;
		else if(arg0.getTime() < this.time)
			return 1;
		
		if(arg0.getTime()==this.time) {
			if(arg0.num_persone > this.num_persone) {
				return -1;
			}else if(arg0.num_persone > this.num_persone) {
				return 1;
			}
		}
		return 0;
		
	}

	@Override
	public String toString() {
		return "Event [time=" + time + ", num_persone=" + num_persone + ", minuti_permanenza=" + minuti_permanenza
				+ ", tolleranza=" + tolleranza + ", tipo=" + tipo + ", tavolo=" + tavolo + "]";
	}
	
	

}
