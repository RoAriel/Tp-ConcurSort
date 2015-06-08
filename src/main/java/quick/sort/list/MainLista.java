package quick.sort.list;

import java.util.LinkedList;
import java.util.List;

import sorted.sync.list.SyncList;


public class MainLista {

	public static void main(String[] args) {
		SyncAndSortList listaSorteable = new SyncAndSortList();
		List<Integer> lista1 = new LinkedList<Integer>();
//		for (int i = 750; i < 1000; i++) {
//			listaSorteable.add(i);
//		}
		
		for (int i = 34; i < 56; i++) {
			listaSorteable.add(i);
		}
		for (int i = 10; i > 0; i--) {
			listaSorteable.add(i);
		}	
//		for (int i = 0; i < 250; i++) {
//			listaSorteable.add(i);
//		}
		
		
		System.out.println(listaSorteable.getElementos().size());
		listaSorteable.sort(2);
		lista1 = listaSorteable.getElementos();
		System.out.println("Lista final");
		System.out.println("");
		SyncList.printList(lista1);
		
	}
}
