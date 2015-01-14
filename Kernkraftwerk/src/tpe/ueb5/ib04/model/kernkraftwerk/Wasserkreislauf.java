package tpe.ueb5.ib04.model.kernkraftwerk;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Legt einen Wasserkreislauf an, der die Methoden reotieren und fuelleKuehlkreislauf hat
 *
 */
public class Wasserkreislauf {

	private final int ANZAHL_ELEMENTE = 12;
	public static int TEMPERATUR = 10;
	private Deque<Wasserelement> kuehlkreislauf = new LinkedList<>();
	
	/**
	 * Legt einen Wasserkreislauf an und fuellt ihn mit einer gegebenen Anzahl von Elementen
	 * 
	 */
	public Wasserkreislauf() {
		fuelleKuehlkreislauf();
	}
	
	/**
	 * fuellt den Kuehlkreislauf mit Wasserelementen
	 * 
	 */
	public void fuelleKuehlkreislauf() {
		for(int i = 0; i < ANZAHL_ELEMENTE; i++) {
			this.kuehlkreislauf.addLast(new Wasserelement());
		}
	}
	
	/**
	 * rotiert den Kuehlkreislauf um eine position weiter
	 * 
	 */
	public void rotiere() {
		this.kuehlkreislauf.addLast(this.kuehlkreislauf.pop());
	}
	
	/**
	 * Gibt den Kuehlkreislauf zurueck
	 * 
	 * @return den Kuehlkreislauf
	 */
	public Deque<Wasserelement> getKuehlkreislauf() {
		return this.kuehlkreislauf;
	}

	/**
	 * Setzt den Kuehlkreislauf
	 * 
	 * @param kuehlkreislauf - Kuehlkreislauf
	 */
	public void setKuehlkreislauf(Deque<Wasserelement> kuehlkreislauf) {
		this.kuehlkreislauf = kuehlkreislauf;
	}
	
}