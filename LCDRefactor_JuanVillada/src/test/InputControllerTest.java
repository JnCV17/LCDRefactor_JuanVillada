package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import controller.InputController;


public class InputControllerTest {

	private InputController inputController;
	
	@Test
	public void testIsNumeric() throws Exception {
		inputController = new InputController();	
		assertEquals(true, inputController.isNumeric("1"));	
		assertEquals(false, inputController.isNumeric("A"));
	}
	
	@Test
	public void testProcesar() throws Exception {
		inputController = new InputController();
		ArrayList<Object> parametros = inputController.procesar("2,12345");
		assertEquals(2, (int)parametros.get(0));
		assertEquals("12345", (String)parametros.get(1));
	}

}
