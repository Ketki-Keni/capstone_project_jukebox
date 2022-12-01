/*
 * Author : Ketki Keni
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayerService {
    public void play(String songPath) {
        //creating a file object to represent the song file
        File songFile = new File(songPath);
        try {
            //creating an object of AudioInputStream class
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(songFile);
            //getting a clip object from the AudioSystem
            Clip clip = AudioSystem.getClip();
            //open the clip and load the audio input stream
            clip.open(audioInputStream);
            //setting a loop for the sound file
            clip.loop(clip.LOOP_CONTINUOUSLY);
            //start the clip
            clip.start();
            //getting the exact length of the song in milliseconds
            long songlength = clip.getMicrosecondLength() / 1000L;
            //Pause the current thread for the time the song is playing
            Thread.sleep(songlength);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception) {
            exception.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("The song was interrupted");
        }
    }

    public void stop() {

    }
}
