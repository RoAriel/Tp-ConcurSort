package ejercicio1;

public class MiMonitor {

	public int i = 0;

	public synchronized void add() {
		for (i = 0; i < 100000; ++i)
			;
		System.out.println(i);
	}

	public  int get() {
		return i;
	}

	public static void main(String args[]) {
		try {
			MiMonitor s = new MiMonitor();
			MiThread thread1 = new MiThread(s);
			MiThread thread2 = new MiThread(s);
			thread1.start();
			thread2.start();
			System.out.println(s.get());
		} catch (Exception e) {
		}
	}
}
