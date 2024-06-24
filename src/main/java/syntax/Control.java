package cn.kurtis.study.syntax;

import static java.lang.System.out;

// 流程控制
public class Control
{
    public static void main(String[] args)
    {
        int i;
        // if-else 语句
        i = 11;
        if (i > 10)
        {
            out.println("true");
        }
        else
            // 若执行代码只有一行括号可省略
            out.println("false");

        // else if
        if (i > 100)
            out.println("true");
        else if (i < 0)
            out.println("false");
        else
            out.println("other");

        // switch 语句
        // switch 语句会执行匹配成功的代码段
        // 如果没有 break 会一直向下执行其他代码段，直到遇到 break或 switch 结束
        i = 3;
        switch (i)
        {
            case 1:
                out.println(111);
                break;
            case 2:
                out.println(222);
                break;
            case 3:
                out.println(333);
            default:
                out.println(666);
        }

        // while 循环
        i = 0;
        while (i < 5) out.println("while " + i++);

        // do-while 循环
        // 先执行代码块再判断
        i = 0;
        do
        {
            out.println("do-while " + i++);
        }
        while (i < 5);

        // for 循环
        int[] a = { 1, 2, 3, 4, 5 };
        for (int t = 0; t < a.length; t++) out.println(a[t]);
        for (int t : a) out.println(t);
    }
}
