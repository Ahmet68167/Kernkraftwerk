package tpe.ueb5.ib04;

import java.util.Deque;
import java.util.LinkedList;

public class Wasserkreislauf {

	private Deque<Wasserelement> kuehlkreislauf = new LinkedList<>();
	
	public Wasserkreislauf() {
		
	}

	public void rotiere() {
		this.kuehlkreislauf.addLast(this.kuehlkreislauf.pop());
	}
	
	public Deque<Wasserelement> getKuehlkreislauf() {
		return kuehlkreislauf;
	}

	public void setKuehlkreislauf(Deque<Wasserelement> kuehlkreislauf) {
		this.kuehlkreislauf = kuehlkreislauf;
	}
	
	
}
