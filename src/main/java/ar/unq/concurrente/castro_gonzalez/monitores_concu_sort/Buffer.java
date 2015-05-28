package ar.unq.concurrente.castro_gonzalez.monitores_concu_sort;

public class Buffer {

	private int[] values;
	private int begin;
	private int end;
	
	private boolean isEmpty() { 
		return begin == end; 
		}
	private boolean isFull() { 
		return begin + 1 == end; 
		}
	private int next(int n) { 
		return (n+1) % values.length; 
		}
	
	public Buffer(int size) {
		values = new int[size];
		begin = end = 0;
	}
	
	public synchronized void push(int v) {
		while (isFull())
			try { wait(); } catch (InterruptedException e) {}
		values[begin] = v;
		begin = next(begin);
		notifyAll();
	}
	
	public synchronized int pop() {
		while (isEmpty())
			try { wait(); } catch (InterruptedException e) {}
		int result = values[end];
		end = next(end);
		notifyAll();
		return result;
	}
	
}
