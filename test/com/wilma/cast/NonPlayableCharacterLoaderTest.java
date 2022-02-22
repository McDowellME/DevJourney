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

        assertEquals(1, npchars.size());


    }
}