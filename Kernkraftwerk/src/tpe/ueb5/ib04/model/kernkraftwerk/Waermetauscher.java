package tpe.ueb5.ib04.model.kernkraftwerk;



/**
 * Legt einen Waermetauscher an, der die Temperatur zwischen einem Wasserelement und einer Temperatur
 * ausgleicht
 *
 */
public class Waermetauscher {
	
	/**
	 * Gleicht die Temperatur zwischen Wasserelement und der übergebenen Temperatur aus
	 * 
	 * @param element - Wasserelement, dessen Temperatur ausgeglichen werden soll
	 * @param temperatur - Temperatur mit der ausgeglichen werden soll
	 * @return
	 */
	public int ausgleichen(Wasserelement element, int temperatur) {
		int ausgangsTemperatur = berechneTemperatur(element.getTemperatur(), temperatur);
		element.setTemperatur(ausgangsTemperatur);
		return ausgangsTemperatur;
	}
	
	private int berechneTemperatur(int temperatur1, int temperatur2) {
		return (temperatur1 + temperatur2) / 2;
	}
	
}
