package syntax;

public class Access
{
    public static void main(String... args)
    {
        var demo = new AccessDemo1();
        demo.test();
        demo.publicMethod();
        demo.protectedMethod();
        // demo.privateMethod(); // 无法调用
    }
}

class AccessDemo1
{
    // 默认包可见
    // 包中的其他成员及其子类都可调用
    void test() { }

    // 受保护级别，仅同包类和子类可见
    protected void protectedMethod() { }

    // 私有级别，仅自己可见
    private void privateMethod() { }

    // 公开级别，任何地方都可见
    public void publicMethod() { }
}
