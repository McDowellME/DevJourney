package com.wilma.routes;

import java.util.HashMap;
import java.util.Map;

class RouteData {
    public static Map<Integer,String> idMap;
    public static Map<Integer,int[]> childrenMap;
    public static Map<Integer,String> routeKeyMap;

    // separate map for special nodes?
    static {
        idMap = new HashMap<>();
        idMap.put(1, "Choose your path");
        idMap.put(2, "Job Hunt");
        idMap.put(3, "Startup");
        idMap.put(4, "Apply for job");
        idMap.put(5, "Google");
        idMap.put(6, "Apple");
        idMap.put(7, "Amazon"); // interview success is random no matter what?
        idMap.put(8, "Do Interview");
        idMap.put(9, "Decline Interview");
        idMap.put(10, "Failed");
        idMap.put(11, "Success");
        idMap.put(12, "Get coffee");
        idMap.put(13, "Sit at table");
        idMap.put(14, "Go home");
        idMap.put(15, "Accept job from Amazon employee");
        idMap.put(16, "Decline job");
    }

    static {
        childrenMap = new HashMap<>();
        childrenMap.put(1, new int[] {2, 3});
        childrenMap.put(2, new int[] {4,12});
        childrenMap.put(3, new int[] {0});
        childrenMap.put(4, new int[] {5, 6, 7}); // these could be a choice or just a message?
        childrenMap.put(5, new int[] {8, 9});
        childrenMap.put(6, new int[] {8, 9});
        childrenMap.put(7, new int[] {8, 9});
        childrenMap.put(8, new int[] {10, 11});
        childrenMap.put(9, new int[] {4, 12});
        childrenMap.put(10, new int[] {0});
        childrenMap.put(11, new int[] {4, 12});
        childrenMap.put(12, new int[] {13, 14});
        childrenMap.put(13, new int[] {15, 16});
        childrenMap.put(14, new int[] {4, 12});
        childrenMap.put(15, new int[] {10, 11});
        childrenMap.put(16, new int[] {4, 12});
    }

    static {
        routeKeyMap = new HashMap<>();
        routeKeyMap.put(8, "C:>:5");
    }
}