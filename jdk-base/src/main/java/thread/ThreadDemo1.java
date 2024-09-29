package thread;

/// 创建线程的方式一：继承 [Thread] 并重写 `run` 方法
///
/// 优点：结构简单，有利于匿名内部类形式创建
///
/// 缺点：
/// - 存在继承冲突问题
///
///   由于 Java 是单继承的，意味着如果继承了 [Thread] 则无法继承其他类去复用方法，在实际开发中非常不便
///
/// - 当定义线程的同时重写了 `run` 方法并将线程任务定义在其中，导致线程与线程任务存在必然的耦合关系，不利于线程重用
public class ThreadDemo1
{
    public static void main(String... args)
    {
        // 启动线程要调用线程的 start 方法，而不是直接调用 run 方法
        // run 方法依然是当前线程执行
        new MyThread1().start();
        new MyThread2().start();
    }

    private static class MyThread1 extends Thread
    {
        @Override public void run() { for (int i = 0; i < 1000; i++) System.out.println("who are you?"); }
    }

    private static class MyThread2 extends Thread
    {
        @Override public void run() { for (int i = 0; i < 1000; i++) System.out.println("查水表！"); }
    }
}
