package tpe.ueb5.ib04.control;

public class Simulation {

	public static void main(String[] args) {
		
		
		Thread a = new Thread(new Kernkraftwerk(1));
		a.start();
		
		/*
		// Kernschmelze
		Thread b = new Thread(new Kernkraftwerk(1, 2700, 350));
		b.start();
		
		/*
		Thread c = new Thread(new Kernkraftwerk(2));
		c.start();
		
		
		Thread d = new Thread(new Kernkraftwerk(1, 10, 100));
		d.start();
		*/
		
	}

}
