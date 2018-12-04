package problemes_binari;

import java.io.*;

public class TresRaya implements Serializable{
	private int [][] posicio;
	private int turno;
	
	public TresRaya(int[][] posicio,int turno ) {
		this.posicio=posicio;
		this.turno=turno;
	}
	
	public TresRaya() {
		this.posicio=null;
		this.turno=1;
	}
	
	public void setPosicio(int[][] posicio) {
		this.posicio=posicio;
	}
	
	public void setTurno(int turno) {
		this.turno=turno;
	}

	public int[][] getPosicio() {
		return posicio;
	}

	public int getTurno() {
		return turno;
	}
}
