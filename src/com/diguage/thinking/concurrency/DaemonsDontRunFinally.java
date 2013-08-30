package com.diguage.thinking.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * 处理后台线程的中断时，finally中的代码不一定执行；
 * 因为后台线程会随着主线程的终止而立刻终止
 * <p/>
 * User: D瓜哥，http://www.diguage.com/
 * Date: 13-8-30
 * Time: 上午11:55
 */
class ADaemon implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Starting DaemonsDontRunFinally");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
        } finally {
            System.out.println("This should always run?");
        }
    }

}

public class DaemonsDontRunFinally {
    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }
}
