package com.wilma.controller;

import com.wilma.cast.PlayableCharacter;
import com.wilma.cast.PlayableCharacterLoader;
import com.wilma.routes.RouteFactor;
import com.wilma.routes.RouteInfo;
import com.wilma.routes.RouteNode;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private final RouteInfo routeInfo = new RouteInfo();
    private final Scanner scanner = new Scanner(System.in);
    List<PlayableCharacter> pcList;
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
            pcList = pcl.load();

            for (int i = 0; i < pcList.size(); i++) {
                pcList.get(i).introduction();
            }

            System.out.println("Choose your character:");
            int input = scanner.nextInt();
            player = pcl.load().get(input);

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
                        RouteFactor.decipherKey(player, curNode);
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