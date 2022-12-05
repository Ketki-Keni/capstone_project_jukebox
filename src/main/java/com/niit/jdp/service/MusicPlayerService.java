/*
 * Author : Ketki Keni
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MusicPlayerService {
    Clip clip;
    public void play(String songPath) {
        //creating a file object to represent the song file
        File songFile = new File(songPath);
        try {
            //creating an object of AudioInputStream class
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(songFile);
            //getting a clip object from the AudioSystem
            clip = AudioSystem.getClip();
            //open the clip and load the audio input stream
            clip.open(audioInputStream);
            //setting a loop for the sound file
            clip.loop(clip.LOOP_CONTINUOUSLY);
            //start the clip
            clip.start();

            Scanner scanner = new Scanner(System.in);
            int option;
            do {
                option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    //pause
                    case 1: {
                        clip.stop();
                        break;
                    }
                    //resume
                    case 2: {
                        clip.start();
                        break;
                    }
                    //stop
                    case 3: {
                        clip.stop();
                        clip.close();
                        break;
                    }
                    default: {
                        System.out.println("Invalid option selected");
                    }
                }
            } while (option == 1 || option == 2);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception) {
            exception.printStackTrace();
        }
    }
}