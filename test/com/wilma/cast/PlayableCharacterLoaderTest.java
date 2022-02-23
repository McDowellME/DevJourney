package com.wilma.cast;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class PlayableCharacterLoaderTest {

    @Test
    public void load_ShouldReturnPopulatedList() throws IOException {
        PlayableCharacterLoader pcLoader = new PlayableCharacterLoader("data/pccharacter-data.csv");
        List<PlayableCharacter> pchars = pcLoader.load();

        assertEquals(1, pchars.size());

        //id, name, catchPhrase, education,
        //                    isCharismatic, luck, skill, description

        PlayableCharacter pchar0 = pchars.get(0);
        assertEquals(10, pchar0.getId());
        assertEquals("Melinda", pchar0.getName());
        assertEquals("Life's rough", pchar0.getCatchPhrase());
        assertEquals(Education.COLLEGE_DEGREE, pchar0.getEducation());
        assertFalse(pchar0.isCharismatic());
        assertEquals(5, pchar0.getLuck());
        assertEquals(4, pchar0.getSkill());
        assertEquals("description here", pchar0.getDescription());
    }
}