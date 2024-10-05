package io;

import java.io.File;
import java.nio.file.Path;

public class PathDemo
{
    public static void main(String... args) throws Exception
    {
        var path = Path.of(".idea", "workspace.xml");
        System.out.println(path);

        System.out.println("文件名：" + path.getFileName());
        System.out.println("绝对路径：" + path.toAbsolutePath());
        System.out.println("父路径：" + path.getParent());
        System.out.println("根路径：" + path.getRoot());

        File _ = path.toFile();
    }
}
