package com.wilma.routes;

import com.wilma.cast.PlayableCharacter;

import java.util.Map;
import java.util.function.BiFunction;

public class RouteFactor {
    private static final Map<String, BiFunction<Integer,Integer,Boolean>> ops =
            Map.of("<", (a, b) -> a < b, ">", (a, b) -> a > b);

    public static boolean decipherKey(PlayableCharacter character, RouteNode node) {
        // C:>:5
        String routeKey = node.getRouteKey();
        String[] tokens = routeKey.split(":");
        String attribute = tokens[0];
        String operator = tokens[1];
        int num = Integer.parseInt(tokens[2]);

        if ("C".equals(attribute)) {
            // pass
        } else if ("L".equals(attribute)) {
            // pass
        } else if ("S".equals(attribute)) {
            // pass
        } else if ("E".equals(attribute)) {
            // pass
        }

        return false;
    }

    public static boolean passedAttrCheck(String operator, int field, int num) {
        boolean result = false;
        if (ops.containsKey(operator)) {
            result = ops.get(operator).apply(field, num);
        }
        return result;
    }
}