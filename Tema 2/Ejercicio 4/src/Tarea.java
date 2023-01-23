
public class Tarea extends Thread{
	
	static int count = 1;
	
	@Override
	public synchronized void run() {
		for(int i = 1; i <= 10; i++) {
		System.out.println("Soy el hilo Tarea " + count + " y estoy en la iteración " + i);
		}
		count++;
	}
}
