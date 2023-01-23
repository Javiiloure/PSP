
public class Consumidor extends Thread {

	private Buffer buffer;

	public Consumidor(Buffer buffer) {
		this.buffer = buffer;
	}

	// Llamamos al metodo consumir del buffer
	@Override
	public void run() {
		while (true) {
			buffer.consumir();
			try {
				// Cada vez que se consuma una unidad se espera 1 segundo
				this.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
