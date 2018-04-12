package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Digito;
import model.Segmento;

public class DigitoTest {
	
	private char[] segmento0 = new char[]{Segmento.A, Segmento.B, Segmento.C, Segmento.D, Segmento.E, Segmento.F};
	private Digito digito;
	
	@Test
	public void testGetSegmentoDisplay() throws Exception {
		
		 digito = new Digito(0);
		 
		 char[] caracteres = digito.getSegmentosDisplay();
		 
		 for (int i = 0; i < caracteres.length; i++) {
			assertTrue(caracteres[i] == segmento0[i]);
		}
		
	}

}
