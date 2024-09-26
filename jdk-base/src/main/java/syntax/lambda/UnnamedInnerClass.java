package syntax.lambda;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <h2>匿名内部类测试</h2>
 *
 * @Date 2024-04-28 16:20
 */
public class UnnamedInnerClass
{
    public static void 类型测试()
    {
        List<Object> list = new LinkedList<>();
        for (int i = 0; i < 10; i++)
        {
            final int d = i;
            list.add(
                    new Object()
                    {
                        private final int test = d;

                        @Override public String toString()
                        {
                            return STR."\{test} - \{getClass().getName()}";
                        }
                    }
            );
        }

        list.forEach(System.out::println);
    }

    public static void 类型测试2()
    {
        for (var v : TimeUnit.values()) System.out.println(v.getClass().getName());
    }

    public static void main(String[] args)
    {
        类型测试2();
    }
}