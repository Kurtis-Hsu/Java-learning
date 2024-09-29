package thread;

/// 同步块
///
/// 同步块可以更准确地锁定需要多个线程同步执行的代码片段，有效地缩小同步范围可以在保证并发安全的前提下尽可能地提高效率
///
/// ``` java
/// synchronized (同步监视器对象)
/// {
///     需要同步执行的代码片段
/// }
/// ```
public class SyncDemo2
{
    public static void main(String[] args)
    {
        var shop = new Shop();
        Runnable task = shop::buy;

        new Thread(task, "范传奇").start();
        new Thread(task, "王克晶").start();
    }

    private static class Shop
    {
        // 如果在方法上使用synchronized，那么同步监视器对象不可选，只能是当前方法的所属对象(this)
        // public synchronized void buy(){
        public void buy()
        {
            try
            {
                var t = Thread.currentThread(); // 获取运行 buy 方法的线程
                System.out.println(t.getName() + "：正在挑衣服...");
                Thread.sleep(5000);

                /*
                    使用同步块时要明确制定同步监视器对象，该对象需要同时满足：
                    1：必须是一个引用类型的实例
                    2：多个需要同步执行该代码片段的线程看到的必须是同一个同步监视器对象
                 */

                // synchronized (new Object()) // 无效锁对象，凡是用实例化表达式作为锁对象一律无效
                // synchronized (t) // 无效锁对象，每个线程获取到的当前线程都是它自身，因此它们之间看到的不是同一个对象
                // synchronized ("abc")
                /*
                    字符串字面量就不是一个合适的锁对象
                    因为字符串字面量始终表示同一个字符串对象
                    因此无论什么情况下多个线程执行这个同步块始终看到同一个字符串对象
                    因此时刻处于同步的，但是在不应当同步的时候也同步就不是合适的锁对象
                 */
                synchronized (this)
                {
                    System.out.println(t.getName() + "：正在试衣间试衣服...");
                    Thread.sleep(5000);
                }
                System.out.println(t.getName() + "：结账离开");
            }
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
