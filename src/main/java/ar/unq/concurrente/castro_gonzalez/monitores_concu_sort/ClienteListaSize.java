package ar.unq.concurrente.castro_gonzalez.monitores_concu_sort;

import sorted.sync.list.SyncList;

public class ClienteListaSize extends Thread {

	private SyncList monitoredList;
	private String nombre;

	public ClienteListaSize(SyncList list, String nombre) {
		
		this.monitoredList = list;
		this.nombre = nombre;
	}

	public Integer getListSize() {
		return this.monitoredList.size(this);
	}

	

	@Override
	public void run() {
		while (true) {
			System.out.println("print size----"+ this.getListSize()); 
		} 
	}

	public String getNombre() {

		return this.nombre;
	}
	
}
