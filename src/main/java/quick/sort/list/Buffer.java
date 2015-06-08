package quick.sort.list;

import java.util.LinkedList;
import java.util.List;

public class Buffer {

	private List<Seccion> values;
	
	private boolean isEmpty() { 
		return this.values.size() == 0; 
	}

//	private int next(int n) { 
//		return (n+1) % values.length; 
//	}
	
	public Buffer() {
		this.values = new LinkedList<Seccion>();
	}
	
//	public Buffer(List<Seccion> list) {
//		this.values = list;
//	}
	
	public synchronized void push(Seccion seccion) {
		values.add(seccion);
		notifyAll();
	}
	
	public synchronized Seccion pop() {
		while (isEmpty())
			try { wait(); } catch (InterruptedException e) {}
		
		return values.remove(0);
	}
	
}
