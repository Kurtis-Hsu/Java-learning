package thread;

/// 线程优先级
///
/// 线程有10个优先级，分别用整数1-10表示，1为最低优先级，5为默认优先级，10为最高优先级
///
/// 线程优先级越高的线程获取CPU时间片的概率越高
public class PriorityDemo
{
    public static void main(String[] args)
    {
        var min = new Thread(() -> run("min"));
        var max = new Thread(() -> run("max"));
        var norm = new Thread(() -> run("nor"));

//        min.setPriority(1);
        min.setPriority(Thread.MIN_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);

        min.start();
        norm.start();
        max.start();
    }

    public static void run(String s) { for (int i = 0; i < 1000; i++) System.out.println(s); }
}
