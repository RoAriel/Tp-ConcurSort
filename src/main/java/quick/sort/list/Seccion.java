package quick.sort.list;

public class Seccion {

	public int inicio;
	public int fin;
	
	public Seccion(int new_start, int new_end) {
		this.inicio = new_start;
		this.fin = new_end;
	}
	public synchronized boolean isValid() {
		return inicio >= 0;
	}
	public synchronized boolean isEmpty() {
		return this.fin < this.inicio;
	}
	public synchronized int size() {
		return (this.fin - this.inicio) + 1 ;
	}
}
