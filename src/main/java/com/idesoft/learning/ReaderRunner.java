package com.idesoft.learning;

import java.io.ByteArrayOutputStream;

public class ReaderRunner implements Runnable {

    private final FileReader reader;

    public ReaderRunner() {
        this.reader = new FileReader();
    }

    @Override
    public void run() {
        try {
            System.out.println("[ReaderRunner]-start");
            // lock.
            SharedResource.lockAll();

            System.out.println("[ReaderRunner] reading file");
            ByteArrayOutputStream contentStream = reader.read();

            System.out.println("[ReaderRunner] Sleeping....");
            Thread.sleep(9000);

            System.out.println("[ReaderRunner] Writing contentStream");
            SharedResource.setContentStream(contentStream);
        }
        catch (InterruptedException _e) {
            throw new RuntimeException(_e);
        }
        finally {
            // unlock.
            SharedResource.unlockAll();
            System.out.println("[ReaderRunner] ReaderRunner-end");
        }
    }
}
