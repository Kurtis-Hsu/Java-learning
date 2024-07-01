package syntax.extend;

/**
 * <h2>父类</h2>
 *
 * @Date 2023/11/3 22:03
 */
public class Parent
{
    static {
        System.out.println("Parent static block");
    }

    {
        System.out.println("Parent block");
    }

    Parent()
    {
        System.out.println("Parent constructor");
    }
}