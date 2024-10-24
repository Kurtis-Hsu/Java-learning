package syntax.control;

import static java.lang.System.out;

/// ### while 循环
public class WhileDemo
{
    public static void main(String... args)
    {
        int i = 0;
        while (i < 5) out.println("while " + i++);
    }
}
