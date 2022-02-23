package com.wilma.jobhunt.routes;

import com.wilma.cast.Education;
import com.wilma.cast.PlayableCharacter;
import com.wilma.routes.RouteNode;
import com.wilma.routes.RouteValidation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RouteValidationTest {
    private PlayableCharacter p1;
    private PlayableCharacter p2;

    private RouteNode n1;
    private RouteNode n2;
    private RouteNode n3;
    private RouteNode n4;
    private RouteNode n5;
    private RouteNode n6;

    @Before
    public void setUp() {
        p1 = new PlayableCharacter(
                1, "Lyle", "catchphrase",
                "resources/Francis.txt",
                Education.COLLEGE_DEGREE, true,
                2, 5, "description");
        p2 = new PlayableCharacter(
                2, "Jay", "catchphrase",
                "resources/Francis.txt",
                Education.BOOTCAMP, false,
                8, 7, "description");

        n1 = new RouteNode(1, "message");
        n1.setRouteKey("C");
        n2 = new RouteNode(2, "message");
        n2.setRouteKey("E:=:C");
        n3 = new RouteNode(3, "message");
        n3.setRouteKey("L:>:5");
        n4 = new RouteNode(4, "message");
        n4.setRouteKey("S:>=:7");
        n5 = new RouteNode(5, "message");
        n5.setRouteKey("L:>:5,S:>:5");
        n6 = new RouteNode(5, "message");
        n6.setRouteKey("E:=:BC");
    }

    @Test
    public void decipherKey_returnsTrue_whenPassedPlayerWithCharisma() {
        assertTrue(RouteValidation.decipherKey(p1, n1));
    }

    @Test
    public void decipherKey_returnsFalse_whenPassedPlayerWithNoCharisma() {
        assertFalse(RouteValidation.decipherKey(p2, n1));
    }

    @Test
    public void decipherKey_returnsTrue_whenPassedPlayerWithCollegeDegree() {
        assertTrue(RouteValidation.decipherKey(p1, n2));
    }

    @Test
    public void decipherKey_returnsFalse_whenPassedPlayerWithNoCollegeDegree() {
        assertFalse(RouteValidation.decipherKey(p2, n2));
    }

    @Test
    public void decipherKey_returnsTrue_whenPassedPlayerWithHighLuck() {
        assertTrue(RouteValidation.decipherKey(p2, n3));
    }

    @Test
    public void decipherKey_returnsFalse_whenPassedPlayerWithLowLuck() {
        assertFalse(RouteValidation.decipherKey(p1, n3));
    }

    @Test
    public void decipherKey_returnsTrue_whenPassedPlayerWithHighSkill() {
        assertTrue(RouteValidation.decipherKey(p2, n4));
    }

    @Test
    public void decipherKey_returnsFalse_whenPassedPlayerWithLowSkill() {
        assertFalse(RouteValidation.decipherKey(p1, n4));
    }

    @Test
    public void decipherKeyWithMultipleRequirements_returnsTrue_whenPassedPlayerWithHighLuckAndSkill() {
        assertTrue(RouteValidation.decipherKey(p2, n5));
    }

    @Test
    public void decipherKeyWithMultipleRequirements_returnsTrue_whenPassedPlayerWithLowLuckAndSkill() {
        assertFalse(RouteValidation.decipherKey(p1, n5));
    }

    @Test
    public void decipherKeyWithMultipleEducations_returnsTrue_whenPassedPlayerWithOneRequiredEducation() {
        assertTrue(RouteValidation.decipherKey(p1, n6));
    }
}












