package tpe.ueb5.ib04.control;

import tpe.ueb5.ib04.model.kernkraftwerk.Pumpe;
import tpe.ueb5.ib04.model.kernkraftwerk.Reaktor;
import tpe.ueb5.ib04.model.kernkraftwerk.Wasserkreislauf;

public class Kernkraftwerk implements Runnable {
	
	private Reaktor reaktor;
	private Wasserkreislauf wasserkreislauf;
	private Pumpe pumpe;
	public static volatile boolean running = true;
	
	public Kernkraftwerk(double pumpleistung) {
		this(pumpleistung, 10, 42);
	}
	
	public Kernkraftwerk(double pumpleistung, int flusstemperatur) {
		this(pumpleistung, flusstemperatur, 42);
	}
	
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
