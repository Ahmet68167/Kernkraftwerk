package tpe.ueb5.ib04.model.kernkraftwerk;

import tpe.ueb5.ib04.control.Kernkraftwerk;
import tpe.ueb5.ib04.view.Leitware;

/**
 * Stellt eine Pumpe dar, die die Temperatur zwischen Fluss und Reaktor ausgleichen und 
 * bei einer Kernschmelze die Pumpe herrunterfahren kann
 *
 */
public class Pumpe implements Runnable {

	private Reaktor reaktor;
	private Wasserkreislauf wasserkreislauf;
	private Waermetauscher waermetauscher;
	private double pumpenkoeffizient;
	private Leitware leitware;
	
	/**
	 * Legt eine Pumpe mit folgenden Eigenschaften an
	 * 
	 * @param reaktor - Reaktor, für den die Pumpe arbeitet
	 * @param wasserkreislauf - Wasserkreislauf mit dem die Pumpe arbeitet
	 * @param pumpenkoeffizient - Pumpenleistung
	 */
	public Pumpe(Reaktor reaktor, Wasserkreislauf wasserkreislauf, double pumpenkoeffizient) {
		this.reaktor = reaktor;
		this.wasserkreislauf = wasserkreislauf;
		this.waermetauscher = new Waermetauscher();
		this.pumpenkoeffizient = pumpenkoeffizient;
		this.leitware = new Leitware();
	}

	/**
	 * gleicht die Waerme zwischen Reaktor und Wasserkreislauf aus und rotiert den wasserkreislauf
	 * 
	 */
	public void pumpen() {
		gleicheWaermeAus();
		this.wasserkreislauf.rotiere();
	}
	
	private void gleicheWaermeAus() {
		// Gleicht die Temperatur des Reaktors mit der Temperatur des Kuehlwassers aus
		this.reaktor.setAbwaerme(this.waermetauscher.ausgleichen(
				this.wasserkreislauf.getKuehlkreislauf().peek(), this.reaktor.getAbwaerme()));
		
		// Setzt die Temperatur des Kuehlkreislaufes auf die Ausgangstemperatur
		this.wasserkreislauf.getKuehlkreislauf().peek().setTemperatur(
				this.waermetauscher.ausgleichen(this.wasserkreislauf.getKuehlkreislauf().peek(), 
						Wasserkreislauf.TEMPERATUR));
		
		this.leitware.setFlussTemperatur(this.wasserkreislauf.getKuehlkreislauf().peek().getTemperatur());
		this.leitware.setReaktorTemperatur(this.reaktor.getAbwaerme());
		//this.wasserkreislauf.getKuehlkreislauf().addLast(new Wasserelement());
	}
	
	@Override
	public void run() {
		
		while(Kernkraftwerk.running) {
			
			synchronized(Leitware.LOCK) {
			
				pumpen();
				this.leitware.ausgabe();
				
				if(this.reaktor.isKernschmelze())
					Kernkraftwerk.running = false;
				
				try {
					Leitware.LOCK.wait( (long)  (1000/this.pumpenkoeffizient));
				} catch (InterruptedException e) {
					System.out.println("Die Pumpe wurde angehalten.");
					Kernkraftwerk.running = false;
				}
			
			}
		
		}
		
	}
	
	/**
	 * Gibt den Reaktor mit der die Pumpe arbeitet zurueck
	 * 
	 * @return den Reaktor mit der die Pumpe arbeitet
	 */
	public Reaktor getReaktor() {
		return reaktor;
	}

	/**
	 * Setzt den Reaktor mit der die Pumpe arbeiten soll
	 * 
	 * @param reaktor - Reaktor mit der die Pumpe arbeiten soll
	 */
	public void setReaktor(Reaktor reaktor) {
		this.reaktor = reaktor;
	}

	/**
	 * Gibt den Wasserkreislauf zurueck mit der die Pumpe arbeitet
	 * 
	 * @return den Wasserkreislauf mit der die Pumpe arbeitet
	 */
	public Wasserkreislauf getWasserkreislauf() {
		return this.wasserkreislauf;
	}

	/**
	 * Setzt den Wasserkreislauf mit der die Pumpe arbeiten soll
	 * 
	 * @param wasserkreislauf - Wasserkreislauf mit der die Pumpe arbeiten soll
	 */
	public void setWasserkreislauf(Wasserkreislauf wasserkreislauf) {
		this.wasserkreislauf = wasserkreislauf;
	}

	/**
	 * Gibt die Pumpenleistung mit der die Pumpe arbeitet zurueck
	 * 
	 * @return die Pumpenleistung mit der die Pumpe arbeitet
	 */
	public double getPumpenkoeffizient() {
		return this.pumpenkoeffizient;
	}

	/**
	 * Setzt die Pumpenleistung mit der die Pumpe arbeiten soll
	 * 
	 * @param pumpenkoeffizient - Pumpenleistung mit der die Pumpe arbeiten soll
	 */
	public void setPumpenkoeffizient(int pumpenkoeffizient) {
		this.pumpenkoeffizient = pumpenkoeffizient;
	}
	
}
