package com.idesoft.learning;

import java.io.*;

public class FileReader {
    public ByteArrayOutputStream read() {
        try {
            File file = new File("./.data/hello-world.txt");
            FileInputStream fStream = new FileInputStream(file);

            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            fStream.transferTo(outStream);

            fStream.close();

            return outStream;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
