package tpe.ueb5.ib04.model.kernkraftwerk;

public class Wasserelement {

	private int temperatur;
	
	public Wasserelement() {
		this.temperatur = Wasserkreislauf.TEMPERATUR;
	}

	public int getTemperatur() {
		return this.temperatur;
	}

	public void setTemperatur(int temperatur) {
		this.temperatur = temperatur;
	}
	
}
