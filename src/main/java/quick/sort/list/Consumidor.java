package quick.sort.list;

public class Consumidor extends Thread {

	private SyncAndSortList list;

	public Consumidor(SyncAndSortList lista) {

		this.list = lista;

	}

	public void run() {

		while (true) {
			System.out.println("----------------------------------");
			System.out.println(list.size());
			System.out.println("----------------------------------");
			try {
				this.sleep(40);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}
}
