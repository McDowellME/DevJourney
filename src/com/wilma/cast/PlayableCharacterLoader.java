package com.wilma.cast;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayableCharacterLoader {
    private Path dataFilePath;

    public PlayableCharacterLoader(String dataFilePath) {
        this.dataFilePath = Path.of(dataFilePath);
    }

    public Map<Integer, PlayableCharacter> load() throws IOException {
        Map<Integer, PlayableCharacter> result = new HashMap<>();

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

            result.put(id, new PlayableCharacter(id, name, catchPhrase, education,
                    isCharismatic, luck, skill, description));
        });
        return result;
    }

}