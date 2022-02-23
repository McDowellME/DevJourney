package com.wilma.routes;

import com.wilma.cast.Education;
import com.wilma.cast.PlayableCharacter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class RouteValidation {
    private static final Map<String, BiFunction<Integer, Integer, Boolean>> ops =
            Map.of("<", (a, b) -> a < b, ">", (a, b) -> a > b,
                    "<=", (a, b) -> (a <= b), ">=", (a, b) -> a >= b);
    private static final Map<String, Education> educationMap =
            Map.of("C", Education.COLLEGE_DEGREE, "B", Education.BOOTCAMP, "S", Education.SELF_TAUGHT);

    public static boolean decipherKey(PlayableCharacter character, RouteNode node) {
        String routeKey = node.getRouteKey();
        String[] tokens = routeKey.split(",");

        for (String token : tokens) {
            if (!validToken(token, character)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validToken(String token, PlayableCharacter character) {
        String[] innerTokens = token.split(":");
        String attributeStr = innerTokens[0];

        switch (attributeStr) {
            case "C":
                return character.isCharismatic();
            case "L":
            case "S":
                return numCheck(innerTokens, character);
            case "E":
                return educationCheck(innerTokens, character);
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

    public static boolean numCheck(String[] tokens, PlayableCharacter character) {
        String attributeStr = tokens[0];
        String operator = tokens[1];
        int requiredAttrNum = Integer.parseInt(tokens[2]);
        int characterAttrNum;

        switch (attributeStr) {
            case "S":
                characterAttrNum = character.getSkill();
                break;
            case "L":
                characterAttrNum = character.getLuck();
                break;
            default:
                return false;
        }
        return ops.get(operator).apply(characterAttrNum, requiredAttrNum);
    }
}