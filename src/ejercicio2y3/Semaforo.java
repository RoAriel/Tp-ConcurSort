package ejercicio2y3;

import java.util.concurrent.locks.Condition;

public class Semaforo {

	private int permisos;
	private int esperando;
	private Condition hayPermisos;

	public Semaforo(int cantPermisos) {
		this.permisos = cantPermisos;
	}

	public synchronized void acquire(){
		if (permisos == 0) {
			esperando++;
			try {
				hayPermisos.wait();
			} catch (InterruptedException e) {}
			esperando--;
		} else
			permisos--;
	}

	public synchronized void release() {
		if(esperando == 0){
			permisos++;
		}else{
			hayPermisos.notify();
		}

	}

}
