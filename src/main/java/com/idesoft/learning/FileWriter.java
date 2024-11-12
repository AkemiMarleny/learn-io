package com.idesoft.learning;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriter {
    public void write(ByteArrayOutputStream stream) {

        Path fileDaScrivere = Paths.get("./.data/hello-writer.txt");
        try {
            Files.write(fileDaScrivere, stream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
