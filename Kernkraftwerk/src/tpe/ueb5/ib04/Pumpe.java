package tpe.ueb5.ib04;

public class Pumpe implements Runnable {

	private Wasserkreislauf wasserkreislauf;
	private int pumpenkoeffizient;
	
	public Pumpe(Wasserkreislauf wasserkreislauf, int pumpenkoeffizient) {
		this.wasserkreislauf = wasserkreislauf;
		this.pumpenkoeffizient = pumpenkoeffizient;
	}

	@Override
	public void run() {
		
		while(true) {
			this.wasserkreislauf.rotiere();
		
			try {
				this.wait(1000/this.pumpenkoeffizient);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
		}
		
	}
	
	public Wasserkreislauf getWasserkreislauf() {
		return this.wasserkreislauf;
	}

	public void setWasserkreislauf(Wasserkreislauf wasserkreislauf) {
		this.wasserkreislauf = wasserkreislauf;
	}

	public int getPumpenkoeffizient() {
		return this.pumpenkoeffizient;
	}

	public void setPumpenkoeffizient(int pumpenkoeffizient) {
		this.pumpenkoeffizient = pumpenkoeffizient;
	}
	
}
