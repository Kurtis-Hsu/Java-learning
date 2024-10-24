package syntax.variable;

import static java.lang.System.out;

public class VariableDemo1
{
    // 变量命名只能由字母、数字、下划线组成，数字不可以用作开头
    // Java 使用 Unicode 字符集，字母可以是任意语言中可作为字母的字符，例如中文的汉字
    int 变量 = 1;
    int 变量1 = 1, 变量2 = 2;

    // Java 有 8 种基本数据类型和引用类型
    // 整数字面量默认为 int 类型
    // 声明 long 类型字面量需要在数字后面加 l/L （为了阅读方便一般使用大写）
    // float 类型字面量需要加 f/L
    // double 类型字面量需要加 d/D
    byte v1 = 1;                                // 1 字节
    short v2 = 1;                               // 2 字节
    int v3 = 1;                                 // 4 字节
    long v4 = 1L;                               // 8 字节
    // 带小数的字面量默认为 double 类型
    float v5 = 1.0F;                            // 4 字节
    double v6 = 1.0D;                           // 8 字节
    boolean v7 = true;                          // 1 字节
    char v8 = 'A'; // 字符型字面量需要加单引号       // 2 字节

    char v9 = 55; // 字符型底层是一个 short
    char v10 = '\u0001'; // 可以使用 Unicode 码赋值

    final int dig = 1; // final 关键字定义常量，其值不可变

    public static void main(String... args)
    {
        int bin = 0b10010;
        int oct = 022;
        int hex = 0x12;

        out.println("二进制：" + bin);
        out.println("八进制：" + oct);
        out.println("十六进制：" + hex);
    }
}
