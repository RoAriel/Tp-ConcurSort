package sorted.sync.list;


public class ClienteListaSize extends ClienteLista {

	public ClienteListaSize(SyncList list, String nombre) {
		super(list, nombre);
	}


	public Integer getListSize() {
		return this.getMonitoredList().size();
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("print size----" + this.getListSize());
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("print size----" + this.getListSize());
		}
	}

}
