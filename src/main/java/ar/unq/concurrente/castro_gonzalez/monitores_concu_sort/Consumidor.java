package ar.unq.concurrente.castro_gonzalez.monitores_concu_sort;


public class Consumidor extends Thread {

	private Buffer buffer;
	
	public Consumidor(Buffer buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		while (true)
			System.out.println(buffer.pop());
	}
	
}
