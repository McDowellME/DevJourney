package com.wilma.cast;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonPlayableCharacterLoader {
    private Path dataFilePath;

    public NonPlayableCharacterLoader(String dataFilePath) {
        this.dataFilePath = Path.of(dataFilePath);
    }

    public Map<Integer, NonPlayableCharacter> load() throws IOException {
        Map<Integer, NonPlayableCharacter> result = new HashMap<>();

        Files.lines(dataFilePath).forEach(line -> {
            String[] tokens = line.split(",");

            int id = Integer.parseInt(tokens[1]);
            String name = tokens[2];
            String catchPhrase = tokens[3];
            String dialogue = tokens[4];
            String role = tokens[5];
            int event = Integer.parseInt(tokens[6]);

            result.put(id, new NonPlayableCharacter(id, name, catchPhrase, dialogue, role, event));
        });
        return result;
    }

}