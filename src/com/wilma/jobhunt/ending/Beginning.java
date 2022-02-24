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

//        String art = " █     █░▓█████  ██▓     ▄████▄   ▒█████   ███▄ ▄███▓▓█████    ▄▄▄█████▓ ▒█████      ▄▄▄██▀▀▀▒█████   ▄▄▄▄       ██░ ██  █    ██  ███▄    █ ▄▄▄█████▓ ▐██▌ \n" +
//                "▓█░ █ ░█░▓█   ▀ ▓██▒    ▒██▀ ▀█  ▒██▒  ██▒▓██▒▀█▀ ██▒▓█   ▀    ▓  ██▒ ▓▒▒██▒  ██▒      ▒██  ▒██▒  ██▒▓█████▄    ▓██░ ██▒ ██  ▓██▒ ██ ▀█   █ ▓  ██▒ ▓▒ ▐██▌ \n" +
//                "▒█░ █ ░█ ▒███   ▒██░    ▒▓█    ▄ ▒██░  ██▒▓██    ▓██░▒███      ▒ ▓██░ ▒░▒██░  ██▒      ░██  ▒██░  ██▒▒██▒ ▄██   ▒██▀▀██░▓██  ▒██░▓██  ▀█ ██▒▒ ▓██░ ▒░ ▐██▌ \n" +
//                "░█░ █ ░█ ▒▓█  ▄ ▒██░    ▒▓▓▄ ▄██▒▒██   ██░▒██    ▒██ ▒▓█  ▄    ░ ▓██▓ ░ ▒██   ██░   ▓██▄██▓ ▒██   ██░▒██░█▀     ░▓█ ░██ ▓▓█  ░██░▓██▒  ▐▌██▒░ ▓██▓ ░  ▓██▒ \n" +
//                "░░██▒██▓ ░▒████▒░██████▒▒ ▓███▀ ░░ ████▓▒░▒██▒   ░██▒░▒████▒     ▒██▒ ░ ░ ████▓▒░    ▓███▒  ░ ████▓▒░░▓█  ▀█▓   ░▓█▒░██▓▒▒█████▓ ▒██░   ▓██░  ▒██▒ ░  ▒▄▄  \n" +
//                "░ ▓░▒ ▒  ░░ ▒░ ░░ ▒░▓  ░░ ░▒ ▒  ░░ ▒░▒░▒░ ░ ▒░   ░  ░░░ ▒░ ░     ▒ ░░   ░ ▒░▒░▒░     ▒▓▒▒░  ░ ▒░▒░▒░ ░▒▓███▀▒    ▒ ░░▒░▒░▒▓▒ ▒ ▒ ░ ▒░   ▒ ▒   ▒ ░░    ░▀▀▒ \n" +
//                "  ▒ ░ ░   ░ ░  ░░ ░ ▒  ░  ░  ▒     ░ ▒ ▒░ ░  ░      ░ ░ ░  ░       ░      ░ ▒ ▒░     ▒ ░▒░    ░ ▒ ▒░ ▒░▒   ░     ▒ ░▒░ ░░░▒░ ░ ░ ░ ░░   ░ ▒░    ░     ░  ░ \n" +
//                "  ░   ░     ░     ░ ░   ░        ░ ░ ░ ▒  ░      ░      ░        ░      ░ ░ ░ ▒      ░ ░ ░  ░ ░ ░ ▒   ░    ░     ░  ░░ ░ ░░░ ░ ░    ░   ░ ░   ░          ░ \n" +
//                "    ░       ░  ░    ░  ░░ ░          ░ ░         ░      ░  ░                ░ ░      ░   ░      ░ ░   ░          ░  ░  ░   ░              ░           ░    \n" +
//                "                        ░                                                                                  ░                                               ";
//
//        System.out.print(art);
//        String art2 ="    _      ___   _   __  __ ___   ___ ___  ___  _   _  ___ _  _ _____   _____ ___   __   _____  _   _   _____   __ __      _____ _    __  __   _     _    _    ___ _ \n" +
//                "   /_\\    / __| /_\\ |  \\/  | __| | _ | _ \\/ _ \\| | | |/ __| || |_   _| |_   _/ _ \\  \\ \\ / / _ \\| | | | | _ \\ \\ / / \\ \\    / |_ _| |  |  \\/  | /_\\   | |  | |  / __| |\n" +
//                "  / _ \\  | (_ |/ _ \\| |\\/| | _|  | _ |   | (_) | |_| | (_ | __ | | |     | || (_) |  \\ V | (_) | |_| | | _ \\\\ V /   \\ \\/\\/ / | || |__| |\\/| |/ _ \\ _| |__| |_| (__|_|\n" +
//                " /_/ \\_\\  \\___/_/ \\_|_|  |_|___| |___|_|_\\\\___/ \\___/ \\___|_||_| |_|     |_| \\___/    |_| \\___/ \\___/  |___/ |_|     \\_/\\_/ |___|____|_|  |_/_/ \\_( |____|____\\___(_)\n" +
//                "                                                                                                                                                  |/                 ";
//
//        System.out.print(art2 + "\n");

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