package quick.sort.list;

public class Counter {

 Integer cont;
 Boolean isZero;

 public Counter(Integer initial) {
 	this.cont = initial;
 	this.isZero = false;
 }

 public synchronized void decrementar() {
 	if (this.isZero) {
 	notifyAll();
 	}

 	this.cont--;

 }

 public synchronized void waitZero() {

 	if (!this.isZero)
 	try {
 	wait();
 	} catch (InterruptedException e) {
 	e.printStackTrace();
 	}

 }
}