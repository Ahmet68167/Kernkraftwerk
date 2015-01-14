package tpe.ueb5.ib04.model.kernkraftwerk;

import tpe.ueb5.ib04.control.Kernkraftwerk;
import tpe.ueb5.ib04.view.Leitware;

public class Pumpe implements Runnable {

	private Reaktor reaktor;
	private Wasserkreislauf wasserkreislauf;
	private Waermetauscher waermetauscher;
	private double pumpenkoeffizient;
	private Leitware leitware;
	
	public Pumpe(Reaktor reaktor, Wasserkreislauf wasserkreislauf, double pumpenkoeffizient) {
		this.reaktor = reaktor;
		this.wasserkreislauf = wasserkreislauf;
		this.waermetauscher = new Waermetauscher();
		this.pumpenkoeffizient = pumpenkoeffizient;
		this.leitware = new Leitware();
	}

	public void pumpen() {
		gleicheWaermeAus();
		this.wasserkreislauf.rotiere();
	}
	
	private void gleicheWaermeAus() {
		this.reaktor.setAbwaerme(this.waermetauscher.ausgleichen(
				this.wasserkreislauf.getKuehlkreislauf().peek(), this.reaktor.getAbwaerme()));
		
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
	
	public Reaktor getReaktor() {
		return reaktor;
	}

	public void setReaktor(Reaktor reaktor) {
		this.reaktor = reaktor;
	}

	public Wasserkreislauf getWasserkreislauf() {
		return this.wasserkreislauf;
	}

	public void setWasserkreislauf(Wasserkreislauf wasserkreislauf) {
		this.wasserkreislauf = wasserkreislauf;
	}

	public double getPumpenkoeffizient() {
		return this.pumpenkoeffizient;
	}

	public void setPumpenkoeffizient(int pumpenkoeffizient) {
		this.pumpenkoeffizient = pumpenkoeffizient;
	}
	
}
