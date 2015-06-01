package sorted.sync.list;

public class ThreadsHandler {

	Integer cantMax;
	
	public ThreadsHandler(Integer max) {
		this.cantMax = max;
	}
	
	public synchronized Boolean hasThread() {
		if (this.cantMax > 0) {
			this.cantMax--;
			return true;
		}
		return false;
	}
	
	public synchronized void releaseThread() {
		this.cantMax ++;
	}
	
}
