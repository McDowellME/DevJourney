package com.wilma.jobhunt.events;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class Fail {

    public static void failMessage() throws InterruptedException {

        readTextFile("resources/Loser.txt");

        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(
                    new File("resources/Fail.wav")));
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