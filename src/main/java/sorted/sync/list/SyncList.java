package sorted.sync.list;

import java.util.LinkedList;
import java.util.List;


public class SyncList extends Thread {
	private List<Integer> elementos;
    private ThreadsHandler tHandler;

	public SyncList() {
		this.elementos = new LinkedList<Integer>();
		this.elementos.add(12);
		this.elementos.add(1);
		this.elementos.add(7);
		this.elementos.add(9);
		this.elementos.add(5);
		this.elementos.add(3);
		this.elementos.add(4);
		this.elementos.add(78);
		this.elementos.add(23);
		this.elementos.add(6);
		this.elementos.add(22);
		this.elementos.add(2);
		this.elementos.add(8);
		this.elementos.add(90);
		this.elementos.add(100);
		this.elementos.add(1212312);
		this.elementos.add(909090);
		this.elementos.add(40);
		this.elementos.add(11);
	}

	
	public SyncList(List<Integer> list, ThreadsHandler handler) {
		this.elementos = list;
		this.tHandler = handler;
	}

	public SyncList(List<Integer> lista) {
		this.elementos = lista;
	}

	public Integer size() {
		return this.realSize(this.elementos);
	}
	
	private synchronized Integer realSize(List<Integer> list) {
		return this.elementos.size();
	}
	
	
	public Integer get(Integer posicion) {
		return this.realGet(this.elementos, posicion);
	}
	

	private synchronized Integer realGet(List<Integer> list, Integer posicion) {
		Integer elementoPosicion = list.get(posicion);
		return elementoPosicion;
	}

	public synchronized Boolean contains(Integer element) {
		return this.elementos.contains(element);
	}

	public synchronized Boolean isEmpty() {
		return this.size() == 0;
	}

	public synchronized void add(Integer element) {
		this.elementos.add(element);
	}

	public synchronized void set(Integer element, Integer posicion) {
		this.elementos.set(posicion, element);
	}
	
	public synchronized  List<Integer> sort(int cantThreads) {
		this.tHandler = new ThreadsHandler(cantThreads);
		if (this.tHandler.hasThread()) {
			return this.sortWithHandler();
		}
		return null;
	}
	
	public synchronized List<Integer> sortWithHandler() {

		SorterThread tSort =  new SorterThread(this.elementos, this.tHandler);
		tSort.start();
		
//		/**
//		 * Buscamos en la web y vimos que el metodo join espera que el 
//		 * metodo run termine, asegura el valor del Thread, 
//		 * si esta mal y es necesario utilizar wait() y notify()
//		 * lo hacemos.
//		 * */
//		try {
//			tSort.join();
//		} catch (InterruptedException e1) {
//			e1.printStackTrace();
//		}
		
		synchronized (tSort) {
			try {
				tSort.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
		
		return tSort.getSortedList();
	}
	
	
	public List<Integer> getElementos() {
		return this.elementos;
	}

	public static void printList(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + ", ");
		}
	}
}
