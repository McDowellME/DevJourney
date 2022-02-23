package com.wilma.routes;

import com.wilma.cast.NonPlayableCharacter;

import java.util.ArrayList;
import java.util.List;

public class RouteNode {
    private int id;
    private final String message;
    private String routeKey;
    private List<RouteNode> children = new ArrayList<>();
    private List<NonPlayableCharacter> npcs = new ArrayList<>();

    public RouteNode(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public List<RouteNode> getChildren() {
        return this.children;
    }

    public void addChild(RouteNode child) {
        children.add(child);
    }

    public void displayRouteChoices() {
        int choiceNum = 0;
        for (RouteNode child : children) {
            System.out.print("[" + choiceNum + "] " + child.getMessage() + " | ");
            choiceNum++;
        }
        System.out.println();
    }

    public String getRouteKey() {
        return this.routeKey;
    }

    public void setRouteKey(String routeKey) {
        this.routeKey = routeKey;
    }

    public List<NonPlayableCharacter> getNPCs() {
        return this.npcs;
    }

    public void addNPC(NonPlayableCharacter npc) {
        this.npcs.add(npc);
    }

    public boolean hasNPCs() {
        return !this.npcs.isEmpty();
    }
}