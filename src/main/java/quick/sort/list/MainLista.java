package quick.sort.list;

import java.util.LinkedList;
import java.util.List;


public class MainLista {

	public static void main(String[] args) {
		SyncAndSortList listaSorteable = new SyncAndSortList();
		List<Integer> lista1 = new LinkedList<Integer>();
		for (int i = 10000; i > 7500; i--) {
			listaSorteable.add(i);
		}
		for (int i = 5000; i < 7500; i++) {
			listaSorteable.add(i);
		}
		
		for (int i = 5000; i > 2500; i--) {
			listaSorteable.add(i);
		}
		
		for (int i = 0; i < 2500; i++) {
			listaSorteable.add(i);
		}
		
		listaSorteable.sort(500);
		lista1 = listaSorteable.getElementos();
		System.out.println(lista1);
		
	}
}
