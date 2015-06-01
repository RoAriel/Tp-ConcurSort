package sorted.sync.list;

import java.util.List;

public class ThreadSorteador extends Thread {

	SyncList synclist;
	ThreadsHandler cantThreads;
	public boolean termino;
	public ThreadSorteador(ThreadsHandler cantThreads, List<Integer> lista) {
		this.cantThreads = cantThreads;
		this.synclist = new SyncList(lista);
		this.termino = false;
	}
	

	public void run() {
		this.synclist.sort(this.cantThreads.cantMax);
		this.cantThreads.releaseThread();
		System.out.println("se devuelve el thread");
		termino = true;
	}

	public List<Integer> getSortedList() {
		return this.synclist.getElementos();
	}
}
