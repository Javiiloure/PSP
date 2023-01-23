
public class Main {
	
	public static void main(String [] args) {
		
		Tarea hilo = new Tarea();
		
		hilo.start();
		
		try {
			hilo.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finalizado");
	}
}
