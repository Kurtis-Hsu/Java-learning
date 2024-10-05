package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipDemo
{
    public static void main(String... args) throws Exception
    {
        // input();
        // output();
        fileSystem();
    }

    private static void input() throws Exception
    {
        var zis = new ZipInputStream(new FileInputStream("files.zip"));
        ZipEntry entry; // [ZipEntry] 表示 zip 文档中的一个项
        while ((entry = zis.getNextEntry()) != null)
        {
            System.out.println(entry.getName());
            while (zis.available() > 0) System.out.print((char) zis.read());
            System.out.println();
            zis.closeEntry();
        }
        zis.close();
    }

    private static void output() throws Exception
    {
        var zos = new ZipOutputStream(new FileOutputStream("test.zip"));
        for (int i = 1; i <= 5; i++)
        {
            var entry = new ZipEntry("file%d.txt".formatted(i));
            zos.putNextEntry(entry);
            zos.write("Hello World!".getBytes());
        }
        zos.close();
    }

    // 将 zip 文档作为一个文件系统
    private static void fileSystem() throws Exception
    {
        Files.list(FileSystems.newFileSystem(Path.of("files.zip")).getPath("/")).forEach(System.out::println);
    }
}
