package ejercicio2y3;

public class Contador {
	
	private int total;
	
	public Contador(){
		total = 0;
	}
	
	public int getTotal(){
		return total;
	}
	public synchronized void contar(int x){
		for (int i = 0; i < x; i++) {
			total = i;
			System.out.println(this.getTotal());
		}
	}
	
	public static void main(String args[]) {
		try {
			Contador c1 = new Contador();
			CThread thread1 = new CThread(c1, 10);
			CThread thread2 = new CThread(c1,10);
			thread1.start();
			thread2.start();
			System.out.println(c1.getTotal());
		} catch (Exception e) {
		}
	}
}
