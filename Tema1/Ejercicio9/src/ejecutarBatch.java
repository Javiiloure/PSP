import java.lang.ProcessBuilder;
import java.lang.Process;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class ejecutarBatch {
	public static void main(String [] args) {
		ProcessBuilder pb = new ProcessBuilder("helloBatch.bat", "Usuario X");
		
		try{ 
			Process p = pb.start();
			System.out.println("Proceso ejecutado correctamente.");
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			System.out.println(br.readLine());
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
