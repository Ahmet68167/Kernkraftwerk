package tpe.ueb5.ib04;

public class Kernkraftwerk {
	
	public static void main(String[] args) {
		
		Reaktor reaktor = new Reaktor();
		Wasserkreislauf kreislauf = new Wasserkreislauf();
		Pumpe pumpe = new Pumpe(reaktor, kreislauf, 2);
		
		Thread a = new Thread(reaktor);
		Thread b = new Thread(pumpe);
		
		a.start();
		b.start();
		
	}
	
}
