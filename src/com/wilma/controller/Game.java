package com.wilma.controller;

import com.wilma.cast.NonPlayableCharacter;
import com.wilma.cast.PlayableCharacter;
import com.wilma.cast.PlayableCharacterLoader;
import com.wilma.routes.RouteValidation;
import com.wilma.routes.RouteInfo;
import com.wilma.routes.RouteNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private final RouteInfo routeInfo = new RouteInfo();
    private final Scanner scanner = new Scanner(System.in);
    private List<PlayableCharacter> pcList = routeInfo.pcList;
    private PlayableCharacter player;

    public void execute() {
        loadCharacters();
        selectCharacter();
        runGameLoop();
    }

    public void loadCharacters() {
        PlayableCharacterLoader pcl =
                new PlayableCharacterLoader("data/pccharacter-data.csv");
        try {
            pcList = pcl.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readTextFile(String resourceFilePath) {
        try {
            String image = Files.readString(Path.of(resourceFilePath));
            System.out.println(image);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    private void selectCharacter() {
        int characterIdx = 0;

        for (PlayableCharacter character : pcList) {
            readTextFile(character.getTextFile());
            System.out.println();
            System.out.println("[" + characterIdx + "] " + character.introduction() + "\n");
            characterIdx++;
        }
        characterIdx = 0;
        System.out.println("Choose your character:");

        for (PlayableCharacter character : pcList) {
            System.out.print("[" + characterIdx + "] " + character.getName() + "\t");
            characterIdx++;
        }
        System.out.println();
        String input = scanner.nextLine();

        if (isValidInput(input, pcList.size())) {
            player = pcList.get(Integer.parseInt(input));
        } else {
            printInvalidInputMsg(pcList.size());
        }
    }

    private void runGameLoop() {
        RouteNode curNode = routeInfo.getStartNode();

        while (true) {
            if (curNode.hasNPCs()) {
                for (NonPlayableCharacter npc : curNode.getNPCs()) {
                    readTextFile(npc.getTextFile());
                    System.out.println(npc.introduction());
                }
            }
            if (curNode.getRouteKey() != null) {
                boolean passedAttrCheck =
                        RouteValidation.decipherKey(player, curNode);
                curNode = passedAttrCheck ?
                        curNode.getChildren().get(1) :
                        curNode.getChildren().get(0);
                System.out.println(curNode.getMessage());
                System.out.println("Enter any key to continue:");
                scanner.nextLine();
                System.out.println();
            } else {
                if (curNode.getChildren().size() == 1) {
                    System.out.println();
                    curNode.displayChoice();
                    System.out.println("Enter any key to continue:");
                    scanner.nextLine();
                    System.out.println();
                    curNode = curNode.getChildren().get(0);
                } else {
                    System.out.println("Please choose from the options below:");
                    curNode.displayRouteChoices();
                    String input = scanner.nextLine();
                    System.out.println();
                    if (isValidInput(input, curNode.getChildren().size())) {
                        curNode = curNode.getChildren().get(Integer.parseInt(input));
                    } else {
                        printInvalidInputMsg(curNode.getChildren().size());
                    }
                }
            }
        }
    }

    private static boolean isValidInput(String input, int numChoices) {
        if (!isNumeric(input)) return false;
        int num = Integer.parseInt(input);
        return (num >= 0 && num < numChoices);
    }

    private static boolean isNumeric(String input) {
        if (input == null) return false;

        try {
            Integer num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private void printInvalidInputMsg(int size) {
        System.out.println("Invalid input," +
                " must be a number 0 - " + (size - 1));
    }
}