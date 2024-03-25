
package bingoparty;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 

/**
 *
 * @author Manuel B.
 */
public class BingoParty{
    
    

    
    
    /**
     * Funcion main, logica principal del programa
     * 
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
        consoleGame(bfn);
        
    }

    /**
     * Lógica de partida desde un entorno de consola (Sin GUI)
     * @param input 
     */
    private static void consoleGame(BufferedReader input) {
        
        Bingo partida = new Bingo();    //Partida por defecto
        LocalDateTime t = LocalDateTime.now();  //Nos sirve para contar segundos
        AudioPlayer player = new AudioPlayer(); //Reproductor de audio

        System.out.println("Pulsa intro para comenzar");
        try{
            input.readLine();
        }catch (Exception e){
            System.out.println(e);
        }
        
        System.out.println("*** COMIENZA LA PARTIDA! ***");
        
        while(partida.nextBall() != 0){
            player.playDrumEffect();
            while(ChronoUnit.SECONDS.between(t, LocalDateTime.now()) <= partida.getTimeNext() ) {   
                pauseConsoleGameLogic(input);   
            }
        
            t = LocalDateTime.now();
            player.playNumber(partida.lastBall());
            System.out.println( partida.lastBall() );
  
        }
        
    }

    
    /**
     * Funcion de pausa, contiene la lógica de cuando el juego entra en pausa
     * 
     * @param input entrada de teclado
     */
    private static void pauseConsoleGameLogic(BufferedReader input) {
        //Pausar
        
        try{
            if(input.ready()){     //Si se introduce algo por teclado (pulsar intro) se activa la pausa  
                input.readLine();
                System.out.println("**** Pausa **** \n Intro para continuar");
                input.read();
            }
        } catch (IOException e){
            System.out.println(e);
        }
        
    }

    
    

   
    
}
