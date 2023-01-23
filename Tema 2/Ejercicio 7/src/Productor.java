
public class Productor extends Thread {

	private Buffer buffer;

	public Productor(Buffer buffer) {
		this.buffer = buffer;
	}

	// Llamamos al metodo producir del Buffer
	@Override
	public void run() {
		while (true) {
			buffer.producir();
			try {
				// Cada vez que se produzca una unidad se espera 1 segundo
				this.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
