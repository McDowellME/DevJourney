package com.wilma.cast;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayableCharacterLoader {
    private final Path dataFilePath;

    public PlayableCharacterLoader(String dataFilePath) {
        this.dataFilePath = Path.of(dataFilePath);
    }

    public List<PlayableCharacter> load() throws IOException {
        List<PlayableCharacter> result = new ArrayList<>();

        Files.lines(dataFilePath).forEach(line -> {
            String[] tokens = line.split(",");

            //tokens[0].replaceAll("\\s+","");

            int id = Integer.parseInt(tokens[1]);
            String name = tokens[2];
            String catchPhrase = tokens[3];
            Education education = Education.valueOf(tokens[4]);
            boolean isCharismatic = Boolean.parseBoolean(tokens[5]);
            int luck = Integer.parseInt(tokens[6]);
            int skill = Integer.parseInt(tokens[7]);
            String description = tokens[8];
            String textFile = tokens[9];

            result.add(new PlayableCharacter(id, name, catchPhrase, textFile, education,
                    isCharismatic, luck, skill, description));
        });
        return result;
    }

}