/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import backoffice.Form_menu;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.lang.*;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Atalanta
 */
public class Lib_aplikasi {
    private String rfid;
    private String nama;
    public static int menit;
    static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
  private static int getTotalMinutes(String time) {
    String[] t = time.split(":");
    return Integer.valueOf(t[0]) * 60 + Integer.valueOf(t[1]);
}
  private static String getResult(int total) {
    int minutes = total % 60;
    int hours = ((total - minutes) / 60) % 24;
    return String.format("%02d:%02d", hours, minutes);
} 
  public static int countHour(String time1,String time2){
   try {
            
            Date d1 = sdf.parse(time1);
            
            Date d2 = sdf.parse(time2);
  
            long elapsed = d2.getTime() - d1.getTime(); 
            
            int hours = (int) Math.floor(elapsed / 3600000);
            
            int minutes = (int) Math.floor((elapsed - hours * 3600000) / 60000);
            
            int seconds = (int) Math.floor((elapsed - hours * 3600000 - minutes * 60000) / 1000);
            menit= minutes;
//            System.out.format("From %s to %s%n", startTime, endTime);
//                                    
//            System.out.format("Time elapsed %d milliseconds%n", elapsed);
//            
//            System.out.format("%d hours %d minutes %d seconds%n", hours, minutes, seconds);

            return  hours;
         } catch (ParseException e) {
              e.printStackTrace();
              return  0;
         }
   
       
  }
  public static void click_sound(){
      String soundName = System.getProperty("user.dir")+"/src/wav/sound1.wav";    
        AudioInputStream audioInputStream;
        Clip clip = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
              clip = AudioSystem.getClip();
              clip.open(audioInputStream);
              clip.start();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Form_menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Form_menu.class.getName()).log(Level.SEVERE, null, ex);
        }catch (LineUnavailableException ex) {
            Logger.getLogger(Form_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
     
  
  
}
