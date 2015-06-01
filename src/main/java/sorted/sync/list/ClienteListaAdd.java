package sorted.sync.list;


public class ClienteListaAdd extends ClienteLista {

	

	public ClienteListaAdd(SyncList list, String nombre) {
		super(list, nombre);
	}

	public void addListElement(Integer entero) {
		this.getMonitoredList().add(entero);
	}

	@Override
	public void run() {
		while (true) {
			this.addListElement(12);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
