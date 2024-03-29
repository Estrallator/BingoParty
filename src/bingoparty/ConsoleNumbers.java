
package bingoparty;

import java.util.ArrayList;

/**
 *
 * @author Manuel B.
 */
public class ConsoleNumbers {
    
    private ArrayList<String> bigNums;
    private byte size;
    
    
    public ConsoleNumbers(){
        this.size = 5;
        this.bigNums = new ArrayList<>();
        this.populateArrayNumsFromLiteral();
    }
    
    public void printNum(byte n){
        
        String numberStr = Byte.toString(n);
        
        if( numberStr.length() == 1){
            System.out.println(bigNums.get(Integer.valueOf(n)).replaceAll("[^\s\n]", "\u25A0").replaceAll("[\s]","\u25A1"));
            System.out.println("\n");
        }
        else{
             
            int index = numberStr.charAt(0) -'0';
            int index2 =numberStr.charAt(1) -'0';
            
            String[] n1 =  bigNums.get(index).split("\n");
            String[] n2 =  bigNums.get(index2).split("\n");
            
            
            /*for ( int i = 0 ; i < n1.length ; i++){
                System.out.println( (n1[i] + n2[i]) ) ;
                
            }*/
            
            // Unimos los 2 numeros en una sola cadena y sustituimos los caracteres por simbolos que emulan un panel digital 
            for ( int i = 0 ; i < n1.length ; i++){
                
                System.out.println( (n1[i] + n2[i]).replaceAll("[^\s\n]", "\u25A0").replaceAll("[\s]","\u25A1") ) ;
            }
            System.out.println("\n");
        }
        
        
    }
    
    
    public void populateArrayNumsFromFile(){
        
    }
    
    /**
     * Funcion para insertar los numeros en el array
     * Inserta de manera manual las cadenas de texto que forman los caracteres
     */
    private void populateArrayNumsFromLiteral(){
        bigNums.add(" .d8888b.     \n" +
                    "d88P  Y88b    \n" +
                    "888    888    \n" +
                    "888    888    \n" +
                    "888    888    \n" +
                    "888    888    \n" +
                    "Y88b  d88P    \n" +
                    " \"Y8888P\"   \n");
        
        bigNums.add(" d888      \n" +
                    "d8888      \n" +
                    "  888      \n" +
                    "  888      \n" +
                    "  888      \n" +
                    "  888      \n" +
                    "  888      \n" +
                    "8888888    \n");
        bigNums.add(" .d8888b.     \n" +
                    "d88P  Y88b    \n" +
                    "       888    \n" +
                    "     .d88P    \n" +
                    " .od888P\"     \n" +
                    "d88P\"         \n" +
                    "888\"          \n" +
                    "888888888     ");
        bigNums.add(" .d8888b.     \n" +
                    "d88P  Y88b    \n" +
                    "     .d88P    \n" +
                    "    8888\"     \n" +
                    "     \"Y8b.    \n" +
                    "888    888    \n" +
                    "Y88b  d88P    \n" +
                    " \"Y8888P\"     ");
        bigNums.add("    d8888     \n" +
                    "   d8P888     \n" +
                    "  d8P 888     \n" +
                    " d8P  888     \n" +
                    "d88   888     \n" +
                    "8888888888    \n" +
                    "      888     \n" +
                    "      888     ");
        bigNums.add("888888888     \n" +
                    "888           \n" +
                    "888           \n" +
                    "8888888b.     \n" +
                    "     \"Y88b    \n" +
                    "       888    \n" +
                    "Y88b  d88P    \n" +
                    " \"Y8888P\"     ");
        bigNums.add(" .d8888b.     \n" +
                    "d88P  Y88b    \n" +
                    "888           \n" +
                    "888d888b.     \n" +
                    "888P \"Y88b    \n" +
                    "888    888    \n" +
                    "Y88b  d88P    \n" +
                    " \"Y8888P\"     ");
        bigNums.add("8888888888    \n" +
                    "      d88P    \n" +
                    "     d88P     \n" +
                    "    d88P      \n" +
                    "   8888       \n" +
                    "  d88P        \n" +
                    " d88P         \n" +
                    "d88P          ");
        bigNums.add(" .d8888b.     \n" +
                    "d88P  Y88b    \n" +
                    "Y88b. d88P    \n" +
                    " \"Y88888\"     \n" +
                    ".d8P\"\"Y8b.    \n" +
                    "888    888    \n" +
                    "Y88b  d88P    \n" +
                    " \"Y8888P\"     ");
        bigNums.add(" .d8888b.     \n" +
                    "d88P  Y88b    \n" +
                    "888    888    \n" +
                    "Y88b. d888    \n" +
                    " \"Y888P888    \n" +
                    "       888    \n" +
                    "Y88b  d88P    \n" +
                    " \"Y8888P\"     ");
    }
    
    
    
}
