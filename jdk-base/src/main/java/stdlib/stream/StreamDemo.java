package stdlib.stream;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <h2></h2>
 *
 * @Date 2024-04-15 21:27
 */
public class StreamDemo
{
    public static void main(String... args) throws IOException
    {
        var empty = Stream.empty(); // 创建一个空流

        // 文本分割流
        var chars = Pattern.compile("\\s").splitAsStream("A B C D E");
        chars.forEach(System.out::println);

        // 文本行流
        var text = Files.lines(
                Path.of(
                        URI.create(
                                "file:///%s/TextStream".formatted(
                                        System.getProperty("user.dir").replace('\\', '/')
                                )
                        )
                )
        );
        try (text) { text.forEach(System.out::println); }

        // 数字流
        IntStream.range(1, 9).forEach(System.out::print); // 不包含 9
        System.out.println();
        IntStream.rangeClosed(1, 9).forEach(System.out::print); // 包含 9
        System.out.println();

        // 无限流
        var decimals = Stream.generate(Math::random); // 不断创建随机数
        // 从 1 开始遍历自然数（1，2，3，...）
        var digits = Stream.iterate(1, n/* 上一次循环得到的数字 */ -> n + 1 /* 数字加一后返回 */);

        decimals = decimals.limit(100); // 指定该流只循环 100 次
        decimals = decimals.skip(90); // 指定该流跳过前 90 个元素
        digits = digits.limit(10);
        System.out.println("==========");
        Stream.concat(decimals, digits).forEach(System.out::println); // 连接两个流
        System.out.println("===== parallel =====");
        var parallel = Stream.iterate(1, n -> n + 1).limit(10).parallel();
        parallel.forEach(System.out::println);
        System.out.println("===== ordered parallel =====");
        var parallelOrdered = Stream.iterate(1, n -> n + 1).limit(10).parallel();
        parallelOrdered.forEachOrdered(System.out::println);
    }
}