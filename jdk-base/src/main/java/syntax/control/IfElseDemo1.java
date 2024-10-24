package syntax.control;

import static java.lang.System.out;

/// ### if-else 分支
public class IfElseDemo1
{
    public static void main(String... args)
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
    }
}
