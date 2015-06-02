package sorted.sync.list;

import java.util.List;


public class MainLista {

	public static void main(String[] args) {
		
		SyncList listaSorteable = new SyncList();
		List<Integer> result = listaSorteable.sort(5);
		System.out.println("Lista final");
		System.out.println("");
		SyncList.printList(result);
		
	}
}
