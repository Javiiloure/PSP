import java.lang.ProcessBuilder;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Principal {

	public static void main(String[] args) {
		boolean exit = false;
		int select;
		String vocal_counter = args[0].toString();
		String[] options = { "Iniciar un nuevo analisis", "Mostrar ultimos resultados", "Salir del programa" };

		// Condicional para saber si se ha introducido correctamente VocalCounter
		if ((vocal_counter.endsWith("VocalCounter")) || vocal_counter.endsWith("VocalCounter.java")) {
			// Bucle while para inicar el menu principal
			inicio: while (exit != true) {
				select = JOptionPane.showOptionDialog(null, "Bienvenido a contador de vocales, seleccione una opcion.",
						"Vocal Counter", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
						options[0]);
				switch (select) {
				// Case 0 lanza un nuevo analisis
				case 0:
					try {
						nuevoAnalisis(vocal_counter);
					} catch (FileNotFoundException e) {
						JOptionPane.showMessageDialog(null, "No se ha encontrado el fichero seleccionado", "Error",
								JOptionPane.ERROR_MESSAGE);
						continue inicio;
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, "Error de E/S de datos", "Error",
								JOptionPane.ERROR_MESSAGE);
						continue inicio;
					} catch (InterruptedException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						continue inicio;
					} catch (NullPointerException e) {
						JOptionPane.showMessageDialog(null, "No se ha introducido ningun archivo", "Error",
								JOptionPane.ERROR_MESSAGE);
						continue inicio;
					}
					break;
				// Case 1 muestra los ultimos resultados por pantalla
				case 1:
					try {
						mostrarResultados();
					} catch (FileNotFoundException e) {
						JOptionPane.showMessageDialog(null,
								"No se han encontrado resultados, analice un archivo primero", "Error",
								JOptionPane.ERROR_MESSAGE);
						continue inicio;
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, "Error de E/S de datos", "Error",
								JOptionPane.ERROR_MESSAGE);
						continue inicio;
					}
					break;
				// Case 2 cierra el programa
				case 2:
					exit = true;
					break;
				}
			}
			JOptionPane.showMessageDialog(null, "Cerrando el programa");
		} else {
			JOptionPane.showMessageDialog(null, "El argumento debe indicar la ruta de VocalCounter", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void nuevoAnalisis(String vocal_counter) throws IOException, InterruptedException {

		// Seleccionamos con JFileChooser el archivo a ser analizado y guardamos la ruta
		// en una cadena
		String file;
		JFileChooser filechooser = new JFileChooser();
		filechooser.setDialogTitle("Introduzca el fichero a analizar");
		filechooser.showOpenDialog(filechooser);
		file = filechooser.getSelectedFile().getAbsolutePath();

		// Lanzamos un proceso por cada vocal a contar llamando a VocalCounter y
		// esperamos a que termine para lanzar el siguiente
		ProcessBuilder pb = new ProcessBuilder("java", vocal_counter, file, "a", "resultado_a.txt");
		Process p1 = pb.start();
		p1.waitFor();

		pb = new ProcessBuilder("java", vocal_counter, file, "e", "resultado_e.txt");
		Process p2 = pb.start();
		p2.waitFor();

		pb = new ProcessBuilder("java", vocal_counter, file, "i", "resultado_i.txt");
		Process p3 = pb.start();
		p3.waitFor();

		pb = new ProcessBuilder("java", vocal_counter, file, "o", "resultado_o.txt");
		Process p4 = pb.start();
		p4.waitFor();

		pb = new ProcessBuilder("java", vocal_counter, file, "u", "resultado_u.txt");
		Process p5 = pb.start();
		p5.waitFor();

		// Llamamos al metodo guardarFicheroTotal
		guardarFicheroTotal();
	}

	public static void guardarFicheroTotal() throws FileNotFoundException, IOException {
		File a = new File("resultado_a.txt");
		File e = new File("resultado_e.txt");
		File i = new File("resultado_i.txt");
		File o = new File("resultado_o.txt");
		File u = new File("resultado_u.txt");
		FileReader fr = null;
		BufferedReader br = null;
		File fichero_total = null;
		FileWriter fw = null;
		String contenido = "";

		// Comprobamos que se hayan creado los ficheros anteriores y recogemos el numero
		// de cada vocal

		if (a.exists() && e.exists() && i.exists() && o.exists() && u.exists()) {
			fr = new FileReader("resultado_a.txt");
			br = new BufferedReader(fr);
			int total_a = Integer.valueOf(br.readLine());
			contenido = "Total a: " + total_a;
			fr.close();

			fr = new FileReader("resultado_e.txt");
			br = new BufferedReader(fr);
			int total_e = Integer.valueOf(br.readLine());
			contenido = contenido + "\nTotal e: " + total_e;
			fr.close();

			fr = new FileReader("resultado_i.txt");
			br = new BufferedReader(fr);
			int total_i = Integer.valueOf(br.readLine());
			contenido = contenido + "\nTotal i: " + total_i;
			fr.close();

			fr = new FileReader("resultado_o.txt");
			br = new BufferedReader(fr);
			int total_o = Integer.valueOf(br.readLine());
			contenido = contenido + "\nTotal o: " + total_o;
			fr.close();

			fr = new FileReader("resultado_u.txt");
			br = new BufferedReader(fr);
			int total_u = Integer.valueOf(br.readLine());
			contenido = contenido + "\nTotal u: " + total_u;
			fr.close();

			// Una vez obtenidos todos los valores, creamos un nuevo fichero que contenga
			// estos valores y la suma
			// de todos ellos.
			contenido = contenido + "\nVocales totales: " + (total_a + total_e + total_i + total_o + total_u);
			fichero_total = new File("recuento_total.txt");
			fw = new FileWriter(fichero_total);
			fw.write(contenido);
			fw.flush();
			fw.close();
		} else {
			JOptionPane.showMessageDialog(null, "Fichero o ficheros de recuento inexistentes.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void mostrarResultados() throws FileNotFoundException, IOException {
		String contenido = "";
		String linea;
		File file = new File("recuento_total.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		// Bucle while que cerramos al terminar de leer el archivo
		while ((linea = br.readLine()) != null) {
			contenido += linea + "\n";
		}
		br.close();

		// Mostramos el contenido del archivo con JOptionPane
		JOptionPane.showMessageDialog(null, contenido, "Recuento total", JOptionPane.INFORMATION_MESSAGE);

	}
}
