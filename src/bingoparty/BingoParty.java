
package bingoparty;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
        
        
        while(true){
            if (ChronoUnit.SECONDS.between(t, LocalDateTime.now()) >= 5 ){
                t = LocalDateTime.now();
                System.out.println( partida.nextBall() );
            }

            try{
            if(input.ready()){  //Pausar 
                input.readLine();
                System.out.println("ploff");
            }
            }catch(Exception e){}
        }
        
    }


    
    
}
