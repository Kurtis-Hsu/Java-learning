package stdlib.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <h2>锁</h2>
 * <p>
 * 每个对象都包含自带一个锁
 *
 * @Date 2024-04-02 22:44
 */
public class LockDemo
{
    // 锁
    private Lock lock;
    // 锁条件
    private Condition condition;

    {
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    // 使用 synchronized 关键字会锁住该对象的锁
    public synchronized void hello() { System.out.println("Hello World!"); }

    // 带 synchronized 的 static 方法会锁住当前类的 Class 类对象的锁
    public static synchronized void hi() { System.out.println("Hi"); }

    private Object lockObj;

    {
        // 锁住括号中的对象
        synchronized (lockObj)
        {
            { }
        }
    }
}