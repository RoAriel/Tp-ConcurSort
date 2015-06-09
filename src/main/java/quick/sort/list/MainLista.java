package quick.sort.list;

import java.util.LinkedList;
import java.util.List;


public class MainLista {

	public static void main(String[] args) {
		SyncAndSortList listaSorteable = new SyncAndSortList();
		List<Integer> lista1 = new LinkedList<Integer>();
		for (int i = 1000; i > 750; i--) {
			listaSorteable.add(i);
		}
		for (int i = 500; i < 750; i++) {
			listaSorteable.add(i);
		}
		
		for (int i = 500; i > 250; i--) {
			listaSorteable.add(i);
		}
		
		for (int i = 0; i < 250; i++) {
			listaSorteable.add(i);
		}
		
		lista1 = listaSorteable.getElementos();
		System.out.println("La Lista sin ordenar: ");
		System.out.println(lista1);
		System.out.println("--------Resultado del sort--------");
		listaSorteable.sort(50);
		lista1 = listaSorteable.getElementos();
		System.out.println("La Lista ordenada: ");
		System.out.println(lista1);
		
	}
}
