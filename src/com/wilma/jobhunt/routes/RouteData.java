package com.wilma.jobhunt.routes;

import com.wilma.jobhunt.cast.NonPlayableCharacter;
import com.wilma.jobhunt.cast.NonPlayableCharacterLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class RouteData {
    public static Map<Integer,String> idMap;
    public static Map<Integer,int[]> childrenMap;
    public static Map<Integer,String> routeKeyMap;
    public static Map<Integer,NonPlayableCharacter> npcMap;
    public static Map<Integer,int[]> npcConnectionMap;

    static {
        idMap = new HashMap<>();
        idMap.put(1, "Choose your path!");
        idMap.put(2, "*** WELCOME TO JOB HUNT! ***");
        idMap.put(4, "Apply for jobs");
        idMap.put(5, "Google");
        idMap.put(6, "Apple");
        idMap.put(7, "Amazon");
        idMap.put(8, "Accept Interview");
        idMap.put(9, "Decline Interview");
        idMap.put(10, "Failed");
        idMap.put(11, "Success");
        idMap.put(12, "Get coffee");
        idMap.put(13, "Sit at table");
        idMap.put(14, "Go home");
        idMap.put(15, "Accept interview from Kevin Greene");
        idMap.put(16, "Decline interview from Kevin Greene");
        idMap.put(17, "Conduct Amazon Interview");
        idMap.put(18, "Decline Amazon Interview");
        idMap.put(19, "Apply to jobs again");
        idMap.put(20, "Conduct Google Interview");
        idMap.put(21, "You feel the earth shaking underneath you...");
        idMap.put(22, "Conduct Apple Interview");
        idMap.put(24, "Take the Interview seriously"); //don't remember if we were still giving user the choice to take interview seriously or not. 24 and 25 aren't linked in children map yet.
        idMap.put(25, "Try to make interviewer laugh");
        idMap.put(26, "You found a glowing rock, inspect it?"); // figured we can give them the option of inspecting the glowing rock, going back to get coffee, or apply to more jobs. 26 and 27 aren't linked in children map yet
        idMap.put(27, "Go back and get that coffee?");
        idMap.put(28, "You did not pass the interview :(");
        idMap.put(29, "You passed the interview and got the offer!");
        idMap.put(30, "Accept offer");
        idMap.put(31, "Decline offer");
        idMap.put(32, "Go for a walk");
        idMap.put(34, "You got the Google interview!");
        idMap.put(35, "You got the Amazon interview!");
        idMap.put(36, "You got the Apple interview!");
        idMap.put(37, "Restart");
        idMap.put(38, "Quit");
    }

    static {
        childrenMap = new HashMap<>();
        childrenMap.put(1, new int[] {2});
        childrenMap.put(2, new int[] {4, 12, 32});
        childrenMap.put(4, new int[] {5, 6, 7});
        childrenMap.put(5, new int[] {34});
        childrenMap.put(6, new int[] {36});
        childrenMap.put(7, new int[] {35});
        childrenMap.put(8, new int[] {10, 11});
        childrenMap.put(9, new int[] {4, 12, 32});
        childrenMap.put(10, new int[] {4, 12, 32});
        childrenMap.put(11, new int[] {4, 12, 32});
        childrenMap.put(12, new int[] {13, 14});
        childrenMap.put(13, new int[] {15, 16});
        childrenMap.put(14, new int[] {4, 12, 32});
        childrenMap.put(15, new int[] {28, 29});
        childrenMap.put(16, new int[] {4, 12, 32});
        childrenMap.put(17, new int[] {28, 29});
        childrenMap.put(20, new int[] {28, 29});
        childrenMap.put(21, new int[] {38, 37});
        childrenMap.put(22, new int[] {28, 29});
        childrenMap.put(26, new int[] {21});
        childrenMap.put(28, new int[] {4, 12, 32});
        childrenMap.put(29, new int[] {30, 31});
        childrenMap.put(30, new int[] {38, 37});
        childrenMap.put(31, new int[] {4, 12, 32});
        childrenMap.put(32, new int[] {26, 14});
        childrenMap.put(34, new int[] {20, 9});
        childrenMap.put(35, new int[] {17, 9});
        childrenMap.put(36, new int[] {22, 9});
        childrenMap.put(37, new int[] {2});
    }

    static {
        routeKeyMap = new HashMap<>();
        routeKeyMap.put(15, "C:=:T");
        routeKeyMap.put(17, "C:=:T");
        routeKeyMap.put(20, "S:>=:7");
        routeKeyMap.put(22, "L:>=:5");
    }

    static {
        NonPlayableCharacterLoader npcLoader =
                new NonPlayableCharacterLoader("data/npccharacter-data.csv");
        try {
            npcMap = npcLoader.load();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        npcConnectionMap = new HashMap<>();
        npcConnectionMap.put(1, new int[] {13});
        npcConnectionMap.put(3, new int[] {15, 17, 20, 22});
    }
}