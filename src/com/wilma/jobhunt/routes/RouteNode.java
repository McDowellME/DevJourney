package com.wilma.jobhunt.routes;

import com.wilma.jobhunt.cast.NonPlayableCharacter;

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

    public int getId() {
        return this.id;
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

    public List<String> displayRouteChoices() {
        List<String> choices = new ArrayList<>();
        for (RouteNode child : children) {
            choices.add(child.getMessage());
        }
        return choices;
    }

    public String displayChoice() {
        return children.get(0).getMessage();
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