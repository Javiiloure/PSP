
public class Buffer {

	public int buffer;

	public Buffer() {
		this.buffer = 0;
	}

	public int getProducto() {
		return buffer;
	}

	public void consumir() {
		// Comprobamos si el buffer tiene unidades
		if (this.buffer == 1) {
			// Si tiene alguna, se consume
			this.buffer = 0;
			System.out.println("Consumida una unidad del buffer");
		} else {
			System.out.println("El buffer está vacio");
		}

	}

	public void producir() {
		// Comprobamos si el buffer no esta lleno
		if (this.buffer == 0) {
			// Si es posible, se incrementa una unidad
			this.buffer++;
			System.out.println("Producida una unidad del buffer");
		} else {
			System.out.println("El buffer esta lleno");
		}
	}
}
