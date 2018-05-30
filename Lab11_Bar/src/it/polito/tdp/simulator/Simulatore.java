package it.polito.tdp.simulator;

import java.util.PriorityQueue;

public class Simulatore {
	
	private int numero_totale_clienti;
	private int numero_clienti_soddisfatti;
	private int numero_clienti_insoddisfatti;
	private int numero_clienti_bancone;
	
	private int n_tavoli_totali = 15;
	private int n_tavoli_10 = 2;
	private int n_tavoli_8 = 4;
	private int n_tavoli_6 = 4;
	private int n_tavoli_4 = 5;
	
	private int attesa4;
	private int attesa6;
	private int attesa8;
	private int attesa10;
	private int attesa;
	
	PriorityQueue<Event> codaArrivo = new PriorityQueue<Event>();
	
	public void init() {
		
		numero_totale_clienti = 0;
	    numero_clienti_soddisfatti = 0;
	    numero_clienti_insoddisfatti = 0;
	    numero_clienti_bancone = 0;
	    attesa4 = 0;
	    attesa6 = 0;
	    attesa8 = 0;
	    attesa10 = 0;
	    attesa = 0;
	    
	    while(codaArrivo.size() != 2000) {
	    	
	    	Event e = new Event(0,0,0,0,EventType.ARRIVO,null);
	    	if(e.controlloMinuti_permanenza() && e.controlloNum_persone() &&
	    	e.controlloTime() && e.controlloTolleranza() ) {
	    	codaArrivo.add(e);
	    	}
	    	
	    }
		
	    
		
	}
	
	public void run() {
		
		Event e;
		System.out.println(codaArrivo.size());
		while((e = codaArrivo.poll()) != null){
			
			processEvent(e);
			
		}
		
	}
	
	private void processEvent(Event e) {
		
		switch(e.getTipo()) {
		case ARRIVO:
			Event e2 = new Event(e.getTime()+attesa, e.getNum_persone(), e.getMinuti_permanenza(), e.getTolleranza(), EventType.ASSEGNATAVOLO,null);
			codaArrivo.add(e2);
			break;
		case ASSEGNATAVOLO:
			if(e.getNum_persone() <=4 && this.n_tavoli_4 > 0) {
				Tavolo t = new Tavolo(4,e.getMinuti_permanenza());
				Event e3 = new Event(e.getTime()+e.getMinuti_permanenza(), e.getNum_persone(), e.getMinuti_permanenza(), e.getTolleranza(), EventType.USCITA,t);
				codaArrivo.add(e3);
				this.numero_totale_clienti += e.getNum_persone();
				this.numero_clienti_soddisfatti += e.getNum_persone();
				this.n_tavoli_4--;
				this.n_tavoli_totali--;
				attesa4 += e.getMinuti_permanenza();
				attesa += e.getMinuti_permanenza();
				break;
			}else if(e.getNum_persone() <=6 && this.n_tavoli_6 > 0) {
				Tavolo t = new Tavolo(6,e.getMinuti_permanenza());
				Event e3 = new Event(e.getTime()+e.getMinuti_permanenza(), e.getNum_persone(), e.getMinuti_permanenza(), e.getTolleranza(), EventType.USCITA,t);
				codaArrivo.add(e3);
				this.numero_totale_clienti += e.getNum_persone();
				this.numero_clienti_soddisfatti += e.getNum_persone();
				this.n_tavoli_6--;
				this.n_tavoli_totali--;
				attesa6 += e.getMinuti_permanenza();
				attesa += e.getMinuti_permanenza();
				break;
			}else if(e.getNum_persone() <=8 && this.n_tavoli_8 > 0) {
				Tavolo t = new Tavolo(8,e.getMinuti_permanenza());
				Event e3 = new Event(e.getTime()+e.getMinuti_permanenza(), e.getNum_persone(), e.getMinuti_permanenza(), e.getTolleranza(), EventType.USCITA,t);
				codaArrivo.add(e3);
				this.numero_totale_clienti += e.getNum_persone();
				this.numero_clienti_soddisfatti += e.getNum_persone();
				this.n_tavoli_8--;
				this.n_tavoli_totali--;
				attesa8 += e.getMinuti_permanenza();
				attesa += e.getMinuti_permanenza();
				break;
			}else if(e.getNum_persone() <=10 && this.n_tavoli_10 > 0) {
				Tavolo t = new Tavolo(10,e.getMinuti_permanenza());
				Event e3 = new Event(e.getTime()+e.getMinuti_permanenza(), e.getNum_persone(), e.getMinuti_permanenza(), e.getTolleranza(), EventType.USCITA,t);
				codaArrivo.add(e3);
				this.numero_totale_clienti += e.getNum_persone();
				this.numero_clienti_soddisfatti += e.getNum_persone();
				this.n_tavoli_10--;
				this.n_tavoli_totali--;
				attesa10 += e.getMinuti_permanenza();
				attesa += e.getMinuti_permanenza();
				break;
			}
			if(e.getTolleranza() > 0.5) {
				Event e3 = new Event(e.getTime()+e.getMinuti_permanenza(), e.getNum_persone(), e.getMinuti_permanenza(), e.getTolleranza(), EventType.USCITA,null);
				codaArrivo.add(e3);
				this.numero_totale_clienti += e.getNum_persone();
				this.numero_clienti_soddisfatti += e.getNum_persone();
				this.numero_clienti_bancone += e.getNum_persone();
                break;
			}
				this.numero_totale_clienti += e.getNum_persone();
				this.numero_clienti_insoddisfatti += e.getNum_persone();
			    break;
			    
		case USCITA:	
			e.setTipo(EventType.FINE);
			if(e.getTavolo().getDimensione() == 4) {
				this.n_tavoli_4++;
				this.n_tavoli_totali++;
				this.attesa4 = 0;
			}
			else if(e.getTavolo().getDimensione() == 6) {
				this.n_tavoli_6++;
				this.n_tavoli_totali++;
				this.attesa6 = 0;
			}
			else if(e.getTavolo().getDimensione() == 8) {
				this.n_tavoli_8++;
				this.n_tavoli_totali++;
				this.attesa8 = 0;
			}
			else if(e.getTavolo().getDimensione() == 10) {
				this.n_tavoli_10++;
				this.n_tavoli_totali++;
				this.attesa10 = 0;
			}
			break;
			
		}	
	}

	public int getNumero_totale_clienti() {
		return numero_totale_clienti;
	}

	public int getNumero_clienti_soddisfatti() {
		return numero_clienti_soddisfatti;
	}

	public int getNumero_clienti_insoddisfatti() {
		return numero_clienti_insoddisfatti;
	}

	public int getNumero_clienti_bancone() {
		return numero_clienti_bancone;
	}

	public int getN_tavoli_totali() {
		return n_tavoli_totali;
	}

	public int getN_tavoli_10() {
		return n_tavoli_10;
	}

	public int getN_tavoli_8() {
		return n_tavoli_8;
	}

	public int getN_tavoli_6() {
		return n_tavoli_6;
	}

	public int getN_tavoli_4() {
		return n_tavoli_4;
	}
	
	
}
