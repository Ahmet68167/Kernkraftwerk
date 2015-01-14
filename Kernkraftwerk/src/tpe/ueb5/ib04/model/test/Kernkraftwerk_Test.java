package tpe.ueb5.ib04.model.test;

import static org.junit.Assert.*;

import org.junit.Test;

import tpe.ueb5.ib04.control.Kernkraftwerk;
import tpe.ueb5.ib04.model.kernkraftwerk.Pumpe;
import tpe.ueb5.ib04.model.kernkraftwerk.Reaktor;
import tpe.ueb5.ib04.model.kernkraftwerk.Waermetauscher;
import tpe.ueb5.ib04.model.kernkraftwerk.Wasserelement;
import tpe.ueb5.ib04.model.kernkraftwerk.Wasserkreislauf;

public class Kernkraftwerk_Test {

	@Test
	public void Wasserelement_standardWert() {
		Wasserelement element = new Wasserelement();
		assertEquals(10, element.getTemperatur());
	}
	
	@Test
	public void Wasserkreislauf_kuehlkreislauf_size() {
		Wasserkreislauf kreislauf = new Wasserkreislauf();
		assertEquals(12, kreislauf.getKuehlkreislauf().size());
	}
	
	@Test
	public void Wasserkreislauf_rotieren() {
		Wasserkreislauf kreislauf = new Wasserkreislauf();
		kreislauf.getKuehlkreislauf().peek().setTemperatur(40);
		kreislauf.rotiere();
		assertEquals(40, kreislauf.getKuehlkreislauf().peekLast().getTemperatur());
	}
	
	@Test
	public void Waermetauscher_ausgleichen() {
		Wasserelement element = new Wasserelement();
		Waermetauscher tauscher = new Waermetauscher();
		assertEquals(60, tauscher.ausgleichen(element, 110));
		
	}
	
	@Test
	public void Pumpe_pumpen() {
		Reaktor reaktor = new Reaktor();
		Wasserkreislauf kreislauf = new Wasserkreislauf();
		Pumpe pumpe = new Pumpe(reaktor, kreislauf, 1);
		kreislauf.getKuehlkreislauf().peekFirst().setTemperatur(70);
		pumpe.pumpen();
		assertEquals(25, kreislauf.getKuehlkreislauf().peekLast().getTemperatur());	
	}

}
