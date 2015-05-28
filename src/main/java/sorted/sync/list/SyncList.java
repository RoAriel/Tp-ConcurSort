package sorted.sync.list;

import java.util.LinkedList;
import java.util.List;

import ar.unq.concurrente.castro_gonzalez.monitores_concu_sort.ClienteListaAdd;
import ar.unq.concurrente.castro_gonzalez.monitores_concu_sort.ClienteListaSize;

public class SyncList extends Thread {

	private Boolean enUso;
	private List<Integer> elementos;
	// private Integer primerElemento;
	// private Integer ultimoElemento;
	private Integer tamanio;

	public SyncList() {
		this.enUso = new Boolean(false);
		this.elementos = new LinkedList<Integer>();
		// this.primerElemento = null;
		// this.ultimoElemento = null;
		this.tamanio = 0;
	}

	// Proximamente doble encapsulamiento.

	public synchronized Integer size(ClienteListaSize cliente) {
		System.out.println("Pedido size "+ cliente.getNombre());
		//System.out.println("Pedido de size");
		// wait saca el scheduler al methodo y
		// el while asegura que se vuelva a preguntar
		// por la variable enUso
		try {
			while (this.enUso) {
				try {
					wait();

				} catch (InterruptedException exception) {
				}
			}
			System.out.println("Calcular size" + cliente.getNombre());
			// Revisar si es necesario
			// sincronizar la variable enUso
			
			this.enUso = new Boolean(true);
			return this.tamanio;
		} finally {
			this.enUso = new Boolean(false);
			System.out.println("Termino el size" + cliente.getNombre());
			notifyAll();
		}
	}

	public synchronized Integer get(Integer posicion) {
		try {
			while (this.enUso) {
				try {
					wait();

				} catch (InterruptedException exception) {
				}
			}

			this.enUso = new Boolean(true);
			Integer elementoPosicion = this.elementos.get(posicion);
			return elementoPosicion;
		} finally {
			this.enUso = new Boolean(false);
			notifyAll();
		}

	}

	public synchronized Boolean contains(Integer element) {
		try {
			while (this.enUso) {
				try {
					wait();

				} catch (InterruptedException exception) {
				}
			}

			this.enUso = new Boolean(true);
			return this.elementos.contains(element);
		} finally {
			this.enUso = new Boolean(false);
			notifyAll();
		}
	}

	public synchronized Boolean isEmpty(ClienteListaSize cliente) {
		return this.size(cliente) == 0;
	}

	public synchronized void add(Integer element, ClienteListaAdd cliente) {
		System.out.println("Pedido add "+ cliente.getNombre());
		try {
			while (this.enUso) {
				try {
					wait();

				} catch (InterruptedException exception) {
				}
			}

			this.enUso = new Boolean(true);
			this.elementos.add(element);
			this.tamanio = this.tamanio + 1;
			System.out.println("se genera el add "+ cliente.getNombre());
		} finally {
			this.enUso = new Boolean(false);
			System.out.println("Termina el add "+ cliente.getNombre());
			notifyAll();
		}
	}

	public synchronized void set(Integer element, Integer posicion) {
		try {
			while (this.enUso) {
				try {
					wait();

				} catch (InterruptedException exception) {
				}
			}
			this.enUso = new Boolean(true);
			this.elementos.set(posicion, element);
		} finally {
			this.enUso = new Boolean(false);
			notifyAll();
		}
	}

	public synchronized void sort(int cantTheas) {

	}

}
