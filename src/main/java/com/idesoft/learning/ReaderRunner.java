package com.idesoft.learning;

import java.io.ByteArrayOutputStream;

public class ReaderRunner implements Runnable {

    private final FileReader reader;
    private final SharedResource sharedResource;

    public ReaderRunner(SharedResource sharedResource) {
        this.reader = new FileReader();
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        try {
            System.out.println("[ReaderRunner]-start");
            // lock.
            sharedResource.lockAll();

            System.out.println("[ReaderRunner] reading file");
            ByteArrayOutputStream contentStream = reader.read();

            System.out.println("[ReaderRunner] Sleeping....");
            Thread.sleep(9000);

            System.out.println("[ReaderRunner] Writing contentStream");
            sharedResource.setContentStream(contentStream);
        }
        catch (InterruptedException _e) {
            throw new RuntimeException(_e);
        }
        finally {
            // unlock.
            sharedResource.unlockAll();
            System.out.println("[ReaderRunner] ReaderRunner-end");
        }
    }
}
