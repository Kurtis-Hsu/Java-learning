package syntax.control;

import static java.lang.System.out;

/// ### for 循环
public class ForDemo
{
    public static void main(String... args)
    {
        int[] a = { 1, 2, 3, 4, 5 };

        for (int t = 0; t < a.length; t++)
        {
            if (a[t] == 2) continue; // continue 执行下一次循环
            if (a[t] == 4) break; // break 直接跳出循环
            out.println(a[t]);
        }
        for (int t : a) out.println(t);
    }
}
