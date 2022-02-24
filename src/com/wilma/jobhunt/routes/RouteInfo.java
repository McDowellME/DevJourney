package com.wilma.jobhunt.routes;

import com.wilma.jobhunt.cast.NonPlayableCharacter;
import com.wilma.jobhunt.cast.PlayableCharacter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RouteInfo {
    public Map<Integer,RouteNode> nodeMap = new HashMap<>();
    public Map<Integer,String> idMap;
    public Map<Integer,int[]> childrenMap;
    public Map<Integer,String> routeKeyMap;
    public Map<Integer, NonPlayableCharacter> npcMap;
    public Map<Integer,int[]> npcConnectionMap;
    public List<PlayableCharacter> pcList;

    public RouteInfo() {
        this.idMap = RouteData.idMap;
        this.childrenMap = RouteData.childrenMap;
        this.routeKeyMap = RouteData.routeKeyMap;
        this.npcMap = RouteData.npcMap;
        this.npcConnectionMap = RouteData.npcConnectionMap;
        this.pcList = RouteData.pcList;
        buildGraph();
    }

    private void buildGraph() {
        createRouteNodes();
        addChildNodes();
        addRouteKeys();
        addNPCs();
    }

    private void createRouteNodes() {
        for (var entry : idMap.entrySet()) {
            int id = entry.getKey();
            String message = entry.getValue();
            RouteNode node = new RouteNode(id, message);
            nodeMap.put(id, node);
        }
    }

    private void addChildNodes() {
        for (var entry : childrenMap.entrySet()) {
            int id = entry.getKey();
            int[] childIds = entry.getValue();
            RouteNode parentNode = nodeMap.get(id);

            for (int childId : childIds) {
                RouteNode childNode = nodeMap.get(childId);
                parentNode.addChild(childNode);
            }
        }
    }

    private void addRouteKeys() {
        for (var entry : routeKeyMap.entrySet()) {
            int id = entry.getKey();
            String routeKey = entry.getValue();
            RouteNode node = nodeMap.get(id);
            node.setRouteKey(routeKey);
        }
    }

    private void addNPCs() {
        for (var entry : npcConnectionMap.entrySet()) {
            int id = entry.getKey();
            int[] connectedNodes = entry.getValue();
            NonPlayableCharacter npc = npcMap.get(id);

            for (int connectedNode : connectedNodes) {
                nodeMap.get(connectedNode).addNPC(npc);
            }
        }
    }

    public RouteNode getStartNode() {
        return nodeMap.get(2);
    }
}