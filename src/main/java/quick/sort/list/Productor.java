package quick.sort.list;

public class Productor extends Thread {

	private SyncAndSortList list;

	public Productor(SyncAndSortList lista) {

		this.list = lista;

	}

	public void run() {
		Integer i = 0;

		while (true) {
			list.add(i++);
			System.out.println("----------------------------------" + i);
			try {
				this.sleep(20);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}
}
