package tpe.ueb5.ib04;

public class Pumpe implements Runnable {

	private Wasserkreislauf wasserkreislauf;
	private int pumpenkoeffizient;
	
	public Pumpe(Wasserkreislauf wasserkreislauf, int pumpenkoeffizient) {
		this.setWasserkreislauf(wasserkreislauf);
		this.setPumpenkoeffizient(pumpenkoeffizient);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public Wasserkreislauf getWasserkreislauf() {
		return wasserkreislauf;
	}

	public void setWasserkreislauf(Wasserkreislauf wasserkreislauf) {
		this.wasserkreislauf = wasserkreislauf;
	}

	public int getPumpenkoeffizient() {
		return pumpenkoeffizient;
	}

	public void setPumpenkoeffizient(int pumpenkoeffizient) {
		this.pumpenkoeffizient = pumpenkoeffizient;
	}
	
}
