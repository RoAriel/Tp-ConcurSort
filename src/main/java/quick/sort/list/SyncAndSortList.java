package quick.sort.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import sorter.list.dos.ThreadsHandler;

public class SyncAndSortList {

	
	private List<Integer> elementos;
	
	public SyncAndSortList() {
		this.elementos = new LinkedList<Integer>();
	}

	public synchronized Integer size() {
		return this.elementos.size();
	}

	public synchronized Integer get(Integer posicion) {
		
		return this.elementos.get(posicion);
	}

	synchronized Boolean contains(Integer element) {
		return this.elementos.contains(element);
	}

	public synchronized Boolean isEmpty() {
		return this.elementos.size() == 0;
	}

	public synchronized void add(Integer element) {
		this.elementos.add(element);
	}

	public synchronized void set(Integer element, Integer posicion) {
		this.elementos.set(posicion, element);
	}
	
	public void sort(Integer cantThreads) {
		/**
		 * Crear los n threads , ponerlo a correr
		 * y poner los elementos en la lista para ordenar.
		 * 
		 * ¿cuando terminan los threads?
		 * 
		 */
		List<ThreadQSort> listaDeThreads = new LinkedList<ThreadQSort>();
		for (int i = 0; i < cantThreads; i++) {
			 listaDeThreads.add(new ThreadQSort(this.elementos));
		}
		for (ThreadQSort threadQSort : listaDeThreads) {
			threadQSort.start();
		}
		
	
	}

		
	
}
