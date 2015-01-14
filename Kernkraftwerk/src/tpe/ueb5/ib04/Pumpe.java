package tpe.ueb5.ib04;

public class Pumpe implements Runnable {

	private Reaktor reaktor;
	private Wasserkreislauf wasserkreislauf;
	private Waermetauscher waermetauscher;
	private int pumpenkoeffizient;
	
	public Pumpe(Reaktor reaktor, Wasserkreislauf wasserkreislauf, int pumpenkoeffizient) {
		this.reaktor = reaktor;
		this.wasserkreislauf = wasserkreislauf;
		this.waermetauscher = new Waermetauscher();
		this.pumpenkoeffizient = pumpenkoeffizient;
	}

	private void pumpen() {
		gleicheWaermeAus();
		//this.wasserkreislauf.rotiere();
	}
	
	private void gleicheWaermeAus() {
		this.reaktor.setAbwaerme(this.waermetauscher.ausgleichen(
				this.wasserkreislauf.getKuehlkreislauf().peek(), this.reaktor.getAbwaerme()));
		this.wasserkreislauf.getKuehlkreislauf().addLast(new Wasserelement());
	}
	
	private String status() {
		return "Temperatur Reaktor: " + this.reaktor.getAbwaerme() 
				+ ", Temperatur Rueckfluss in Rhein " 
				+ this.wasserkreislauf.getKuehlkreislauf().pop().getTemperatur();
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			synchronized(Leitware.LOCK) {
			
				pumpen();
				System.out.println(status());
				this.wasserkreislauf.rotiere();
				
				try {
					Leitware.LOCK.wait(1000/this.pumpenkoeffizient);
				} catch (InterruptedException e) {
					System.out.println("Die Pumpe wurde angehalten.");
					e.printStackTrace();
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

	public int getPumpenkoeffizient() {
		return this.pumpenkoeffizient;
	}

	public void setPumpenkoeffizient(int pumpenkoeffizient) {
		this.pumpenkoeffizient = pumpenkoeffizient;
	}
	
}
