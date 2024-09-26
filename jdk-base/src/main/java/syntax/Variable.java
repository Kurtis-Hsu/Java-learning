package syntax;

import static java.lang.System.out;

// 变量
public class Variable
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

    Object o = new Object();

    // 数组属于引用类型
    int[] a1 = new int[10]; // 声明一个可以容纳十个元素的空数组，并为每个元素填充默认值
    int[] a2 = new int[] { 1, 2, 3 }; // 声明数组的同时为每个元素赋值，元素个数为声明的元素个数
    int[] a3 = { 1, 2, 3 }; // 方式二的简化版

    // void 也是一种基本类型，只可用于标记返回值为空
    void demo() { }

    public static void main(String... args)
    {
        var variable = 123; // Java 10 之后可以在局部使用 var 关键字声明变量，该关键字会自动进行类型推断
        var _ = 1; // Java 22 之后可以将变量匿名
        var _ = 2;

        final var fin = 1;

        final int dig = 1; // final 关键字定义常量，其值不可变
        // dig = 2; // 报错

        int bin = 0b10010;
        int oct = 022;
        int hex = 0x12;
        out.println("二进制：" + bin);
        out.println("八进制：" + oct);
        out.println("十六进制：" + hex);

        int a = 1, b = 2, c;
        boolean bool = true;
        out.print(++a); // 前置自增
        out.print(--a); // 前置自减
        out.print(a++); // 后置自增
        out.print(a--); // 后置自减
        out.printf("%d\n", a);
        c = a + b; // 加
        c = a - b; // 减
        c = a * b; // 乘
        c = a / b; // 除
        c = a % b; // 取余
        c = a & b; // 与
        c = a | b; // 或
        c = a ^ b; // 异或
        bool = !bool; // 非

        c = bool ? 1 : 0; // bool 为 true 则表达式结果为 1，否则为 0

        c = a / b;
        out.println("除法结果：" + c); // 整数除法会舍弃小数
        double d = a / (double) b;
        out.println("除法结果：" + d);

        // 打印九九乘法表
        for (int i = 1; i <= 9; i++)
        {
            for (int j = 1; j <= i; j++) out.printf(j != 1 ? "\t%d * %d = %d" : "%d * %d = %d", i, j, i * j);
            out.println();
        }
    }
}
