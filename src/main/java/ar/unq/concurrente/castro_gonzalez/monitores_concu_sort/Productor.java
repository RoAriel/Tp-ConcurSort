package ar.unq.concurrente.castro_gonzalez.monitores_concu_sort;

public class Productor extends Thread {

	private Buffer buffer;
	
	public Productor(Buffer buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		int i = 0;
		while (true)
			buffer.push(i++);
	}
	
}
