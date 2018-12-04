package problemes_binari;

import java.io.*;

public class EstadoPartida {
	static int [][] posicio = new int[3][3];
	static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	public static void main (String [] args) throws IOException, ClassNotFoundException {
		CrearPartida();
	}
	
	public static void CrearPartida() throws IOException, ClassNotFoundException {
		File fitxer = new File("FicherTresRaya.dat");
		FileOutputStream FileRaya = new FileOutputStream(fitxer);
		ObjectOutputStream DataOS = new ObjectOutputStream(FileRaya);
		posicio[0][0]=1;
		posicio[0][2]=1;
		posicio[0][1]=2;
		posicio[1][0]=0;
		posicio[1][1]=2;
		posicio[1][2]=0;
		posicio[2][0]=1;
		posicio[2][1]=0;
		posicio[2][2]=0;
		TresRaya tresenraya = new TresRaya (posicio,1);
		CambiarPosicion(tresenraya,posicio,DataOS);
	}
	
	public static void CambiarPosicion(TresRaya tresenraya,int[][]posicio, ObjectOutputStream DataOS) throws IOException, ClassNotFoundException {
		posicio[2][2]=2;
		tresenraya.setPosicio(posicio);
		GuardarPartida(DataOS,tresenraya);
	}
	
	public static void GuardarPartida(ObjectOutputStream DataOS, TresRaya tresenraya) throws IOException, ClassNotFoundException {
		DataOS.writeObject(tresenraya);
		DataOS.close();
		CargarPartida();
	}
	
	public static void CargarPartida() throws IOException, ClassNotFoundException{
		TresRaya tresenraya;
		File fichero = new File("FicherTresRaya.dat");
		FileInputStream filein = new FileInputStream(fichero);
		ObjectInputStream DataIS = new ObjectInputStream (filein);
		tresenraya = (TresRaya)DataIS.readObject();
		MostrarPosicion(tresenraya);
		DataIS.close();
		
	}
	
	public static void MostrarPosicion(TresRaya tresenraya) {
		System.out.println("Toca al jugador: "+tresenraya.getTurno());
		int [][] pos=tresenraya.getPosicio();
		ImprimirPerPantalla(pos);
	}
	
	public static void ImprimirPerPantalla(int[][] pos) {
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				System.out.print(" ");
				if (pos[i][j]==0) {
					System.out.print(" ");
				}
				else if(pos[i][j]==1) {
					System.out.print("X");
				}
				else {
					System.out.print("O");
				}
				System.out.print(" |");
			}
			System.out.println("");
		}
	}
	

}


