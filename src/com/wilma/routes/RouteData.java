package com.wilma.routes;

import com.wilma.cast.NonPlayableCharacter;
import com.wilma.cast.NonPlayableCharacterLoader;
import com.wilma.cast.PlayableCharacter;
import com.wilma.cast.PlayableCharacterLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RouteData {
    public static Map<Integer,String> idMap;
    public static Map<Integer,int[]> childrenMap;
    public static Map<Integer,String> routeKeyMap;
    public static Map<Integer,NonPlayableCharacter> npcMap;
    public static Map<Integer,int[]> npcConnectionMap;
    public static List<PlayableCharacter> pcList;

    static {
        idMap = new HashMap<>();
        idMap.put(1, "Choose your path!");
        idMap.put(2, "Job Hunt");
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
        idMap.put(15, "Accept interview from Amazon employee");
        idMap.put(16, "Decline interview from Kevin");
        idMap.put(17, "Do Amazon Interview");
        idMap.put(18, "Decline Amazon Interview");
        idMap.put(19, "Apply to jobs again");
        idMap.put(20, "Do Google Interview");
        idMap.put(22, "Do Apple Interview");
        idMap.put(24, "Take the Interview seriously"); //don't remember if we were still giving user the choice to take interview seriously or not. 24 and 25 aren't linked in children map yet.
        idMap.put(25, "Try to make interviewer laugh");
        idMap.put(26, "You found a glowing rock, inspect it?"); // figured we can give them the option of inspecting the glowing rock, going back to get coffee, or apply to more jobs. 26 and 27 aren't linked in children map yet
        idMap.put(27, "Go back and get that coffee?");
        idMap.put(28, "You did not pass the interview :(");
        idMap.put(29, "You passed the interview and got the offer!");
        idMap.put(30, "Accept offer");
        idMap.put(31, "Decline offer");
        idMap.put(32, "Go for a walk");
        idMap.put(33, "Aliens");
    }

    static {
        childrenMap = new HashMap<>();
        childrenMap.put(1, new int[] {2});
        childrenMap.put(2, new int[] {4, 12, 32});
        childrenMap.put(4, new int[] {5, 6, 7});
        childrenMap.put(5, new int[] {20, 9});
        childrenMap.put(6, new int[] {22, 9});
        childrenMap.put(7, new int[] {17, 18});
        childrenMap.put(8, new int[] {10, 11});
        childrenMap.put(9, new int[] {4, 12, 32});
        childrenMap.put(10, new int[] {1});
        childrenMap.put(11, new int[] {4, 12, 32});
        childrenMap.put(12, new int[] {13, 14});
        childrenMap.put(13, new int[] {15, 16});
        childrenMap.put(14, new int[] {4, 12});
        childrenMap.put(15, new int[] {10, 11});
        childrenMap.put(16, new int[] {4, 12});
        childrenMap.put(17, new int[] {28, 29});
        childrenMap.put(20, new int[] {28, 29});
        childrenMap.put(22, new int[] {28, 29});
        childrenMap.put(26, new int[] {33});
        childrenMap.put(28, new int[] {4, 12, 32});
        childrenMap.put(29, new int[] {31, 30});
        childrenMap.put(31, new int[] {4, 12, 32});
        childrenMap.put(32, new int[] {26, 14});
    }

    static {
        routeKeyMap = new HashMap<>();
        routeKeyMap.put(8, "C:=:T");
        routeKeyMap.put(20, "S:>=:7");
//        routeKeyMap.put()
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
    }

    static {
        PlayableCharacterLoader pcLoader =
                new PlayableCharacterLoader("data/pccharacter-data.csv");

        try {
            pcList = pcLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}