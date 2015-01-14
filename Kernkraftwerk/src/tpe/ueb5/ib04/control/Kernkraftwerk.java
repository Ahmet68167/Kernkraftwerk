package tpe.ueb5.ib04.control;

import tpe.ueb5.ib04.model.kernkraftwerk.Pumpe;
import tpe.ueb5.ib04.model.kernkraftwerk.Reaktor;
import tpe.ueb5.ib04.model.kernkraftwerk.Wasserkreislauf;

/**
 * Verwaltet die einzelnen Bestandteile eines Kernkraftwerkes und simuliert somit ein Kernkraftwerk.
 * Implementiert das Interface Runnable damit man sie als Thread ausführen kann.
 *
 */
public class Kernkraftwerk implements Runnable {
	
	private Reaktor reaktor;
	private Wasserkreislauf wasserkreislauf;
	private Pumpe pumpe;
	public static volatile boolean running = true;
	
	/**
	 * Legt ein Kernkraftwerk mit der angegebenen Pumpleistung, einer Flusstemperatur von 10°
	 * und mit dem Erwaermungskoeffizienten 42° an
	 * 
	 * @param pumpleistung - Die Leistung, mit der die Pumpe arbeiten soll
	 */
	public Kernkraftwerk(double pumpleistung) {
		this(pumpleistung, 10, 42);
	}
	
	/**
	 * Legt ein Kernkraftwerk mit der angegebenen Pumpleistung, Flusstemperatur
	 * und mit dem Erwaermungskoeffizienten 42° an
	 * 
	 * @param pumpleistung - Die Leistung, mit der die Pumpe arbeiten soll
	 * @param flusstemperatur - Die Temperatur des Flusses
	 */
	public Kernkraftwerk(double pumpleistung, int flusstemperatur) {
		this(pumpleistung, flusstemperatur, 42);
	}
	
	/**
	 * Legt ein Kernkraftwerk mit der angegebenen Pumpleistung, Flusstemperatur
	 * und Erwaermungskoeffizienten an
	 * 
	 * @param pumpleistung - Die Leistung, mit der die Pumpe arbeiten soll
	 * @param flusstemperatur - Die Temperatur des Flusses
	 * @param erwaermungskoeffizient - Der Erwaermungskoeffizient für den Reaktor
	 */
	public Kernkraftwerk(double pumpleistung, int flusstemperatur, int erwaermungskoeffizient) {
		Wasserkreislauf.TEMPERATUR = flusstemperatur;
		this.reaktor = new Reaktor(erwaermungskoeffizient);
		this.wasserkreislauf = new Wasserkreislauf();
		this.pumpe = new Pumpe(this.reaktor, this.wasserkreislauf, pumpleistung);
	}
	
	@Override
	public void run() {
		Thread r = new Thread(this.reaktor);
		Thread p = new Thread(this.pumpe);
		
		r.start();
		p.start();
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		r.interrupt();
		p.interrupt();
		
	}
	
}
