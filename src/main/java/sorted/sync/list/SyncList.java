package sorted.sync.list;

import java.util.LinkedList;
import java.util.List;


public class SyncList extends Thread {

//	private Boolean enUso;
	private List<Integer> elementos;

	public SyncList() {
//		this.enUso = new Boolean(false);
		this.elementos = new LinkedList<Integer>();
		this.elementos.add(12);
		this.elementos.add(1);
		this.elementos.add(7);
//		this.elementos.add(9);
//		this.elementos.add(5);
//		this.elementos.add(3);
//		this.elementos.add(4);
//		this.elementos.add(78);
//		this.elementos.add(23);
//		this.elementos.add(6);
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

	
	
	
	
	
	public  List<Integer> sort(int cantThreads) {
		ThreadsHandler threadHandler = new ThreadsHandler(cantThreads);
		return this.realSort(threadHandler, this.elementos);
		
	}
	
	
	
	
	
	
	public synchronized List<Integer> realSort(ThreadsHandler cantThreads, List<Integer> list) {
		
		if (list.size() <= 1) {
			return list;
		}
		Integer pivot = this.getPivot(list);
		System.out.print("pivot ");
		System.out.println(pivot);
		System.out.print("cantMax ");
		System.out.println(cantThreads.cantMax);
		
		List<Integer> listaIzquierda = this.lessThan(list, pivot);
		
		List<Integer> listaDerecha = this.greaterThan(list, pivot);
		
		List<Integer> listaIzquierdaSorted = null;
		List<Integer> listaDerechaSorted = null;
		ThreadSorteador threadLess = null;
		ThreadSorteador threadGreather = null;
		
		System.out.println("-------------");
		SyncList.printList(listaIzquierda);
		System.out.println("");
		SyncList.printList(listaDerecha);
		System.out.println("");
		System.out.println("-------------");
		
		if (cantThreads.hasThread()) {
			System.out.println("entra a crear un thread en lista izquierda");
			threadLess = new ThreadSorteador(cantThreads, listaIzquierda);
			threadLess.start();
			System.out.println(cantThreads.cantMax);
		}else {
			System.out.println("hace el solo la lista izquierda");
			listaIzquierdaSorted = this.realSort(cantThreads, listaIzquierda);
		}
		if (cantThreads.hasThread()) {
			System.out.println("entra a crear un thread en lista derecha");
			threadGreather = new ThreadSorteador(cantThreads, listaDerecha);
			threadGreather.start();
			System.out.println(cantThreads.cantMax);
		}else {
			System.out.println("hace el solo la lista derecha");
			listaDerechaSorted = this.realSort(cantThreads, listaDerecha);
		}
		
		if (threadLess != null) {
			try {
				threadLess.join();
			} catch (InterruptedException e) {}
			listaIzquierdaSorted = threadLess.getSortedList();
			System.out.println("sale del primer while");
		}
		if (threadGreather != null) {
			try {
				threadGreather.join();
			} catch (InterruptedException e) {}
			listaDerechaSorted = threadGreather.getSortedList();
			System.out.println("entra al segundo while");
		}
		
		listaIzquierdaSorted.add(pivot);
		listaIzquierdaSorted.addAll(listaDerechaSorted);
		return listaIzquierdaSorted;
	}

	
	
	
	
	
	
	
	
	private List<Integer> greaterThan(List<Integer> list, Integer pivot) {
		List<Integer> listResult = new LinkedList<Integer>();
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > pivot) {
				listResult.add(list.get(i));
			}
		}
		
		return listResult;
	}

	private List<Integer> lessThan(List<Integer> list, Integer pivot) {
		List<Integer> listResult = new LinkedList<Integer>();
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < pivot) {
				listResult.add(list.get(i));
			}
		}
		
		return listResult;
	}

	private Integer getPivot(List<Integer> list) {
		
		Integer index = randomBetweenAnd(0, list.size());
		return list.get(index);
	}

	private int randomBetweenAnd(int startNumber, int stopNumber) {
		return (int) (Math.random() * stopNumber + startNumber);
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
