
public class Tarea extends Thread {

	@Override
	public void run() {
		
		// Lanzamos el hilo cargando
		Cargando hilo = new Cargando();
		hilo.start();
		try {
			hilo.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		long tiempo_inicio = System.currentTimeMillis();
		long tiempo_final = tiempo_inicio;
		
		// Blucle while que durara 5 segundos aprox
		while(tiempo_final <= (tiempo_inicio + 5000)) {
			tiempo_final = System.currentTimeMillis();
			hilo = new Cargando();
			hilo.start();
			try {
				hilo.join();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		};
	}
}
