
public class Main {

	public static void main(String[] args) {

		// Creamos un objeto de tipo buffer
		Buffer buffer = new Buffer();

		// Llamamos a los constructores de Productor y Consumidor pasando el buffer
		// creado como argumento para que utilicen el mismo
		Productor productor = new Productor(buffer);
		Consumidor consumidor = new Consumidor(buffer);

		// Lanzamos los hilos productor y consumidor
		productor.start();
		consumidor.start();
	}
}
