import java.lang.ProcessBuilder;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Principal {
	
	public static void main(String[] args) {
		boolean exit = false;
		int select;
		String vocal_counter = args[0].toString();
		String [] options = {"Iniciar un nuevo analisis", "Mostrar ultimos resultados", "Salir del programa"};
		
		// Bucle while para inicar el menu principal
		while (exit != true) {
			select =  JOptionPane.showOptionDialog(null, "Vocal Counter", "Bienvenido a contador de vocales, seleccione una opcion.",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			switch (select) {
			case 0:
				try {
					nuevoAnalisis(vocal_counter);
				} catch(IOException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch(InterruptedException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case 1:
				try { 
					mostrarResultados();
				} catch(FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch(IOException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case 2:
				exit = true;
				break;
			}
		}
		JOptionPane.showMessageDialog(null, "Cerrando el programa");
	}
	
	public static void nuevoAnalisis(String vocal_counter) throws IOException, InterruptedException {
		
		// Seleccionamos con JFileChooser el archivo a ser analizado y guardamos la ruta en una cadena
		String file;
		JFileChooser filechooser = new JFileChooser();
		filechooser.showOpenDialog(filechooser);
		file = filechooser.getSelectedFile().getAbsolutePath();
		
		// Lanzamos un proceso por cada vocal a contar llamando a VocalCounter
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
		
			// Bucle infinito que cerramos al terminar todosa los procesos para evitar que el programa siga funcionando
			// mientras no se termina de contar
		
	}
	
	public static void mostrarResultados() throws FileNotFoundException, IOException {
		File a = new File("resultado_a.txt");
		File e = new File("resultado_e.txt");
		File i = new File("resultado_i.txt");
		File o = new File("resultado_o.txt");
		File u = new File("resultado_u.txt");
		FileReader fr = null;
		BufferedReader br = null;
		
		if(a.exists() && e.exists() && i.exists() && o.exists() && u.exists()) {
			fr = new FileReader("resultado_a.txt");
			br = new BufferedReader(fr);
			int total_a = Integer.valueOf(br.readLine());
			System.out.println(total_a);
			fr.close();
			
			fr = new FileReader("resultado_e.txt");
			br = new BufferedReader(fr);
			int total_e = Integer.valueOf(br.readLine());
			System.out.println(total_e);
			fr.close();
			
			fr = new FileReader("resultado_i.txt");
			br = new BufferedReader(fr);
			int total_i = Integer.valueOf(br.readLine());
			System.out.println(total_i);
			fr.close();
			
			fr = new FileReader("resultado_o.txt");
			br = new BufferedReader(fr);
			int total_o = Integer.valueOf(br.readLine());
			System.out.println(total_o);
			fr.close();
			
			fr = new FileReader("resultado_u.txt");
			br = new BufferedReader(fr);
			int total_u = Integer.valueOf(br.readLine());
			System.out.println(total_u);
			fr.close();
		} else {
			JOptionPane.showMessageDialog(null, "Fichero o ficheros de recuento inexistentes.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
