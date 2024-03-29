
package bingoparty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        
        //test();
        Scanner input = new Scanner(System.in);
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
        consoleGame(bfn);
        
    }

    private static void test(){
        ConsoleNumbers cn = new ConsoleNumbers();
        cn.printNum((byte) 86);
    }
    
    
    /**
     * Lógica de partida desde un entorno de consola (Sin GUI)
     * @param input 
     */
    private static void consoleGame(BufferedReader input) {

        ConsoleGame game = new ConsoleGame(input);
        game.start();
             
    }

    
    /**
     * Funcion de pausa, contiene la lógica de cuando el juego entra en pausa
     * 
     * @param input entrada de teclado
     */
    

    
    

   
    
}
