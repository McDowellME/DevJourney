package com.wilma.controller;

import com.wilma.cast.NonPlayableCharacter;
import com.wilma.cast.PlayableCharacter;
import com.wilma.cast.PlayableCharacterLoader;
import com.wilma.routes.RouteValidation;
import com.wilma.routes.RouteInfo;
import com.wilma.routes.RouteNode;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final RouteInfo routeInfo = new RouteInfo();
    private final Scanner scanner = new Scanner(System.in);
    private List<PlayableCharacter> pcList;
    private PlayableCharacter player;

    public void execute() {
        loadCharacters();
        createCharacter();
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

    private void createCharacter() {
        int characterIdx = 0;
        for (PlayableCharacter character : pcList) {
            System.out.println("[" + characterIdx + "] " + character.introduction());
            characterIdx++;
        }

        System.out.println("\nChoose your character:");
        String input = scanner.nextLine();

        if (isValidInput(input, pcList.size())) {
            player = pcList.get(input);
        }
        System.out.println(player.introduction());
    }

    private void runGameLoop() {
        RouteNode curNode = routeInfo.getStartNode();

        while (true) {
            if (curNode.hasNPCs()) {
                for (NonPlayableCharacter npc : curNode.getNPCs()) {
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
            } else {
                System.out.println("Please choose from the options below:");
                curNode.displayRouteChoices();
                String input = scanner.nextLine();

                if (isValidInput(input, curNode.getChildren().size())) {
                    curNode = curNode.getChildren().get(Integer.parseInt(input));
                } else {
                    System.out.println("Invalid input");
                }
            }
        }
    }

    private static boolean isValidInput(String input, int numChoices) {
        if (!isNumeric(input)) return false;
        int num = Integer.parseInt(input);

        for (int i = 0; i < numChoices; i++) {
            if (num == i) return true;
        }
        return false;
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
}