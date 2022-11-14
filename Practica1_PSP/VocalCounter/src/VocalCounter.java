import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class VocalCounter {
	
	public static void main (String [] args) {
		boolean volcado;
		System.out.println("Proceso iniciado");
		String fileName = args[0].toString();
		char vowel = args[1].toString().charAt(0);
		String fileResultName = args[2].toString();
		
		JOptionPane.showMessageDialog(null, "Iniciado conteo de " + vowel);
		try {
		 volcado = counter(fileName, vowel, fileResultName);
		 if(volcado == true) {
			JOptionPane.showMessageDialog(null, "El volcado del conteo se ha realizado correctamente."); 
		 } else {
			 JOptionPane.showMessageDialog(null, "No se ha podido realizar el volcado del conteo.");
		 }
		} catch(IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public static boolean counter (String fileName, char vowel, String fileResultName) throws IOException {
		
		boolean volcado = false;
		BufferedReader br = FilePropierties.getBufferedReader(fileName);
		PrintWriter pw = FilePropierties.getPrintWriter(fileResultName);
		int cont = 0;
		String linea;
		int i = 0;
		
		// Declaramos un bucle while para leer cada linea del fichero
		while((linea = br.readLine()) != null) {
			
			// Por cada linea analizamos caracter a caracter, y si coincide sumamos al contador
			for(i = 0; i < linea.length(); i++) {
				if(Character.toLowerCase(linea.charAt(i)) == vowel) {
					cont++;
				}
			}
		}
		// Una vez terminado el analisis del archivo escribimos en el fichero de resultado el contador
		pw.write(cont);
		pw.flush();
		pw.close();
		
		// Comprobamos que el resultado se ha escrito en el fichero del resultado
		br = FilePropierties.getBufferedReader(fileResultName);
		if(br.readLine() != null) {
			volcado = true;
		}
		return volcado;
	}
}