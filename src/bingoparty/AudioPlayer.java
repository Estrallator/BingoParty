/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bingoparty;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Manuel B.
 */
public class AudioPlayer {
    private Long currentFrame; 
    private Clip clip; 
    private AudioInputStream audioInputStream; 
    
    
    /**
     * Reproduce el audio de un numero y se encarga de cerrar el flujo si existe alguno abierto. 
     * Así evitamos que se abran nuevos hilos de manera indefinida cada vez que reproducimos un audio
     * 
     * @param n numero a reproducir, del 1 al 90
     */
    public void playNumber(int n){   
        try{
            if(clip != null){
                if(clip.isOpen()){
                    clip.close();
                }
            }
            audioInputStream =  AudioSystem.getAudioInputStream(new File("audio/nums/"+n+".wav").getAbsoluteFile()); 
            clip = AudioSystem.getClip();  
            clip.open(audioInputStream); 
            clip.start();

            //clip.loop(Clip.LOOP_CONTINUOUSLY); 
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
