package tpe.ueb5.ib04.view;

import tpe.ueb5.ib04.model.kernkraftwerk.Wasserkreislauf;

public class Leitware {

	public static final Object LOCK = new Object();
	private int reaktorTemperatur;
	private int flussTemperatur;
	
	public Leitware() {
		this.reaktorTemperatur = 10;
		this.flussTemperatur = Wasserkreislauf.TEMPERATUR;
	}
	
	public void ausgabe() {
		System.out.println("Temperatur Reaktor: " + this.reaktorTemperatur 
				+ ", Temperatur Rueckfluss in Rhein " + this.flussTemperatur);
	}

	public int getReaktorTemperatur() {
		return reaktorTemperatur;
	}

	public void setReaktorTemperatur(int reaktorTemperatur) {
		this.reaktorTemperatur = reaktorTemperatur;
	}

	public int getFlussTemperatur() {
		return flussTemperatur;
	}

	public void setFlussTemperatur(int flussTemperatur) {
		this.flussTemperatur = flussTemperatur;
	}
		
}
