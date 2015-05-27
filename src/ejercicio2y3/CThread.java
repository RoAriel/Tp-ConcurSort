package ejercicio2y3;

public class CThread extends Thread {
	
	private Contador c;
	private int num;

	public CThread(Contador cont, int x) {
		c = cont;
		num = x;
	}

	public void run() {
		
		c.contar(num);
	}

}
