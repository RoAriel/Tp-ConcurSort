package ar.unq.concurrente.castro_gonzalez.monitores_concu_sort;

import sorted.sync.list.SyncList;

public class ClienteListaAdd extends Thread {

	private SyncList monitoredList;
	private String nombre;

	public ClienteListaAdd(SyncList list, String nombre) {

		this.monitoredList = list;
		this.nombre = nombre;
	}

	public void addListElement(Integer entero) {
		this.monitoredList.add(entero, this);
	}

	@Override
	public void run() {
		while (true) {
			this.addListElement(12);

		}

	}

	public String getNombre() {
		return this.nombre;
	}

}
