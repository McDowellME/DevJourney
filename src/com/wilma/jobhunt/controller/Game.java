package com.wilma.jobhunt.controller;

import com.wilma.jobhunt.cast.NonPlayableCharacter;
import com.wilma.jobhunt.cast.PlayableCharacter;
import com.wilma.jobhunt.cast.PlayableCharacterLoader;
import com.wilma.jobhunt.client.Main;
import com.wilma.jobhunt.events.Beginning;
import com.wilma.jobhunt.events.Ending;
import com.wilma.jobhunt.routes.RouteValidation;
import com.wilma.jobhunt.routes.RouteInfo;
import com.wilma.jobhunt.routes.RouteNode;
import com.apps.util.Console;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final RouteInfo routeInfo = new RouteInfo();
    private final Scanner scanner = new Scanner(System.in);
    private List<PlayableCharacter> pcList;
    private PlayableCharacter player;
    private static final String PLCHAR_FILE_PATH = "data/pccharacter-data.csv";
    private static final int RESTART_NODE_ID = 37;
    private static final int QUIT_NODE_ID = 38;
    private static final int ALIEN_NODE_ID = 21;

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
                new PlayableCharacterLoader(PLCHAR_FILE_PATH);
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

        while (true) {
            for (PlayableCharacter character : pcList) {
                readTextFile(character.getTextFile());
                System.out.println();
                System.out.println("[" + characterIdx + "] " + character.introduction() + "\n");
                characterIdx++;
                int cIdx = 0;
                System.out.println("Choose your character or enter any key to continue:");

                for (PlayableCharacter c : pcList) {
                    System.out.print("[" + cIdx + "] " + c.getName() + "\t");
                    cIdx++;
                }
                System.out.println();
                String input = scanner.nextLine();
                Console.clear();
                if (isValidInput(input, pcList.size())) {
                    player = pcList.get(Integer.parseInt(input));
                    return;
                }
            }
            characterIdx = 0;
        }
    }

    private void runGameLoop() {
        RouteNode curNode = routeInfo.getStartNode();

        while (true) {
            if (curNode.getId() == RESTART_NODE_ID) restartGame();
            if (curNode.getId() == QUIT_NODE_ID) exitGame();
            if (curNode.getId() == ALIEN_NODE_ID) alienEnding();
            if (curNode.hasNPCs()) spawnNPCs(curNode);
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
                    Console.clear();

                    if (isValidInput(input, curNode.getChildren().size())) {
                        curNode = curNode.getChildren().get(Integer.parseInt(input));
                    } else {
                        printInvalidInputMsg(curNode.getChildren().size());
                    }
                }
            }
        }
    }

    private void spawnNPCs(RouteNode node) {
        for (NonPlayableCharacter npc : node.getNPCs()) {
            readTextFile(npc.getTextFile());
            System.out.println(npc.introduction());
        }
        enterAnyKeyToContinue();
    }

    private static void restartGame() {
        String[] args = new String[0];
        Main.main(args);
    }

    private static void exitGame() {
        System.exit(0);
    }

    private void alienEnding() {
        try {
            Ending.alienMessage();
        } catch (Exception e) {
            System.out.println("You have been abducted by aliens");
        }
        enterAnyKeyToContinue();
    }

    private void enterAnyKeyToContinue() {
        System.out.println("\nEnter any key to continue:");
        scanner.nextLine();
        Console.clear();
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

    private static void printInvalidInputMsg(int size) {
        System.out.println("** Invalid input," +
                " must be a number 0 - " + (size - 1) + " **");
    }
}