package sorted.sync.list;

import java.util.List;


public class MainLista {

	public static void main(String[] args) {
		
		SyncList listaSorteable = new SyncList();
		List<Integer> result = listaSorteable.sort(2);
//		ClienteListaSize cliente1 = new ClienteListaSize(listaSorteable, "Juan Carlos");
		
//		ClienteListaAdd cliente2 = new ClienteListaAdd(listaSorteable, "Merlina");
//		ClienteListaAdd cliente4 = new ClienteListaAdd(listaSorteable, "Luis");
//		ClienteListaAdd cliente5 = new ClienteListaAdd(listaSorteable, "Roberto");
//		ClienteListaAdd cliente6 = new ClienteListaAdd(listaSorteable, "Julian");
//		ClienteListaAdd cliente7 = new ClienteListaAdd(listaSorteable, "a");
//		ClienteListaAdd cliente8 = new ClienteListaAdd(listaSorteable, "b");
//		ClienteListaAdd cliente9 = new ClienteListaAdd(listaSorteable, "c");
//		ClienteListaAdd cliente10 = new ClienteListaAdd(listaSorteable, "d");
//		ClienteListaAdd cliente11 = new ClienteListaAdd(listaSorteable, "e");
//		
//		cliente1.start();
//		
//		cliente2.start();
//		cliente4.start();
//		cliente5.start();
//		cliente6.start();
//		cliente7.start();
//		cliente8.start();
//		cliente9.start();
//		cliente10.start();
//		cliente11.start();
		
		System.out.println("Lista final");
		System.out.println("");
		SyncList.printList(result);
		
	}
}
