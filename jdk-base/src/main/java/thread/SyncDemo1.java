package thread;

/// 多线程并发安全问题
///
/// 当多个线程并发操作同一临界资源，由于操作顺序不确定，导致操作结果出现混乱从而出现不良后果
///
/// 临界资源：操作该资源的完整过程同一时刻只能被单一线程进行
public class SyncDemo1
{
    public static void main(String[] args)
    {
        var table = new Table();

        Runnable task = () ->
        {
            while (true)
            {
                var bean = table.getBean();
                Thread.yield();
                System.out.println(Thread.currentThread().getName() + ": " + bean);
            }
        };

        new Thread(task, "线程 1").start();
        new Thread(task, "线程 2").start();
    }

    private static class Table
    {
        private int beans = 20; // 桌子上有20个豆子

        /// 当一个方法使用 `synchronized` 修饰后，这个方法称为"同步方法"，即：多个线程不能同时在该方法内部执行
        /// - 同步执行
        ///
        ///   多个线程在执行某个任务时存在先后顺序地有序执行
        ///
        /// - 异步执行
        ///
        ///   线程之间互不干涉一起执行
        public synchronized int getBean()
        {
            // 从桌子上拿取一个豆子的方法
            if (beans == 0)
                // 如果桌子上没有豆子
                throw new RuntimeException("没有豆子了");

            // `yield` 方法可以让执行该方法的线程主动放弃本次剩余时间片
            Thread.yield(); // 主动放弃时间片，模拟线程执行到这里没有时间了
            return beans--;
        }
    }
}
