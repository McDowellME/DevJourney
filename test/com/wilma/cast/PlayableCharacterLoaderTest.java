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

        assertEquals(3, pchars.size());

        //id, name, catchPhrase, textFile, education,
        //                    isCharismatic, luck, skill, description

        PlayableCharacter pchar0 = pchars.get(0);
        assertEquals(1, pchar0.getId());
        assertEquals("Linda", pchar0.getName());
        assertEquals("Never let anyone treat you like regular glue. You're glitter glue.", pchar0.getCatchPhrase());
        assertEquals("resources/Linda.txt", pchar0.getTextFile());
        assertEquals(Education.COLLEGE_DEGREE, pchar0.getEducation());
        assertFalse(pchar0.isCharismatic());
        assertEquals(5, pchar0.getLuck());
        assertEquals(4, pchar0.getSkill());
        assertEquals("Lorem Ipsum", pchar0.getDescription());

        PlayableCharacter pchar2 = pchars.get(2);
        assertEquals(3, pchar2.getId());
        assertEquals("Francis", pchar2.getName());
        assertEquals("If at first you don't succeed destroy all evidence that you tried.", pchar2.getCatchPhrase());
        assertEquals("resources/Francis.txt", pchar2.getTextFile());
        assertEquals(Education.SELF_TAUGHT, pchar2.getEducation());
        assertFalse(pchar2.isCharismatic());
        assertEquals(8, pchar2.getLuck());
        assertEquals(3, pchar2.getSkill());
        assertEquals("Lorem Ipsum", pchar2.getDescription());
    }
}