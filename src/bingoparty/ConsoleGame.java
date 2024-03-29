/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bingoparty;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Manuel B.
 */
public class ConsoleGame {
    
    
    BufferedReader input;
    
    /**
     * Constructor, por el momento sólo establece el método de entrada por teclado
     * 
     * @param input sistema de entrada por teclado
     */
    public ConsoleGame(BufferedReader input){
        this.input = input;
    }
    
    
    public void start(){
        
        ConsoleNumbers consoleNums = new ConsoleNumbers(); //Numeros graficos en consola
        Bingo partida = new Bingo();    //Partida por defecto
        LocalDateTime t = LocalDateTime.now();  //Nos sirve para contar segundos
        AudioPlayer player = new AudioPlayer(); //Reproductor de audio

        //Esperamos a pulsar enter para comenzar la partida
        System.out.println("Pulsa intro para comenzar");
        try{
            input.readLine();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("****************************");
        System.out.println("*** COMIENZA LA PARTIDA! ***");
        System.out.println("****************************");
        
        
        while(partida.nextBall() != 0){     //Mientras existan bolas (cuando no quedan nextBall devuelve 0
            player.playDrumEffect();    //Efecto de tambor girando
            t = LocalDateTime.now();    //Reseteamos contador de segundos
            while(ChronoUnit.SECONDS.between(t, LocalDateTime.now()) <= partida.getTimeNext() ) { //mientras no pasen getTimeNext segundos
                pauseLogic(); //Ejecutamos la lógica para saber si el juego se ha querido pausar
            }
            player.playNumber(partida.lastBall());  //Canta la bola utilizando audio
            clearConsole();
            consoleNums.printNum(partida.lastBall() );   //Imprimir numero por pantalla   
        }
        
    }
    
    
    
    
    /**
     * Funcion para pausar el juego y otras funciones disponibles cuando el juego es pausado
     * 
     * @param input 
     */
    
    private void pauseLogic() {
        
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
    
    /**
     * Limpia salida en consola, util para crear fotogramas o tener una salida más limpia
     * NO FUNCIONA EN EL IDE, descomentar para release
     */
    public static void clearConsole(){
        /*try{
           final String os = System.getProperty("os.name");
            if (os.contains("Windows")){
                Runtime.getRuntime().exec("cls");
            } else{
                Runtime.getRuntime().exec("clear");
            } 
        }catch(Exception e){
            e.printStackTrace(); 
        }*/
    }
}
