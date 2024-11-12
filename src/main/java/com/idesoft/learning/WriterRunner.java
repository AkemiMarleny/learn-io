package com.idesoft.learning;

import java.io.ByteArrayOutputStream;

public class WriterRunner implements Runnable {

    private final FileWriter writer;
    private final SharedResource sharedResource;

    public WriterRunner(SharedResource sharedResource) {
        this.writer = new FileWriter();
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("[WriterRunner]-start");
        try {
            // Thread.sleep(1005);
            ByteArrayOutputStream contentStream = sharedResource.getContentStream(); // no exist 'THIS' ->
            System.out.println("[WriterRunner] writing file");
            writer.write(contentStream);
        }  finally {
            System.out.println("[WriterRunner]-end");
        }
    }
}
