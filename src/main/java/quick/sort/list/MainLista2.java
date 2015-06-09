package quick.sort.list;

import java.util.LinkedList;
import java.util.List;

public class MainLista2 {
 public static void main(String[] args) {
	
	 SyncAndSortList lista = new SyncAndSortList();
	 List<Integer> lista1 = new LinkedList<Integer>();
	 
	 Productor productor = new Productor(lista);
	 Consumidor consumidor = new Consumidor(lista);
	 productor.start();
	 consumidor.start();
	 
	 // Esto es un while(true)
	 // que debe ser cortado por el usuario
	 // el objetivo es ver como se bloquea y deja ver el size 
}
}
