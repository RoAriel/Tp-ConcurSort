package quick.sort.list;

import java.util.List;

public class ThreadQSort extends Thread {

	private List<Integer> listaAOrdenar;
	private Buffer pila;
	private Counter contador;

	public ThreadQSort(List<Integer> listaAOrdenar, Buffer pila,
			Counter contador) {
		this.listaAOrdenar = listaAOrdenar;
		this.pila = pila;
		this.contador = contador;
	}

	@Override
	public void run() {

		while (true) {
			Seccion sector = this.pila.pop(); // consume trabajo (bloqueante)

			if (!sector.isValid()) {
				return;
			}
			if (sector.size() > 1) {
				int count = qsort_seccion(this.listaAOrdenar, sector.inicio,
						sector.fin);
				Seccion new_left_range = new Seccion(sector.inicio,
						sector.inicio + (count - 1));
				Seccion new_right_range = new Seccion(sector.inicio
						+ (count + 1), sector.fin);
				this.pila.push(new_left_range); // agrega trabajo
				this.pila.push(new_right_range); // agrega trabajo
			}
			if (!sector.isEmpty()) {
				contador.decrementar();
			}
		}
	}

	public int qsort_seccion(List<Integer> list, int inicio, int fin) {
		int j = 0;
		int pivot = list.get(inicio);
		for (int i = inicio + 1; i <= fin; i++) {
			if (list.get(i) < pivot) {
				this.swap(list, i, inicio + 1 + j);
				j++;
			}
		}
		this.swap(list, inicio, inicio + j);
		return j;
	}

	public void swap(List<Integer> list, Integer indexA, Integer indexB) {
		Integer i = list.get(indexA);
		Integer j = list.get(indexB);
		list.set(indexB, i);
		list.set(indexA, j);
	}
}
