import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FilePropierties {
	public static void main(String [] args) {
		
	}
	public static BufferedReader getBufferedReader(String nombre_archivo) throws IOException{
		File file = new File(nombre_archivo);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		return br;
	}
	
	public static PrintWriter getPrintWriter(String nombre_archivo) throws FileNotFoundException{
		File file = new File(nombre_archivo);
		PrintWriter pw = new PrintWriter(file);
		return pw;
	}
}
