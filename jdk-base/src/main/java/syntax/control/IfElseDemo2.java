package syntax.control;

import static java.lang.System.out;

public class IfElseDemo2
{
    public static void main(String... args)
    {
        int i = 1;
        // else if
        if (i > 100)
            out.println("true");
        else if (i < 0)
            out.println("false");
        else
            out.println("other");
    }
}
