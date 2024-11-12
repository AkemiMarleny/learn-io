package com.idesoft.learning;

import java.io.ByteArrayOutputStream;

public class Main {
    public static void main(String[] args) {
        // variable -> almacena datos -> de una plantilla/tipo
        //

        // TODO:
        // 1. leggere il contenuto dal file hello-world.txt in un thread 1(diverso).
        // 2. il contenuto letto nel punto 1. sarà inviato a un thread 2,
        //    il thread 2 scrive il contenuto ricevuto nel file hello-writer.txt.

//        SharedResource resource1 = new SharedResource();
//        SharedResource resource1 = new SharedResource();
//
//
        SharedResource sharedResource = SharedResource.getInstance();


        ReaderRunner readerRunner = new ReaderRunner(sharedResource);
        Thread readerThread = new Thread(readerRunner);
        readerThread.start();

        WriterRunner writerRunner = new WriterRunner(sharedResource);
        Thread writerThread = new Thread(writerRunner);
        writerThread.start();

//        FileReader reader = new FileReader();
//        ByteArrayOutputStream contentStream = reader.read();

//        FileWriter writer = new FileWriter();
//        writer.write(contentStream);
    }
}

// absoluta: rota completa dalla radice /Users/akemi/workspace/learn-java/threads/learnio/pom.xml
// relativa: ./pom.xml
//   origine: /Users/akemi/workspace/learn-java/threads/learnio