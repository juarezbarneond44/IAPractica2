package practica22;
import robocode.*;
import java.util.LinkedList;
import java.io.*;
//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

public class Juanis2 extends Robot
{
	
	/**
	 * run: Juanis's default behavior
	 */
	LinkedList<QDato> QDataList = new LinkedList<QDato>();
	LinkedList<Mina> QMina = new LinkedList<Mina>();
	int SalidaX=0,	SalidaY=0;
	public void run() {
	
    	leerQTable();
    	//LeerMinas();
	  
		
	  
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(100);
			turnGunRight(360);
			back(100);
			turnGunRight(360);;
		
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(1);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10); 
		
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}
	
	private void LeerMinas() {
		 File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
	  	  try{
		   archivo = new File("C:\\robocode\\practica2\\Minas.txt");
	       fr = new FileReader (archivo);
	       br = new BufferedReader(fr);
		   // vamos a leer el archivo de texto 
		   // se guardara en un arreglo de datos para tener informacion 
	       String linea;
	       boolean Salida=true;
	       while((linea=br.readLine())!=null) {
	    		out.println(linea);
	    	   String aux[]=linea.split(",");
	    	   if(Salida) {
	    		  this.SalidaX=Integer.parseInt(aux[0]);
	    		  this.SalidaY=Integer.parseInt(aux[1]);
	    		   Salida=false;
	    		   break;
	    	   }
	           this.QMina.addLast(new Mina(Integer.parseInt(aux[0]),Integer.parseInt(aux[1])));
	             }
	       fr.close();   
	  	  }
		  catch(Exception e){
	       e.printStackTrace();
		  }finally{
		         try{                    
		            if( null != fr ){   
		               fr.close();     
		            }                  
		         }catch (Exception e2){ 
		            e2.printStackTrace();
		         }
		      }
		

		
		
	}
	private void CargarDatoQtable(int posX,int posY,QDato Qdato){
		// se cargaron los datos de la QTABLE
	       FileWriter fichero = null;
	       PrintWriter pw = null;
	   	  try{
	       fichero = new FileWriter("C:\\robocode\\practica2\\201700556_201503608.tabla",true);
	       pw = new PrintWriter(fichero);
	       	 pw.println(posX+";"+posY+";"+Qdato.arriba+";"+Qdato.abajo+";"+Qdato.izquierda+";"+Qdato.derecha);
	       fichero.close();
	   	  }
	 	  catch(Exception e){
	 	       e.printStackTrace();
	 		  }finally{
	 		         try{                    
	 		            if( null != fichero ){   
	 		            	fichero.close();     
	 		            }                  
	 		         }catch (Exception e2){ 
	 		            e2.printStackTrace();
	 		         }
	 		      }		  
	  	  	 
	
	}
	private void leerQTable(){
	  File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
  	  try{
	   archivo = new File("C:\\robocode\\practica2\\201700556_201503608.tabla");
       fr = new FileReader (archivo);
       br = new BufferedReader(fr);
	   // vamos a leer el archivo de texto
	   // se guardara en un arreglo de datos para tener informacion
       String linea;
 
       while((linea=br.readLine())!=null) {	 
    	   String aux[]=linea.split(";");
          	this.QDataList.addLast(new QDato(Integer.parseInt(aux[0]),Integer.parseInt(aux[1]),Double.parseDouble(aux[2]),Double.parseDouble(aux[3]),Double.parseDouble(aux[4]),Double.parseDouble(aux[5])));
   
       }
       fr.close();   
  	  }
	  catch(Exception e){
       e.printStackTrace();
	  }finally{
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	

	}
}
 class Mina{
	 int PosX,PosY;
	  public Mina(int PosX,int PosY) {
		  this.PosX=PosX;
		  this.PosY=PosY;
	  }
 }
 class QDato{
    int PosX,PosY;
    double arriba,abajo,derecha,izquierda;
    public QDato(int PosX,int PosY,double arriba,double abajo,double izquierda,double derecha) {
        this.PosX=PosX;
        this.PosY=PosY;
        this.arriba=arriba;
        this.abajo=abajo;
        this.derecha=derecha;
        this.izquierda=izquierda;  
    }
     

}