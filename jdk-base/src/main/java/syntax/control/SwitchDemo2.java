package syntax.control;

import static java.lang.System.out;

public class SwitchDemo2
{
    public static void main(String... args)
    {
        var arg = new Object();

        // Java 17 之后增加了 switch 的功能
        switch (arg)
        {
            case null -> out.println("null");
            case Class<?> _ -> out.println("Class");
            default -> out.println("other");
        }
    }
}
