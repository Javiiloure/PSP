
public class Tarea extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Soy el hilo Hilo y estoy en la iteraci�n " + i);
		}
	}
}
