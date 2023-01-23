
public class Main {
	
	public static void main (String [] args) {
		
		// Llamamos al constructor de la clase Tarea y lo ejecutamos el thread
		Tarea hilo = new Tarea();
		hilo.start();
	}
}
