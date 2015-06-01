package sorted.sync.list;


public class MainLista {

	public static void main(String[] args) {
		
		SyncList listaSorteable = new SyncList();
		ClienteListaSize cliente1 = new ClienteListaSize(listaSorteable, "Juan Carlos");
		ClienteListaAdd cliente2 = new ClienteListaAdd(listaSorteable, "Merlina");
//		ClienteListaSize cliente3 = new ClienteListaSize(listaSorteable, "Pedro");
		ClienteListaAdd cliente4 = new ClienteListaAdd(listaSorteable, "Luis");
		ClienteListaAdd cliente5 = new ClienteListaAdd(listaSorteable, "Roberto");
		ClienteListaAdd cliente6 = new ClienteListaAdd(listaSorteable, "Julian");
		ClienteListaAdd cliente7 = new ClienteListaAdd(listaSorteable, "a");
		ClienteListaAdd cliente8 = new ClienteListaAdd(listaSorteable, "b");
		ClienteListaAdd cliente9 = new ClienteListaAdd(listaSorteable, "c");
		ClienteListaAdd cliente10 = new ClienteListaAdd(listaSorteable, "d");
		ClienteListaAdd cliente11 = new ClienteListaAdd(listaSorteable, "e");
//		ClienteListaAdd cliente12 = new ClienteListaAdd(listaSorteable, "f");
//		ClienteListaAdd cliente13 = new ClienteListaAdd(listaSorteable, "g");
//		ClienteListaAdd cliente14 = new ClienteListaAdd(listaSorteable, "h");
//		ClienteListaAdd cliente15 = new ClienteListaAdd(listaSorteable, "i");
//		ClienteListaAdd cliente16 = new ClienteListaAdd(listaSorteable, "j");
//		ClienteListaAdd cliente17 = new ClienteListaAdd(listaSorteable, "k");
//		ClienteListaAdd cliente18 = new ClienteListaAdd(listaSorteable, "l");
//		ClienteListaAdd cliente19 = new ClienteListaAdd(listaSorteable, "m");
//		ClienteListaAdd cliente20 = new ClienteListaAdd(listaSorteable, "n");
//		ClienteListaAdd cliente21 = new ClienteListaAdd(listaSorteable, "o");
//		ClienteListaAdd cliente22 = new ClienteListaAdd(listaSorteable, "p");
//		ClienteListaAdd cliente23 = new ClienteListaAdd(listaSorteable, "q");
//		ClienteListaAdd cliente24 = new ClienteListaAdd(listaSorteable, "r");
		cliente1.start();
		cliente2.start();
//		cliente3.start();
		cliente4.start();
		cliente5.start();
		cliente6.start();
		cliente7.start();
		cliente8.start();
		cliente9.start();
		cliente10.start();
		cliente11.start();
//		cliente12.start();
//		cliente13.start();
//		cliente14.start();
//		cliente15.start();
//		cliente16.start();
//		cliente17.start();
//		cliente18.start();
//		cliente19.start();
//		cliente20.start();
//		cliente21.start();
//		cliente22.start();
//		cliente23.start();
//		cliente24.start();
		
	}
	
}
