package tpe.ueb5.ib04.model.kernkraftwerk;

import tpe.ueb5.ib04.control.Kernkraftwerk;
import tpe.ueb5.ib04.view.Leitware;

/**
 * Legt einen Reaktor an, der Abwaerme erzeugt und auf eine Kernschmelze prueft
 *
 */
public class Reaktor implements Runnable {

	private final int KRITISCHE_TEMPERATUR = 2878;
	private int erwaermungskoeffizient;
	private int abwaerme;
	private boolean kernschmelze;

	
	/**
	 * Legt einen Reaktor mit dem Erwaermungskoeffizienten von 42° an
	 * 
	 */
	public Reaktor() {
		this(42);
	}
	
	/**
	 * Legt einen Reaktor mit dem angegeben Erwaermungskoeffizienten an
	 * 
	 * @param erwaermungskoeffizient - Erwaermungskoeffizient für den Reaktor
	 */
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
						System.exit(0);
					}

					Leitware.LOCK.wait(1000 / this.erwaermungskoeffizient);
					
				} catch (InterruptedException e) {
					System.out.println("Reaktor wurde angehalten.");
					Kernkraftwerk.running = false;
				}
			
			}
			
		}
		
	}

	/**
	 * Gibt den Erwaermungskoeffizienten des Reaktors zurueck
	 * 
	 * @return den Erwaermungskoeffizienten
	 */
	public int getErwaermungskoeffizient() {
		return this.erwaermungskoeffizient;
	}

	/**
	 * Setzt den Erwaermungskoeffizienten für den Reaktor
	 * 
	 * @param erwaermungskoeffizient - Erwaermungskoeffizient für den Reaktor
	 */
	public void setErwaermungskoeffizient(int erwaermungskoeffizient) {
		this.erwaermungskoeffizient = erwaermungskoeffizient;
	}

	/**
	 * Gibt die erzeugte Abwaerme zurueck
	 * 
	 * @return die erzeugte Abwaerme
	 */
	public int getAbwaerme() {
		return this.abwaerme;
	}

	/**
	 * Setzt die Abwaerme die durch den Reaktor erzeugt wird
	 * 
	 * @param abwaerme - Abwaerme die durch den Reaktor erzeugt wird
	 */
	public void setAbwaerme(int abwaerme) {
		this.abwaerme = abwaerme;
	}

	/**
	 * Gibt zurueck ob eine Kernschmleze stattgefunden hat
	 * 
	 * @return ob eine Kernschmelze stattgefunden hat
	 */
	public boolean isKernschmelze() {
		return this.kernschmelze;
	}

	/**
	 * Setzt den Wert für die Kernschmelze
	 * 
	 * @param kernschmelze - Kernschmelze 
	 */
	public void setKernschmelze(boolean kernschmelze) {
		this.kernschmelze = kernschmelze;
	}

}
