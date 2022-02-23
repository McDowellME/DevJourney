package com.wilma.jobhunt.routes;

import com.wilma.jobhunt.cast.Education;
import com.wilma.jobhunt.cast.PlayableCharacter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class RouteValidation {
    private static final Map<String, BiFunction<Integer, Integer, Boolean>> ops =
            Map.of("<", (a, b) -> a < b, ">", (a, b) -> a > b);
    private static final Map<String,Education> educationMap =
            Map.of("C", Education.COLLEGE_DEGREE, "B", Education.BOOTCAMP, "S", Education.SELF_TAUGHT);

    public static boolean decipherKey(PlayableCharacter character, RouteNode node) {
        // C:>:5, E:=:C
        String routeKey = node.getRouteKey();
        String[] tokens = routeKey.split(":");
        String attribute = tokens[0];

        switch (attribute) {
            case "C":
                return character.isCharismatic();
            case "L":
                return luckCheck(tokens, character);
            case "S":
                return skillCheck(tokens, character);
            case "E":
                return educationCheck(tokens, character);
            default:
                return false;
        }
    }

    public static boolean educationCheck(String[] tokens, PlayableCharacter character) {
        String[] educationTokens = tokens[2].split("");
        List<Education> requiredEducations = new ArrayList<>();

        for (String educationToken : educationTokens) {
            requiredEducations.add(educationMap.get(educationToken));
        }
        return requiredEducations.contains(character.getEducation());
    }

    public static boolean luckCheck(String[] tokens, PlayableCharacter character) {
        String operator = tokens[1];
        int luck = Integer.parseInt(tokens[2]);
        return ops.get(operator).apply(character.getLuck(), luck);
    }

    public static boolean skillCheck(String[] tokens, PlayableCharacter character) {
        String operator = tokens[1];
        int skill = Integer.parseInt(tokens[2]);
        return ops.get(operator).apply(character.getSkill(), skill);
    }
}