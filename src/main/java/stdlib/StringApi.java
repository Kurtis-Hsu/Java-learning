package api;

import static java.lang.System.out;

// 字符串
public class StringApi
{
    public static void main(String[] args)
    {
        String s = "hello world"; // 字符串是特殊的引用类型，内部组合了 char 数组，声明时使用双引号
        String s1 = "abc", s2 = "def";
        out.println(s1 + s2); // Java 单独为字符串对象重载了加法，两个字符串相加表示拼接，任何变量与字符串相加都会先转换为字符串
        String s3 = "abc"; // 每个字符串都会被存储到常量池中，声明时会先从常量池中查找
        out.println(s1 == s3);
        String s4 = new String(s1); // 这个方式表示以字符串为参数创建一个新的字符串对象
        out.println(s1 == s4);

        out.printf("string: \"%s\" has %d characters", s, s.length());
    }
}
