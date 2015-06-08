package quick.sort.list;

import java.util.LinkedList;
import java.util.List;

public class Buffer {

	private List<Seccion> values;
	
	public synchronized boolean isEmpty() { 
		return this.values.isEmpty(); 
	}
	public Buffer() {
		this.values = new LinkedList<Seccion>();
	}
	public synchronized void push(Seccion seccion) {
		values.add(seccion);
		notifyAll();
	}
	
	public synchronized Seccion pop() {
		while (this.values.size() == 0) {
			try {
				wait(); 
				} catch (InterruptedException e) {}
		}
		Seccion seccionResult = this.values.get(0);
		this.values.remove(seccionResult);
		return seccionResult;
		
	}
	
}
