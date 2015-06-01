package ar.unq.concurrente.castro_gonzalez.monitores_concu_sort;


public class Main {

	public static void main(String[] args) {
		Buffer buffer = new Buffer(10);
		Productor productor = new Productor(buffer);
		Consumidor consumidor = new Consumidor(buffer);
		productor.start();
		consumidor.start();
	}
	
}
