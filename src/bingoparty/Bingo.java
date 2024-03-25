
package bingoparty;

import java.util.ArrayList;
import java.lang.Math;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Clase Bingo, representa un tambor para jugar al bingo, que contiene todas las bolas del juego y tiene 
 * la capacidad ir soltando bolas(numeros) de manera aleatoria
 * 
 * @author Manuel B.
 */
public class Bingo {
    
    public final byte GAME_90 = 90;  //Partida de 90 bolas
    public final byte GAME_75 = 75;  //Partida de 75 bolas
    private boolean autoNext;        //Canta automáticamente el siguiente numero
    private int timeNext;            //Tiempo que tarda en cantar el proximo numero si autoNext está activo
    private byte maxNum;             //Maximo numero en una bola
    private byte drumBallsNum;       //Cantidad de bolas en el bombo
    
    private boolean debug = true;
   
    private ArrayList<Byte> drum = new ArrayList<>(); //Representa el bombo del bingo, contiene todos los numeros al inicio de la partida
    private ArrayList<Byte> tray = new ArrayList<>(); //Los numeros retirados se iran insertando en la "bandeja"
    
   
    
    /**
     * Constructor con partida por defecto,
     * Canta de manera automática cada 5 segundos, bombo con 90 bolas
     */
    public Bingo(){ 
        this.autoNext = true;
        this.timeNext = 5;
        this.drumBallsNum = GAME_90;
        fillDrum(this.drumBallsNum);
        
    }
    
    public Bingo(boolean autoNext, int timeNext, int type ){
        this.autoNext = autoNext;
        this.timeNext = timeNext;
        if(type == 0){
            this.drumBallsNum = GAME_90;
        } else{
            this.drumBallsNum = GAME_75;
        }
        fillDrum(this.drumBallsNum);
    }

    /**
     * Sacamos la siguiente bola del bombo y la ponemos en la bandeja
     * 
     * @return numero de la bola retirada
     */
    public byte nextBall(){
        
        if(drum.size() == 0)    //Si no quedan bolas devolvemos 0, representa el final del juego
            return 0;
        
        byte nextBall = (byte) ( Math.random() * (this.drum.size()-1) ); //Numero aleatorio entre 0 y el numero maximo del arraylist
        tray.add(drum.remove(nextBall));    //Sacamos del bombo e insertamos en la bandeja
        
        return tray.get(tray.size() -1 );
        
    }
    
  
    /**
     * Llenamos el bombo con todos los numeros del juego
     * 
     * @param ballsNumber numero de bolas (equivalente al numero de máximo valor)
     */
    private void fillDrum(byte ballsNumber){
    
        for( byte n = 1 ; n <= ballsNumber ; n++){
            drum.add(n);
        }
        
    }
    
    public void consoleGame(){
        
       

        
        
    }
    
    
}
