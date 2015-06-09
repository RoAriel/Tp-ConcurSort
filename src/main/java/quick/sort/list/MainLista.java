package quick.sort.list;

import java.util.LinkedList;
import java.util.List;


public class MainLista {

	public static void main(String[] args) {
		SyncAndSortList listaSorteable = new SyncAndSortList();
		List<Integer> lista1 = new LinkedList<Integer>();
		for (int i = 100; i > 75; i--) {
			listaSorteable.add(i);
		}
		for (int i = 50; i < 75; i++) {
			listaSorteable.add(i);
		}
		
		for (int i = 50; i > 25; i--) {
			listaSorteable.add(i);
		}
		
		for (int i = 0; i < 25; i++) {
			listaSorteable.add(i);
		}
		
		listaSorteable.sort(10);
		lista1 = listaSorteable.getElementos();
		System.out.println("La Lista ordenada: ");
		System.out.println(lista1);
		
	}
}
