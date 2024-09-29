package syntax;

import static java.lang.System.out;

public class Methods
{
    public static void main(String... args)
    {
        out.println(sum(1, 2));
        out.println(sum(1, 2, 3));
        out.println(sum(1, 2, 3, 4));
    }

    static int sum(int a, int b) { return a + b; }

    // 方法重载
    static int sum(int a, int b, int c)
    {
        return a + b + c;
    }

    // 可变参数，必须是最后一个参数
    static int sum(int... arr)
    {
        int sum = 0;
        for (int i : arr) sum += i;
        return sum;
    }
}
