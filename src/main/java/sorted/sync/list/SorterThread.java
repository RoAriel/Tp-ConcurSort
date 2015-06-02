package sorted.sync.list;

import java.util.LinkedList;
import java.util.List;

public class SorterThread extends Thread {

	private ThreadsHandler handler;
	private List<Integer> list;
	private List<Integer> sortedList;
	private boolean terminoDeOrdenar;
	
	public SorterThread(List<Integer> list, ThreadsHandler handler) {
		this.handler = handler;
		this.setList(list);
		this.setSortedList(new LinkedList<Integer>());
		this.terminoDeOrdenar = false;
	}
	
	private List<Integer> quickSort(List<Integer> list, ThreadsHandler handler) {
		if (list.size() <= 1) {
			return list;
		}
		Integer pivot = this.getPivot(list);
		
		List<Integer> listaIzquierda = this.lessThan(list, pivot);
		List<Integer> listaDerecha = this.greaterThan(list, pivot);
		
		List<Integer> listaIzquierdaSorted = null;
		List<Integer> listaDerechaSorted = null;
		
		SyncList listLower = null;
		SyncList listGreather = null;
		
		if (handler.hasThread()) {
			System.out.println("thread izquierda");
			listLower = new SyncList(listaIzquierda, this.handler);
			listaIzquierdaSorted = listLower.sortWithHandler();
		}else {
			listaIzquierdaSorted = this.quickSort(listaIzquierda, handler);
		}
		if (handler.hasThread()) {
			System.out.println("thread derecha");
			listGreather = new SyncList(listaDerecha, handler);
			listaDerechaSorted = listGreather.sortWithHandler();
		}else {
			listaDerechaSorted = this.quickSort(listaDerecha, handler);
		}
		listaIzquierdaSorted.add(pivot);
		listaIzquierdaSorted.addAll(listaDerechaSorted);
		this.terminoDeOrdenar = true;
		this.handler.releaseThread();
		return listaIzquierdaSorted;
	}
	
	
	private List<Integer> greaterThan(List<Integer> list, Integer pivot) {
		List<Integer> listResult = new LinkedList<Integer>();
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > pivot) {
				listResult.add(list.get(i));
			}
		}
		
		return listResult;
	}

	private List<Integer> lessThan(List<Integer> list, Integer pivot) {
		List<Integer> listResult = new LinkedList<Integer>();
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < pivot) {
				listResult.add(list.get(i));
			}
		}
		
		return listResult;
	}

	private Integer getPivot(List<Integer> list) {
		
		Integer index = randomBetweenAnd(0, list.size());
		return list.get(index);
	}

	private int randomBetweenAnd(int startNumber, int stopNumber) {
		return (int) (Math.random() * stopNumber + startNumber);
	}
	
	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public List<Integer> getSortedList() {
		return sortedList;
	}

	public void setSortedList(List<Integer> sortedList) {
		this.sortedList = sortedList;
	}
	
	
	public synchronized void run() {
		this.sortedList = this.quickSort(this.getList(), this.handler);
	}

	public boolean noTerminoDeOrdenar() {
		return !this.terminoDeOrdenar;
	}

	
}
