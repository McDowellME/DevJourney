package com.wilma.cast;

import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class NonPlayableCharacterLoaderTest {

    @Test
    public void load_ShouldReturnPopulatedList() throws IOException {
        NonPlayableCharacterLoader npcLoader = new NonPlayableCharacterLoader("data/npccharacter-data.csv");
        Map<Integer, NonPlayableCharacter> npchars = npcLoader.load();

        assertEquals(4, npchars.size());

        NonPlayableCharacter npchar1 = npchars.get(1);
        assertEquals("Kevin Greene", npchar1.getName());
        assertEquals("Recruiting is awesome!", npchar1.getCatchPhrase());
        assertEquals("Lorem Ipmsum", npchar1.getDialogue());
        assertEquals("a recruiter for Amazon", npchar1.getRole());
        assertEquals("resources/Kevin.txt", npchar1.getTextFile());

        NonPlayableCharacter npchar4 = npchars.get(4);
        assertEquals("Morpheus", npchar4.getName());
        assertEquals("Unfortunately no one can be told what the Matrix is.", npchar4.getCatchPhrase());
        assertEquals("Lorem Ipmsum", npchar4.getDialogue());
        assertEquals("a man with weird glasses and a trench coat", npchar4.getRole());
        assertEquals("resources/Kevin.txt", npchar4.getTextFile());
    }
}