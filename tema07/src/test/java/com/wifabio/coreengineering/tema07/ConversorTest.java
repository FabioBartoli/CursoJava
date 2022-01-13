package com.wifabio.coreengineering.tema07;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.wifabio.coreengineering.tema07.exceptions.NumeroInvalidoException;
import com.wifabio.coreengineering.tema07.exceptions.NumeroRomanoException;
import com.wifabio.coreengineering.tema07.modelo.Conversor;


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
		int numeroConvertidoInt = Conversor.converteRomanoParaDecimal(romano);
		System.out.println(numeroConvertidoInt);
		assertEquals(19, numeroConvertidoInt);
	}
	
	@Test
	public void deveriaColocarStringEmLetrasMaiusculasEConverterParaDecimal() {
		String romano = "viii";
		int numeroConvertidoIntDec = Conversor.converteRomanoParaDecimal(romano);
		System.out.println(numeroConvertidoIntDec);
		assertEquals(8, numeroConvertidoIntDec);
	}
	
	@Test (expected = NumeroInvalidoException.class)
	public void deveriaRetornarErroPorEstarForaDoRangeEmDecimal() {
		int decimal = 0;
		Conversor.converteDecimalParaRomano(decimal);
	}
	
	@Test (expected = NumeroRomanoException.class)
	public void deveriaRetornarErroPorEstarForaDoRangeEmRomano() throws NumeroRomanoException {
		String romano = "XXII";
		Conversor.converteRomanoParaDecimal(romano);
	}
	
	@Test (expected = NumeroRomanoException.class)
	public void deveriaRetornarErroPorSerUmNumeroRomanoQueNaoExiste() throws NumeroRomanoException {
		String romano = "XXXXX";
		Conversor.converteRomanoParaDecimal(romano);
	}
}
