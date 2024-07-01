package syntax.lambda;

public class ThisTest
{
    public static void main(String[] args)
    {
        new Test().test();
    }
}

class Test
{
    public void test()
    {
        Obj o = new Obj();
        o.print(this::str);
    }

    public String str()
    {
        return "Object";
    }
}

class Obj
{
    public void print(Lambda lambda)
    {
        System.out.println(lambda.get());
    }
}

interface Lambda
{
    String get();

    default String str()
    {
        return "Lambda";
    }
}