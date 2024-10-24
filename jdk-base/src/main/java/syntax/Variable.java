package syntax;

import static java.lang.System.out;

// 变量
public class Variable
{


    Object o = new Object();

    // 数组属于引用类型
    int[] a1 = new int[10]; // 声明一个可以容纳十个元素的空数组，并为每个元素填充默认值
    int[] a2 = new int[] { 1, 2, 3 }; // 声明数组的同时为每个元素赋值，元素个数为声明的元素个数
    int[] a3 = { 1, 2, 3 }; // 方式二的简化版

    // void 也是一种基本类型，只可用于标记返回值为空
    void demo() { }

    public static void main(String... args)
    {


        final var fin = 1;

        // dig = 2; // 报错



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
