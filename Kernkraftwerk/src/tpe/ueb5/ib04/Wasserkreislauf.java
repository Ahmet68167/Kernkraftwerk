package tpe.ueb5.ib04;

import java.util.Deque;
import java.util.LinkedList;

public class Wasserkreislauf {

	private final int ANZAHL_ELEMENTE = 12;
	private Deque<Wasserelement> kuehlkreislauf = new LinkedList<>();
	
	public Wasserkreislauf() {
		fuelleKuehlkreislauf();
	}
	
	public void fuelleKuehlkreislauf() {
		for(int i = 0; i < ANZAHL_ELEMENTE; i++) {
			this.kuehlkreislauf.addLast(new Wasserelement());
		}
	}
	
	public void rotiere() {
		this.kuehlkreislauf.addLast(this.kuehlkreislauf.pop());
	}
	
	public Deque<Wasserelement> getKuehlkreislauf() {
		return this.kuehlkreislauf;
	}

	public void setKuehlkreislauf(Deque<Wasserelement> kuehlkreislauf) {
		this.kuehlkreislauf = kuehlkreislauf;
	}
	
}