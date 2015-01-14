package tpe.ueb5.ib04;

public class Waermetauscher {
	
	public Waermetauscher() {

	}
	
	public int ausgleichen(Wasserelement element, int temperatur) {
		int ausgangsTemperatur = berechneTemperatur(element.getTemperatur(), temperatur);
		element.setTemperatur(ausgangsTemperatur);
		return ausgangsTemperatur;
	}
	
	private int berechneTemperatur(int temperatur1, int temperatur2) {
		return (temperatur1 + temperatur2) / 2;
	}
	
}
