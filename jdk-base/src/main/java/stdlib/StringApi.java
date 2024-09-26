package stdlib;

import static java.lang.System.out;

// 字符串
public class StringApi
{
    static final String s = "thinking in java"; // 字符串是特殊的引用类型，内部组合了 char 数组，声明时使用双引号
    static final String domain = "www.kurtis.cn";

    public static void main(String[] args)
    {
        String s1 = "abc", s2 = "def";
        out.println(s1 + s2); // Java 单独为字符串对象重载了加法，两个字符串相加表示拼接，任何变量与字符串相加都会先转换为字符串
        String s3 = "abc"; // 每个字符串都会被存储到常量池中，声明时会先从常量池中查找
        out.println(s1 == s3);
        String s4 = new String(s1); // 这个方式表示以字符串为参数创建一个新的字符串对象
        out.println(s1 == s4);

        out.printf("string: '%s' has %d characters\n", s, s.length());

        int index = s.indexOf("10", 3);
        out.printf("index of '%s' in '%s' is %d\n", "10", s, index);
        index = s.lastIndexOf("in");
        out.printf("index of '%s' in '%s' is %d\n", "in", s, index);

        int charAt = 10;
        out.printf("char at index '%d' in '%s' is '%s'\n", charAt, s, s.charAt(charAt));

        int start = domain.indexOf(".") + 1;
        int end = domain.lastIndexOf(".");
        String name = domain.substring(start, end);
        System.out.println(name);
        name = domain.substring(start);
        System.out.println(name);

        String trim = "   123   ";
        out.printf("before trim '%s', after trim '%s'\n", trim, trim.trim());


        out.printf("value of int 123: '%s'\n", 123);
        out.printf("value of double 123.456: '%s'\n", 123.456);
    }
}
