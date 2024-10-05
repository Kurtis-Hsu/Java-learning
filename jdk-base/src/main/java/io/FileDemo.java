package io;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileDemo
{
    public static void main(String... args) throws Exception
    {
        // 用于快速读取文件（不适合读取大文件）
        System.out.println(new String(Files.readAllBytes(Path.of("TextStream"))));

        var path = Path.of("");

        try (var entries = Files.list(path)) { entries.forEach(System.out::println); }

        // 遍历所有子目录
        try (var entries = Files.walk(path)) { entries.forEach(System.out::println); }

        try (var entries = Files.walk(path, 1)) { entries.forEach(System.out::println); }
    }
}
