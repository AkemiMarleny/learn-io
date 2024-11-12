package com.idesoft.learning;

import java.io.ByteArrayOutputStream;

public class WriterRunner implements Runnable {

    private final FileWriter writer;

    public WriterRunner() {
        this.writer = new FileWriter();
    }

    @Override
    public void run() {
        System.out.println("[WriterRunner]-start");
        try {
            // Thread.sleep(1005);
            ByteArrayOutputStream contentStream = SharedResource.getContentStream(); // no exist 'THIS' ->
            System.out.println("[WriterRunner] writing file");
            writer.write(contentStream);
        }  finally {
            System.out.println("[WriterRunner]-end");
        }
    }
}
