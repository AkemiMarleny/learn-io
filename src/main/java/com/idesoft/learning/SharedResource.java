package com.idesoft.learning;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private static ByteArrayOutputStream contentStream;

    private final static ReentrantLock readLock = new ReentrantLock();


    public SharedResource() {

    }

    public static void lockAll() {
        System.out.println("[SharedResource] Locking all");
        readLock.lock();
    }

    public static void unlockAll() {
        System.out.println("[SharedResource] Unlocking all");
        readLock.unlock();
    }

    public static void setContentStream(ByteArrayOutputStream contentStream) {

        SharedResource.contentStream = contentStream;
        // this.contentStream = contentStream; //  no exist 'THIS'

    }

    public static ByteArrayOutputStream getContentStream() {
        try {
            System.out.println("[SharedResource] trying read ContentStream");
            // 1. Verifica si no hay alguien mas que haya bloqueado.
            // 2. bloquea si en 1 cumple.
            readLock.lock();
            System.out.println("[SharedResource] reading ContentStream");
            return SharedResource.contentStream;

        } finally {
            readLock.unlock();
            System.out.println("[SharedResource] unlock ContentStream");
        }
    }
}
