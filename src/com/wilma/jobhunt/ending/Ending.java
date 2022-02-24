package com.wilma.jobhunt.ending;

import com.apps.util.Console;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//Using this class to store the different endings
public class Ending {

    //this is the ending we'll use when the user explores the glowing rock
    public static void alienMessage() throws InterruptedException {

        readTextFile("resources/GameOver.txt");
        readTextFile("resources/Alien.txt");

        System.out.println("\nSilly human, you foolishly inspected the glowing rock.\nYou are now a puppet of the Glore Gax alien race....\n\n");//character name getter will be added into with this statement

        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(
                    new File("resources/alienmessage.wav")));
            Thread.sleep(800);
            clip.start();
            Thread.sleep(6000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void readTextFile(String resourceFilePath) {
        try {
            String image = Files.readString(Path.of(resourceFilePath));
            System.out.println(image);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}