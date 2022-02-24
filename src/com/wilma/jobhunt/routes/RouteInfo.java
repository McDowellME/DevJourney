package com.wilma.jobhunt.routes;

import com.wilma.jobhunt.cast.NonPlayableCharacter;

import java.util.HashMap;
import java.util.Map;

public class RouteInfo {
    public Map<Integer,RouteNode> nodeIdMap = new HashMap<>();
    public Map<Integer,String> messageIdMap;
    public Map<Integer,int[]> childrenMap;
    public Map<Integer,String> routeKeyMap;
    public Map<Integer, NonPlayableCharacter> npcIdMap;
    public Map<Integer,int[]> npcConnectionMap;

    public RouteInfo() {
        this.messageIdMap = RouteData.idMap;
        this.childrenMap = RouteData.childrenMap;
        this.routeKeyMap = RouteData.routeKeyMap;
        this.npcIdMap = RouteData.npcMap;
        this.npcConnectionMap = RouteData.npcConnectionMap;
        buildGraph();
    }

    private void buildGraph() {
        createRouteNodes();
        addChildNodes();
        addRouteKeys();
        addNPCs();
    }

    private void createRouteNodes() {
        for (var entry : messageIdMap.entrySet()) {
            int id = entry.getKey();
            String message = entry.getValue();
            RouteNode node = new RouteNode(id, message);
            nodeIdMap.put(id, node);
        }
    }

    private void addChildNodes() {
        for (var entry : childrenMap.entrySet()) {
            int id = entry.getKey();
            int[] childIds = entry.getValue();
            RouteNode parentNode = nodeIdMap.get(id);

            for (int childId : childIds) {
                RouteNode childNode = nodeIdMap.get(childId);
                parentNode.addChild(childNode);
            }
        }
    }

    private void addRouteKeys() {
        for (var entry : routeKeyMap.entrySet()) {
            int id = entry.getKey();
            String routeKey = entry.getValue();
            RouteNode node = nodeIdMap.get(id);
            node.setRouteKey(routeKey);
        }
    }

    private void addNPCs() {
        for (var entry : npcConnectionMap.entrySet()) {
            int id = entry.getKey();
            int[] connectedNodes = entry.getValue();
            NonPlayableCharacter npc = npcIdMap.get(id);

            for (int connectedNode : connectedNodes) {
                nodeIdMap.get(connectedNode).addNPC(npc);
            }
        }
    }

    public RouteNode getStartNode() {
        return nodeIdMap.get(2);
    }
}