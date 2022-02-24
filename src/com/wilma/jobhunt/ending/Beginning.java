package com.wilma.jobhunt.ending;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Beginning {

    //this is will display at the beginning of the game
    public static void beginningMessage() throws InterruptedException {

        readTextFile("resources/Welcome.txt");
        System.out.println();

        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(
                    new File("resources/StartSound.wav")));
            Thread.sleep(700);
            clip.start();
            Thread.sleep(7000);
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