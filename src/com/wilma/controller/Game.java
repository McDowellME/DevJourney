package com.wilma.controller;

import com.wilma.cast.PlayableCharacter;
import com.wilma.cast.PlayableCharacterLoader;
import com.wilma.routes.RouteValidation;
import com.wilma.routes.RouteInfo;
import com.wilma.routes.RouteNode;

import java.io.IOException;
import java.util.Scanner;

public class Game {
    private final RouteInfo routeInfo = new RouteInfo();
    private final Scanner scanner = new Scanner(System.in);
    PlayableCharacter player;

    public void execute() {
        // loadCharacters();
        createCharacter();
        runGameLoop();
    }

    // character prompt
    private void createCharacter() {
        PlayableCharacterLoader pcl =
                new PlayableCharacterLoader("data/pccharacter-data.csv");
        try {
            player = pcl.load().get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void runGameLoop() {
        RouteNode curNode = routeInfo.getStartNode();

        while (true) {
            // check for character link
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
                int input = scanner.nextInt();

                if (isValidInput(input, curNode.getChildren().size())) {
                    curNode = curNode.getChildren().get(input);
                } else {
                    System.out.println("Invalid input");
                }
            }
        }
    }

    private boolean isValidInput(int input, int size) {
        return true;
    }
}