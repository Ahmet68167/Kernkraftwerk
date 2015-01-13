package tpe.ueb5.ib04;

public class Reaktor implements Runnable {

	private final int KRITISCHE_TEMPERATUR = 2878;
	private int erwaermungskoeffizient;
	private int abwaerme;
	private boolean kernschmelze;
	
	public Reaktor() {
		this.erwaermungskoeffizient = 42;
		this.abwaerme = 0;
		this.kernschmelze = false;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public int getErwaermungskoeffizient() {
		return this.erwaermungskoeffizient;
	}

	public void setErwaermungskoeffizient(int erwaermungskoeffizient) {
		this.erwaermungskoeffizient = erwaermungskoeffizient;
	}

	public int getAbwaerme() {
		return this.abwaerme;
	}

	public void setAbwaerme(int abwaerme) {
		this.abwaerme = abwaerme;
	}

	public boolean isKernschmelze() {
		return this.kernschmelze;
	}

	public void setKernschmelze(boolean kernschmelze) {
		this.kernschmelze = kernschmelze;
	}

}
