package quick.sort.list;

public class Counter {

	public Integer cont;
	

	public Counter(Integer initial) {
		this.cont = initial;
	}

	public synchronized void decrementar() {
		this.cont = this.cont -1;
		if (this.cont == 0) {
			notifyAll();
		}
	}

	public synchronized void waitZero() {
		while (this.cont != 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
