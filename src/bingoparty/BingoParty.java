
package bingoparty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;



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

    private static void consoleGame(BufferedReader input) {
        
        Bingo partida = new Bingo();    //Partida por defecto
        
        LocalDateTime t = LocalDateTime.now();
        

     
        
        System.out.println("Pulsa intro para comenzar");
        try{
            input.readLine();
        }catch (Exception e){}
        
        System.out.println("*** COMIENZA! ***");
        
        while(partida.nextBall() != 0){
            while(ChronoUnit.SECONDS.between(t, LocalDateTime.now()) <= partida.getTimeNext() ) {

                try{
                    if(input.ready()){  //Pausar 
                        char o;
                        input.readLine();
                        System.out.println("**** Pausa **** \n\t Intro - continuar");
                        o = (char) input.read();
                        System.out.println(o);
                    }
                }catch(Exception e){
                    System.out.println(e); 
                }
                
            }
        
            t = LocalDateTime.now();
            System.out.println( partida.lastBall() );
        }
        
    }


    
    
}
