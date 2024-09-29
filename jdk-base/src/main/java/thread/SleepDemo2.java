package thread;

/// [Thread#sleep(long)] 要求必须处理中断异常
///
/// 当一个线程调用 [sleep][Thread#sleep(long)] 方法处于睡眠阻塞的过程中，该线程的 [interrupt][Thread#interrupt()] 方法被调用时，会抛出 [InterruptedException]
public class SleepDemo2
{
    public static void main(String[] args)
    {
        var tom = new Thread(() -> {
            System.out.println("Tom: sleep!");
            try { Thread.sleep(10000000); }catch (InterruptedException e) { System.out.println("Tom: shit!"); }
            System.out.println("Tom: woke up");
        });

        var jerry = new Thread(() -> {
            try
            {
                for (int i = 0; i < 5; i++)
                {
                    System.out.println("Jerry: 80!");
                    Thread.sleep(1000);
                }
                System.out.println("Jerry: done!");
            }
            catch (InterruptedException e) { e.printStackTrace(); }
            tom.interrupt();
        });

        tom.start();
        jerry.start();
    }
}
