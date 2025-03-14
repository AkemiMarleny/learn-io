package com.idesoft.learning;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.locks.ReentrantLock;

public final class SharedResource {
    private ByteArrayOutputStream contentStream;
    private final static ReentrantLock readLock = new ReentrantLock();

    private static SharedResource instance;

    private SharedResource() {}

    public static SharedResource getInstance() {
        if(SharedResource.instance == null)  {
            SharedResource.instance = new SharedResource();
        }

        return SharedResource.instance;
    }

    public void lockAll() {
        System.out.println("[SharedResource] Locking all");
        readLock.lock();
    }

    public void unlockAll() {
        System.out.println("[SharedResource] Unlocking all");
        readLock.unlock();
    }

    public void setContentStream(ByteArrayOutputStream contentStream) {

        this.contentStream = contentStream;
        // this.contentStream = contentStream; //  no exist 'THIS'

    }

    public ByteArrayOutputStream getContentStream() {
        try {
            System.out.println("[SharedResource] trying read ContentStream");
            // 1. Verifica si no hay alguien mas que haya bloqueado.
            // 2. bloquea si en 1 cumple.
            readLock.lock();
            System.out.println("[SharedResource] reading ContentStream");
            return this.contentStream;

        } finally {
            readLock.unlock();
            System.out.println("[SharedResource] unlock ContentStream");
        }
    }
}
