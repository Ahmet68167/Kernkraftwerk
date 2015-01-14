package tpe.ueb5.ib04.model.kernkraftwerk;

/**
 * Legt ein Wasserelement mit einer bestimmten Temperatur an
 *
 */
public class Wasserelement {

	private int temperatur;
	
	/**
	 * Legt ein Wasserelement mit einer bestimmten Temperatur an
	 * 
	 */
	public Wasserelement() {
		this.temperatur = Wasserkreislauf.TEMPERATUR;
	}

	/**
	 * Gibt die Temperatur des Wasserelements zurueck
	 * 
	 * @return die Temperatur des Wasserelements
	 */
	public int getTemperatur() {
		return this.temperatur;
	}

	/**
	 * Setzt die Temperatur des Wasserelements
	 * 
	 * @param temperatur - Temperatur des Wasserelements
	 */
	public void setTemperatur(int temperatur) {
		this.temperatur = temperatur;
	}
	
}
