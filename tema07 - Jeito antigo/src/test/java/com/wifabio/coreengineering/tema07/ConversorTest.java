package com.wifabio.coreengineering.tema07;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.wifabio.coreengineering.tema07.exceptions.NumeroInvalidoException;
import com.wifabio.coreengineering.tema07.modelo.Conversor;
import com.wifabio.coreengineering.tema07.modelo.ConversorCor;


public class ConversorTest {

	@Test
	public void deveriaConverterParaRomano() {
		int numero = 15;
		String numeroConvertidoRom = Conversor.converteDecimalParaRomano(numero);
		System.out.println(numeroConvertidoRom);
		assertEquals("XV", numeroConvertidoRom);
	}

	@Test
	public void deveriaConverterParaDecimal() {
		String romano = "XIX";
		int numeroConvertidoInt = ConversorCor.converteRomanoParaDecimal(romano);
		System.out.println(numeroConvertidoInt);
		assertEquals(19, numeroConvertidoInt);
	}
	
	@Test (expected = NumeroInvalidoException.class)
	public void deveriaRetornarErroPorEstarForaDoRangeEmDecimal() {
		int decimal = 0;
		Conversor.converteDecimalParaRomano(decimal);
	}
	
	@Test (expected = NumeroInvalidoException.class)
	public void deveriaRetornarErroPorEstarForaDoRangeEmRomano() throws NumeroInvalidoException {
		String romano = "XXII";
		Conversor.converteRomanoParaDecimal(romano);
	}
}
