package br.com.alura.java.io.teste;

import java.io.FileWriter;
import java.io.IOException;

public class TesteEscritaFileWriter {

	public static void main(String[] args) throws IOException {

		// Fluxo de Entrada com um Arquivo
//		OutputStream fos = new FileOutputStream("lorem2.txt");
//		Writer osw = new OutputStreamWriter(fos);
//		BufferedWriter bw = new BufferedWriter(osw);
		
		FileWriter fw = new FileWriter("lorem2.txt");

		fw.write("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, \n");
		fw.write(System.lineSeparator());
		fw.write("awedqwa ASAD asSAsfasd asdfasdfasd");
		
		fw.close();
	}

}
