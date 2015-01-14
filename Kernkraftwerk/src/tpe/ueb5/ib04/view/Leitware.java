package tpe.ueb5.ib04.view;

import tpe.ueb5.ib04.model.kernkraftwerk.Wasserkreislauf;

/**
 * Legt eine Leitware an, um die Temperaturen des Kuehlkreislaufes und des Reaktors zu messen und
 * diese auszugeben
 *
 */
public class Leitware {

	public static final Object LOCK = new Object();
	private int reaktorTemperatur;
	private int flussTemperatur;
	
	/**
	 * Legt eine Leitware an mit der ReaktorTemperatur 10° und der vorgegebenen Flusstemperatur
	 * 
	 */
	public Leitware() {
		this.reaktorTemperatur = 10;
		this.flussTemperatur = Wasserkreislauf.TEMPERATUR;
	}
	
	/**
	 * Gibt die Reaktortemperatur und die Flusstemperatur in folgender Form aus:
	 * "Temperatur Reaktor: 10°, Temperatur Rueckfluss in Rhein 10°"
	 * 
	 */
	public void ausgabe() {
		System.out.println("Temperatur Reaktor: " + this.reaktorTemperatur 
				+ ", Temperatur Rueckfluss in Rhein " + this.flussTemperatur);
	}

	/**
	 * Gibt die Temperatur des Reaktors zurueck
	 * 
	 * @return gibt die Temperatur des Reaktors zurueck
	 */
	public int getReaktorTemperatur() {
		return reaktorTemperatur;
	}

	/**
	 * Setzt die Temperatur des Reaktors
	 * 
	 * @param reaktorTemperatur - Temperatur des Reaktors
	 */
	public void setReaktorTemperatur(int reaktorTemperatur) {
		this.reaktorTemperatur = reaktorTemperatur;
	}

	/**
	 * Gibt die Temperatur des in den Fluss fließenden Kuehlkreislaufes zurueck
	 * 
	 * @return die Temperatur des in den Fluss fließenden Kuehlkreislaufes 
	 */
	public int getFlussTemperatur() {
		return flussTemperatur;
	}

	/**
	 * Setzt die Temperatur des in den Fluss fließenden Kuehlkreislaufes
	 * 
	 * @param flussTemperatur - Temperatur des in den Fluss fließenden Kuehlkreislaufes
	 */
	public void setFlussTemperatur(int flussTemperatur) {
		this.flussTemperatur = flussTemperatur;
	}
		
}
