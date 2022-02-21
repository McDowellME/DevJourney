package com.wilma.routes;

import java.util.ArrayList;
import java.util.List;

class RouteNode {
    int id;
    String message;
    List<RouteNode> children = new ArrayList<>();

    public RouteNode(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void addChild(RouteNode child) {
        children.add(child);
    }

    public void displayChoices() {
        int choiceNum = 0;
        for (RouteNode child : children) {
            System.out.print("[" + choiceNum + "] " + child.getMessage() + " | ");
            choiceNum++;
        }
        System.out.println();
    }
}