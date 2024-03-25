
package bingoparty;

import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Manuel B.
 */
public class AudioPlayer {
 
    private Clip clip; 
    private AudioInputStream audioInputStream; 
    
    
    /**
     * Reproduce el audio de un numero 
     * @param n numero a reproducir, del 1 al 90
     */
    public void playNumber(int n){   
        String filePath = "audio/nums/coletillas/"+n+".wav";
        File f = new File(filePath);
        if(f.exists()){
            this.playSound(filePath);
        } else{
            this.playSound("audio/nums/"+n+".wav");
        }
    }
    
    public void playDrumEffect(){
        this.playSound("audio/tambor.wav");
    }
    
    /**
     * Reproducir un sonido existente en los archivos de audio
     * Se encarga de esperar si hay otro sonido reproduciéndose, a demás
     * se encarga de cerrar el flujo de audio si se abrió previamente, lo que evita abrir hilos 
     * @param filePath ruta al archivo
     */
    public void playSound(String filePath){   
        try{
            
            if(clip != null){
                while(clip.isRunning()){
                    //esperamos si otro audio todavía se esta reproduciendo
                }
                if(clip.isOpen()){
                    clip.close();
                }
            }
            //TODO: debe hacerse relativo al ejecutable, actualmente está relativo a CWD
            audioInputStream =  AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile()); 
            clip = AudioSystem.getClip();  
            clip.open(audioInputStream); 
            clip.start();
            while(!clip.isRunning()){
                /*Esperamos hasta que se ejecute el audio, si no, puede que se intente reproducir otro sonido más rapido de lo que
                este pueda ser reproducido, lo que resulta en que nunca se llega a escuchar
                */
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
}
