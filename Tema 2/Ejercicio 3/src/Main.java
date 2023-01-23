
public class Main {
	
	public static void main(String [] args) {
		
		Tarea hilo1 = new Tarea();
		Tarea hilo2 = new Tarea();
		Tarea hilo3 = new Tarea();
		Tarea hilo4 = new Tarea();
		
		// Ejecutamos el primer hilo
		hilo1.start();
		try {
			// Con el metodo join esperamos a que se termine su ejecucion
			hilo1.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		// En cuanto termine la ejecucion del hilo1 ejecutamos el segundo
		hilo2.start();
		try {
			hilo2.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		hilo3.start();
		try {
			hilo3.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		hilo4.start();
		try {
			hilo4.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
