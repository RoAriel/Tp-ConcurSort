package sorted.sync.list;

import java.util.List;

public class ThreadSorteador extends Thread {

	SyncList synclist;
	Integer cantThreads;
	public ThreadSorteador(Integer cantThreads, List<Integer> lista) {
		this.cantThreads = cantThreads;
		this.synclist = new SyncList(lista);
	}
	
	public void run() {
		this.synclist.sort(this.cantThreads);
	}

	public List<Integer> getSortedList() {
		return this.synclist.getElementos();
	}
}
