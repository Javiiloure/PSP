
public class Main {
	
	public static void main(String [] args) {
		
		Tarea hilo1 = new Tarea();
		Tarea hilo2 = new Tarea();
		Tarea hilo3 = new Tarea();
		Tarea hilo4 = new Tarea();
		
		// Ejecutamos el primer hilo
		hilo1.start();
		
		// Ejeutamos el segundo hilo
		hilo2.start();
		
		// Ejecutamos el tercer hilo
		hilo3.start();
		
		// Ejecutamos el cuarto hilo
		hilo4.start();
	}
}
