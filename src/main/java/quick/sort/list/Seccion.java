package quick.sort.list;

public class Seccion {

	public int inicio;
	public int fin;
	
	public Seccion(int new_start, int new_end) {
		this.inicio = new_start;
		this.fin = new_end;
	}
	public boolean isValid() {
		return inicio <= fin;
	}
	
	public Boolean isEmpty() {
		return inicio == fin;
	}
	
	public int size() {
		return this.fin - this.inicio;
	}
}
