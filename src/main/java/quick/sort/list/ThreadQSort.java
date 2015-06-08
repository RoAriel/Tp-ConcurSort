package quick.sort.list;

import java.util.LinkedList;
import java.util.List;

public class ThreadQSort extends Thread {

	private List<Integer> listaAOrdenar;
	private Boolean trabajar;


	public ThreadQSort(LinkedList<Integer> listaAOrdenar) {
		this.listaAOrdenar = listaAOrdenar;
		this.trabajar = true;
	}

	
	
	void qsort_worker(List<Integer> list, Buffer pila, Counter contador) { 
		while (true) {
			Seccion r = pila.pop(); // consume trabajo (bloqueante)
			if (!r.isValid()) {
				return;
			}
			if (r.size()>1) {
				int count = qsort_seccion(list, r.inicio, r.fin);
				Seccion new_left_range = new Seccion(r.inicio, r.inicio + count-1);
				Seccion new_rigth_range = new Seccion(r.inicio + count + 1, r.fin);
				pila.push(new_left_range);  // agrega trabajo
				pila.push(new_rigth_range); // agrega trabajo
			} 
			if (!r.isEmpty()) {
				contador.dec();
			}
		}
	}
	
	@Override
	public void run() {
		
		
		
		
		while(trabajar){
			while (listaAOrdenar.size() == 0) {
				this.esperar();
			}
			
		}
		
	}

	public int qsort_seccion(List<Integer> list, int inicio, int fin) {
		int j = 0;
		int pivot = list.get(inicio); 
		for (int i = inicio + 1; i <=fin ; i++) {
			if (list.get(i) < pivot) {
				this.swap(list, i, inicio+1 + j);
				j++;
			}
		}
		swap(list, inicio, inicio+j);
		return j;
	}
	
	
	public void swap (List<Integer> list, Integer indexA, Integer indexB) {
		Integer i = list.get(indexA);
		Integer j = list.get(indexB);
		list.set(indexB, i);
		list.set(indexA, j);
	}
	
	private synchronized void esperar() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
