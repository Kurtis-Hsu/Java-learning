package syntax.control;

import static java.lang.System.out;

/// ### do-while 循环
///
/// 先执行代码块再判断
public class DoWhileDemo
{
    public static void main(String... args)
    {
        int i = 0;
        do
        {
            out.println("do-while " + i++);
        }
        while (i < 5);
    }
}
