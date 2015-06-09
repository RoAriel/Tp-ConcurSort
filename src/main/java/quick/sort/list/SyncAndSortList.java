package quick.sort.list;

import java.util.LinkedList;
import java.util.List;

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

	public synchronized List<Integer> getElementos() {
		return this.elementos;
	}

	public synchronized void sort(Integer cantThreads) {
		Seccion init_rage = new Seccion(0, (this.elementos.size() - 1));
		Buffer pila = new Buffer();
		Counter contador = new Counter(this.elementos.size());
		List<ThreadQSort> listaDeThreads = new LinkedList<ThreadQSort>();

		pila.push(init_rage); // agrega el trabajo inicial de ordenar toda la

		for (int i = 0; i < cantThreads; i++) {
			listaDeThreads.add(new ThreadQSort(this.elementos, pila, contador));
		}

		for (ThreadQSort threadQSort : listaDeThreads) {
			threadQSort.start();
		}

		contador.waitZero();
		Seccion invalid_range = new Seccion(-1, 0);

		for (int i = 0; i < cantThreads; i++) {
			pila.push(invalid_range);
		}
	}
}
