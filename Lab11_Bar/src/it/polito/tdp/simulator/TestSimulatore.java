package it.polito.tdp.simulator;

public class TestSimulatore {

	public static void main(String[] args) {
		
		System.out.println("CIAO\n");
		
		Simulatore sim = new Simulatore();
		
		sim.init();
		sim.run();
		
		System.out.println("Clienti totali = "+sim.getNumero_totale_clienti());
		System.out.println("Clienti soddisfatti = "+sim.getNumero_clienti_soddisfatti());
		System.out.println("Clienti insoddisfatti = "+sim.getNumero_clienti_insoddisfatti());
		System.out.println("Clienti bancone = "+sim.getNumero_clienti_bancone());
		System.out.println("Clienti tavoli totali = "+sim.getN_tavoli_totali());
		System.out.println("Clienti tavoli 4 = "+sim.getN_tavoli_4());
		System.out.println("Clienti tavoli 6 = "+sim.getN_tavoli_6());
		System.out.println("Clienti tavoli 8 = "+sim.getN_tavoli_8());
		System.out.println("Clienti tavoli 10= "+sim.getN_tavoli_10());

	}

}
