package regex;

import java.util.regex.Pattern;

public class RegexDemo1
{
    public static void main(String... args)
    {
        var pattern = Pattern.compile("a");
        var matcher = pattern.matcher("java");

        System.out.println(matcher.matches()); // 匹配整个字符串

        // 寻找是否有匹配的子串
        while (matcher.find())
            System.out.println(matcher.start() + " " + matcher.end());
    }
}
