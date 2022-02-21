package com.wilma.routes;

import java.util.HashMap;
import java.util.Map;

class RouteInfo {
    // TODO: 2/21/2022 -> use method to populate these from CSV
    public Map<Integer,String> idMap;
    public Map<Integer,int[]> childrenMap;
    public Map<Integer,RouteNode> nodeMap = new HashMap<>();

    public RouteInfo() {
        // TODO: 2/21/2022 -> call csv method 
        buildGraph();
    }

    // creates a map of: id -> RouteNode, from id -> String map
    private void buildGraph() {
        // iterate through id -> String map
        for (var entry : idMap.entrySet()) {
            int id = entry.getKey();
            String message = entry.getValue();
            RouteNode node = new RouteNode(id, message);
            nodeMap.put(id, node);
        }
        addChildrenNodes();
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
}