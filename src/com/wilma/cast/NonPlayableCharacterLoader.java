package com.wilma.cast;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class NonPlayableCharacterLoader {
    private Path dataFilePath;

    public NonPlayableCharacterLoader(String dataFilePath) {
        this.dataFilePath = Path.of(dataFilePath);
    }

    public List<NonPlayableCharacter> load() throws IOException {
        List<NonPlayableCharacter> result = new ArrayList<>();

        Files.lines(dataFilePath).forEach(line -> {
            String[] tokens = line.split(",");

            int id = Integer.parseInt(tokens[1]);
            String name = tokens[2];
            String catchPhrase = tokens[3];
            String dialogue = tokens[4];
            String role = tokens[5];
            int event = Integer.parseInt(tokens[6]);

            result.add(new NonPlayableCharacter(id, name, catchPhrase, dialogue, role, event));
        });
        return result;
    }

}