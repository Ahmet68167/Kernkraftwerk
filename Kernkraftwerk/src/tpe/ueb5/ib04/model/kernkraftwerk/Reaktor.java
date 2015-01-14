package tpe.ueb5.ib04.model.kernkraftwerk;

import tpe.ueb5.ib04.control.Kernkraftwerk;
import tpe.ueb5.ib04.view.Leitware;

public class Reaktor implements Runnable {

	private final int KRITISCHE_TEMPERATUR = 2878;
	private int erwaermungskoeffizient;
	private int abwaerme;
	private boolean kernschmelze;

	
	public Reaktor() {
		this(42);
	}
	
	public Reaktor(int erwaermungskoeffizient) {
		this.erwaermungskoeffizient = erwaermungskoeffizient;
		this.abwaerme = 10;
		this.kernschmelze = false;
	}
	
	@Override
	public void run() {
		
		while(Kernkraftwerk.running) {
			
			synchronized(Leitware.LOCK) {
			
				try {
				
					this.abwaerme += 1;
				
					if(this.abwaerme >= KRITISCHE_TEMPERATUR) {
						System.out.println("Es hat eine Kernschmelze stattgefunden.");
						Kernkraftwerk.running = false;
					}

					Leitware.LOCK.wait(1000 / this.erwaermungskoeffizient);
					
				} catch (InterruptedException e) {
					System.out.println("Reaktor wurde angehalten.");
					Kernkraftwerk.running = false;
				}
			
			}
			
		}
		
	}

	public int getErwaermungskoeffizient() {
		return this.erwaermungskoeffizient;
	}

	public void setErwaermungskoeffizient(int erwaermungskoeffizient) {
		this.erwaermungskoeffizient = erwaermungskoeffizient;
	}

	public int getAbwaerme() {
		return this.abwaerme;
	}

	public void setAbwaerme(int abwaerme) {
		this.abwaerme = abwaerme;
	}

	public boolean isKernschmelze() {
		return this.kernschmelze;
	}

	public void setKernschmelze(boolean kernschmelze) {
		this.kernschmelze = kernschmelze;
	}

}
