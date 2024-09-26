package syntax.extend;

/**
 * <h2>子类</h2>
 *
 * @Date 2023/11/3 22:06
 */
public class Child
        extends Parent
{
    static
    {
        System.out.println("Child static block");
    }

    {
        System.out.println("Child block");
    }

    Child()
    {
        System.out.println("Child constructor");
        // super(); // Java 22 开始可以在调用构造器函数之前执行某些代码，这些代码会被编译器严格检查
    }
}