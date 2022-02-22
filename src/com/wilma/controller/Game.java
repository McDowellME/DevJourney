package com.wilma.controller;

import com.wilma.routes.RouteFactor;
import com.wilma.routes.RouteInfo;
import com.wilma.routes.RouteNode;

import java.util.Scanner;

public class Game {
    private final RouteInfo routeInfo = new RouteInfo();
    private Scanner scanner = new Scanner(System.in);

    public void execute() {
        createCharacter();
        startGameLoop();
    }

    // character prompt
    private void createCharacter() {
        System.out.println();
    }

    private void startGameLoop() {
//        RouteNode curNode = routeInfo.getStartNode();
//
//        while (true) {
//            // check for character link
//            if (curNode.getRouteKey() != null) {
//                boolean passedCheck = RouteFactor.decipherKey(character, curNode);
//                curNode = passedCheck ? curNode.getChildren().get(1) : curNode.getChildren().get(0);
//                System.out.println(curNode.getMessage());
//            } else {
//                System.out.println("Please choose from the options below:");
//                curNode.displayRouteChoices();
//                int input = scanner.nextInt();
//
//                if (isValidInput(input, curNode.children.size())) {
//                    curNode = curNode.children.get(input);
//                } else {
//                    System.out.println("Invalid input");
//                }
//            }
//        }
    }
}