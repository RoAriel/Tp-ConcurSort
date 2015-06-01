package sorted.sync.list;

public abstract class ClienteLista extends Thread {

	
	private SyncList monitoredList;
	private String nombre;

	public ClienteLista(SyncList list, String nombre) {

		this.setMonitoredList(list);
		this.setNombre(nombre);
	}

	public SyncList getMonitoredList() {
		return monitoredList;
	}

	public void setMonitoredList(SyncList monitoredList) {
		this.monitoredList = monitoredList;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract void run();
	
	
}
