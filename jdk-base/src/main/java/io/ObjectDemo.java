package io;

import java.io.*;

public class ObjectDemo
{
    public static void main(String... args) throws Exception
    {
        var writer = new ObjectOutputStream(new FileOutputStream("testOOS"));
        writer.writeObject(new Data());
        writer.flush();
    }

    private static class Data implements Serializable
    {
        @Serial private static final long serialVersionUID = 1L;

        @Serial
        private void writeObject(ObjectOutputStream out) throws IOException { System.out.println("serialize..."); }
    }
}
