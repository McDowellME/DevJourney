package com.wilma.controller;

import com.wilma.cast.NonPlayableCharacter;
import com.wilma.cast.PlayableCharacter;
import com.wilma.cast.PlayableCharacterLoader;
import com.wilma.jobhunt.ending.Beginning;
import com.wilma.jobhunt.ending.Ending;
import com.wilma.routes.RouteValidation;
import com.wilma.routes.RouteInfo;
import com.wilma.routes.RouteNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final RouteInfo routeInfo = new RouteInfo();
    private final Scanner scanner = new Scanner(System.in);
    private List<PlayableCharacter> pcList = routeInfo.pcList;
    private PlayableCharacter player;

    public void execute() {
        greetUser();
        loadCharacters();
        selectCharacter();
        runGameLoop();
    }

    public void greetUser() {
        try {
            Beginning.beginningMessage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        enterAnyKeyToContinue();
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
        showCharactersAndAttributes();
        System.out.println("Choose your character:");

        while (true) {
            int characterIdx = 0;

            for (PlayableCharacter character : pcList) {
                System.out.print("[" + characterIdx + "] " + character.getName() + "\t");
                characterIdx++;
            }
            System.out.println();
            String input = scanner.nextLine();

            if (isValidInput(input, pcList.size())) {
                player = pcList.get(Integer.parseInt(input));
                break;
            } else {
                System.out.println();
                printInvalidInputMsg(pcList.size());
            }
        }
    }

    private void showCharactersAndAttributes() {
        int characterIdx = 0;

        for (PlayableCharacter character : pcList) {
            readTextFile(character.getTextFile());
            System.out.println();
            System.out.println("[" + characterIdx + "] " + character.introduction() + "\n");
            characterIdx++;
        }
    }

    private void runGameLoop() {
        RouteNode curNode = routeInfo.getStartNode();

        while (true) {
            if (curNode.getId() == 38) return;
            if (curNode.getId() == 21) {
                try {
                    Ending.alienMessage();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                enterAnyKeyToContinue();

            }
            if (curNode.hasNPCs()) {

                for (NonPlayableCharacter npc : curNode.getNPCs()) {
                    readTextFile(npc.getTextFile());
                    System.out.println(npc.introduction());
                }
                enterAnyKeyToContinue();
            }
            if (curNode.getRouteKey() != null) {
                boolean passedAttrCheck =
                        RouteValidation.decipherKey(player, curNode);
                curNode = passedAttrCheck ?
                        curNode.getChildren().get(1) :
                        curNode.getChildren().get(0);
                System.out.println(curNode.getMessage());
                enterAnyKeyToContinue();
            } else {
                if (curNode.getChildren().size() == 1) {
                    System.out.println("\n" + curNode.displayChoice());
                    enterAnyKeyToContinue();
                    curNode = curNode.getChildren().get(0);
                } else {
                    System.out.println("Please choose from the options below:\n");
                    List<String> routeChoices = curNode.displayRouteChoices();
                    int len = routeChoices.size();

                    for (int i = 0; i < len; i++) {
                        if (i != 0) System.out.print("\t");
                        System.out.print("[" + i + "] " + routeChoices.get(i) + "\t");
                        if (i != len - 1) System.out.print("|");
                    }
                    System.out.println();
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

    private void enterAnyKeyToContinue() {
        System.out.println("\nEnter any key to continue:");
        scanner.nextLine();
        System.out.println();
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
        System.out.println("** Invalid input," +
                " must be a number 0 - " + (size - 1) + " **");
    }
}