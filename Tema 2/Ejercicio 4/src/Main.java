
public class Main {
	
	public static void main (String [] args) {
		
		// Declaramos los hilos y cambiamos su nivel de prioridad
		Tarea hilo1 = new Tarea();
		hilo1.setPriority(10);
		
		Tarea hilo2 = new Tarea();
		hilo2.setPriority(6);
		
		Tarea hilo3 = new Tarea();
		hilo3.setPriority(4);
		
		Tarea hilo4 = new Tarea();
		hilo4.setPriority(1);
		
		// Declaramos dos variables para medir el tiempo que tarda en ejecutarse un hilo
		long tiempo_inicio = 0;
		long tiempo_final = 0;
		
		// Ejeutamos el primer hilo y obtenemos el tiempo en el inicio
		tiempo_inicio = System.currentTimeMillis();
		hilo1.start();
		try {
			// En el momento en el que finaliza obtenemos el tiempo del final
			hilo1.join();
			tiempo_final = System.currentTimeMillis();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Realizamos la resta y obtenemos el tiempo de ejecucion
		System.out.println("El hilo 1 ha tardado " + (tiempo_final - tiempo_inicio) + " milisegundos");
		
		// Repetimos el proceso con el resto de hilos
		tiempo_inicio = System.currentTimeMillis();
		hilo2.start();
		try {
			hilo2.join();
			tiempo_final = System.currentTimeMillis();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("El hilo 2 ha tardado " + (tiempo_final - tiempo_inicio) + " milisegundos");
		
		tiempo_inicio = System.currentTimeMillis();
		hilo3.start();
		try {
			hilo3.join();
			tiempo_final = System.currentTimeMillis();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("El hilo 3 ha tardado " + (tiempo_final - tiempo_inicio) + " milisegundos");
		
		tiempo_inicio = System.currentTimeMillis();
		hilo4.start();
		try {
			hilo4.join();
			tiempo_final = System.currentTimeMillis();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("El hilo 4 ha tardado " + (tiempo_final - tiempo_inicio) + " milisegundos");
	}
}
