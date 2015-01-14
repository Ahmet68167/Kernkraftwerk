package tpe.ueb5.ib04;

public class Reaktor implements Runnable {

	private final int KRITISCHE_TEMPERATUR = 2878;
	private int erwaermungskoeffizient;
	private int abwaerme;
	private boolean kernschmelze;
	private boolean running;
	
	public Reaktor() {
		this.erwaermungskoeffizient = 42;
		this.abwaerme = 10;
		this.kernschmelze = false;
		this.running = true;
	}
	
	@Override
	public void run() {
		
		while(this.running) {
			
			synchronized(Leitware.LOCK) {
			
				try {
				
					this.abwaerme += 1;
				
					if(this.abwaerme >= KRITISCHE_TEMPERATUR) {
						System.out.println("Kernschmelze");
						this.kernschmelze = true;
						this.running = false;
					}
				
					Leitware.LOCK.wait(1000 / this.erwaermungskoeffizient);
				
				} catch (InterruptedException e) {
					System.out.println("Reaktor wurde angehalten");
					this.running = false;
					e.printStackTrace();
				}
			
			}
			
		}
		
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
	
	public boolean getRunning() {
		return this.running;
	}
	
	public void setRunning(boolean running) {
		this.running = running;
	}

}
