package com.wilma.routes;

import java.util.Map;
import java.util.function.BiFunction;

public class RouteFactor {
    private static Map<String, BiFunction<Integer,Integer,Boolean>> ops =
            Map.of("<", (a, b) -> a < b, ">", (a, b) -> a > b);

    public static boolean decipherKey(Character character, RouteNode node) {
        // C>5
        String routeKey = node.getRouteKey();
        String[] splitKey = routeKey.split("");
        String attribute = splitKey[0];
        String operator = splitKey[1];
        int num = Integer.parseInt(splitKey[2]);
        int field = 0;

//        switch (attribute) {
//            case "C":
//                field = character.confidence;
//                break;
//            case "E":
//                field = character.education;
//        }

        return isSuccessful(operator, field, num);
    }

    public static boolean isSuccessful(String operator, int field, int num) {
        boolean result = false;
        if (ops.containsKey(operator)) {
            result = ops.get(operator).apply(field, num);
        }
        return result;
    }
}













