package tpe.ueb5.ib04;

public class Reaktor implements Runnable {

	private int erwaermungskoeffizient;
	
	public Reaktor(int erwaermungskoeffizient) {
		this.setErwaermungskoeffizient(erwaermungskoeffizient);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public int getErwaermungskoeffizient() {
		return erwaermungskoeffizient;
	}

	public void setErwaermungskoeffizient(int erwaermungskoeffizient) {
		this.erwaermungskoeffizient = erwaermungskoeffizient;
	}

}
