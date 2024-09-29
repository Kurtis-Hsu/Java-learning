package thread;

/// 守护线程（后台线程）
///
/// 正常创建的线程都称为"用户线程"，也可称为普通线程或前台线程，守护线程通过调用 [Thread#setDaemon(boolean)] 开启
///
/// 当一个 Java 进程中的所有用户线程都结束时，进程就会结束，此时进程会强制杀死所有还在运行的守护线程
public class DaemonThreadDemo
{
    public static void main(String[] args)
    {
        var jerry = new Thread(() -> {
            for (int i = 0; i < 5; i++)
            {
                System.out.println("Jerry: I need healing!");
                try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            }
            System.out.println("Jerry dead");
        });

        var tom = new Thread(() -> {
            while (true)
            {
                System.out.println("Tom: Eating melon");
                try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        });

        jerry.start();
        // 设置守护线程必须在线程启动前进行
        tom.setDaemon(true);
        tom.start();

        // 主线程也是用户线程，如果主线程不结束，进程就不会结束（因为还有用户线程活着）
        // while (true);
    }
}
