package thread;

/// 创建线程的方式二：实现 [Runnable] 接口单独定义线程任务
public class ThreadDemo2
{
    public static void main(String... args)
    {
        // 实例化任务
        Runnable r1 = () -> { for (int i = 0; i < 1000; i++) System.out.println("who are you?"); };
        Runnable r2 = () -> { for (int i = 0; i < 1000; i++) System.out.println("查水表！"); };

        // 实例化线程并指定任务，执行
        new Thread(r1).start();
        new Thread(r2).start();
    }
}
