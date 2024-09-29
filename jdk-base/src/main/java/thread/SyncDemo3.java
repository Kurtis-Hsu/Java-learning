package thread;

/// 互斥性
///
/// 当使用多个 synchronized 锁定多个代码片段，并且指定了相同的同步监视器对象时，这些代码片段之间就是互斥的，多个线程不能同时执行它们
public class SyncDemo3
{
    public static void main(String[] args)
    {
        Boo boo = new Boo();
        new Thread(boo::methodA).start();
        new Thread(boo::methodB).start();
    }

    private static class Boo
    {
        public synchronized void methodA() { run('A'); }

        // public synchronized void methodB()
        public void methodB()
        { synchronized (this) { run('B'); } }

        public void run(char method)
        {
            try
            {
                var t = Thread.currentThread();
                System.out.printf("%s 正在执行 %c 方法...%n", t.getName(), method);
                Thread.sleep(5000);
                System.out.printf("%s 执行 %c 方法完毕！%n", t.getName(), method);
            }
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
