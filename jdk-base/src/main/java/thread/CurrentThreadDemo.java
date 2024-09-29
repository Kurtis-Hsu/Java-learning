package thread;

/// 执行 `main` 方法的是 Java 虚拟机创建的名为 'main' 的主线程
///
/// [Thread#currentThread()] 获取运行当前代码的线程
public class CurrentThreadDemo
{
    public static void main(String... args)
    {
        var main = Thread.currentThread();
        System.out.println("Main thread: " + main);
        run();
    }

    public static void run()
    {
        var t = Thread.currentThread();
        System.out.println("Run thread: " + t);
    }
}
