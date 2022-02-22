package com.wilma.routes;

import java.util.HashMap;
import java.util.Map;

public class RouteInfo {
    public Map<Integer,RouteNode> nodeMap = new HashMap<>();
    public Map<Integer,String> idMap;
    public Map<Integer,int[]> childrenMap;
    public Map<Integer,String> routeKeyMap;

    public RouteInfo() {
        this.idMap = RouteData.idMap;
        this.childrenMap = RouteData.childrenMap;
        this.routeKeyMap = RouteData.routeKeyMap;
        buildGraph();
    }

    // creates a map of: id -> DecisionNode, from id -> String map
    private void buildGraph() {
        // iterate through id -> String map
        for (var entry : idMap.entrySet()) {
            int id = entry.getKey();
            String message = entry.getValue();
            RouteNode node = new RouteNode(id, message);
            nodeMap.put(id, node);
        }
        addChildrenNodes();
        addRouteKeys();
    }

    // adds child relationships to existing nodes in map above
    private void addChildrenNodes() {
        // iterate through id -> childIds map
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

    public RouteNode getStartNode() {
        return nodeMap.get(1);
    }
}