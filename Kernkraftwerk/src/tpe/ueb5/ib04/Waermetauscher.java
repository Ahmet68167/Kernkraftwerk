package tpe.ueb5.ib04;

public class Waermetauscher {
	
	private int reaktorTemperatur;
	private int flussTemperatur;
	private Wasserkreislauf wasserkreislauf;
	
	public Waermetauscher(Wasserkreislauf wasserkreislauf) {
		this.reaktorTemperatur = 10;
		this.flussTemperatur = 10;
		this.wasserkreislauf = wasserkreislauf;
	}
	
	public int ausgleichen() {
		return (this.wasserkreislauf.getKuehlkreislauf().element().getTemperatur() 
				+ this.reaktorTemperatur) / 2;
	}

	public int getReaktorTemperatur() {
		return this.reaktorTemperatur;
	}

	public void setReaktorTemperatur(int reaktorTemperatur) {
		this.reaktorTemperatur = reaktorTemperatur;
	}

	public int getFlussTemperatur() {
		return this.flussTemperatur;
	}

	public void setFlussTemperatur(int flussTemperatur) {
		this.flussTemperatur = flussTemperatur;
	}

	public Wasserkreislauf getWasserkreislauf() {
		return this.wasserkreislauf;
	}

	public void setWasserkreislauf(Wasserkreislauf wasserkreislauf) {
		this.wasserkreislauf = wasserkreislauf;
	}
	
}
