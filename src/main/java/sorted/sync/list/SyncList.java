package sorted.sync.list;

import java.util.LinkedList;
import java.util.List;


public class SyncList extends Thread {

//	private Boolean enUso;
	private List<Integer> elementos;

	public SyncList() {
//		this.enUso = new Boolean(false);
		this.elementos = new LinkedList<Integer>();
	}

	// Proximamente doble encapsulamiento.

	public SyncList(List<Integer> lista) {
		this.elementos = lista;
	}

	public Integer size() {
		return this.realSize(this.elementos);
	}
	
	private synchronized Integer realSize(List<Integer> list) {
//		System.out.println("Pedido size "+ cliente.getNombre());
//		try {
			
			return this.elementos.size();
//		} finally {
//			System.out.println("Termino el size" + cliente.getNombre());
//			notifyAll();
//		}
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

	public List<Integer> sort(int cantThreats) {
		return this.realSort(cantThreats, this.elementos);
		
	}
	
	public synchronized List<Integer> realSort(int cantThreads, List<Integer> list) {
		cantThreads--;
		
		if (this.realSize(list) <= 1) {
			return list;
		}
		Integer pivot = this.getPivot(list);
		
		List<Integer> listaIzquierda = this.lessThan(list, pivot);
		
		List<Integer> listaDerecha = this.greaterThan(list, pivot);
		
		List<Integer> listaIzquierdaSorted;
		List<Integer> listaDerechaSorted;
		
		
		if (cantThreads > 0) {
			cantThreads--;
			ThreadSorteador threadLess = new ThreadSorteador(cantThreads, listaIzquierda);
			threadLess.start();
			listaIzquierdaSorted = threadLess.getSortedList();
		}else {
			listaIzquierdaSorted = this.realSort(cantThreads, listaIzquierda);
		}
		if (cantThreads > 0) {
			cantThreads--;
			ThreadSorteador threadLess = new ThreadSorteador(cantThreads, listaDerecha);
			threadLess.start();
			listaDerechaSorted = threadLess.getSortedList();
		}else {
			listaDerechaSorted = this.realSort(cantThreads, listaDerecha);
		}
		listaIzquierdaSorted.add(pivot);
		listaIzquierdaSorted.addAll(listaDerechaSorted);
		return listaIzquierda;
		
	}

	private List<Integer> greaterThan(List<Integer> list, Integer pivot) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Integer> lessThan(List<Integer> list, Integer pivot) {
		// TODO Auto-generated method stub
		return null;
	}

	private Integer getPivot(List<Integer> list) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> getElementos() {
		return this.elementos;
	}

}
