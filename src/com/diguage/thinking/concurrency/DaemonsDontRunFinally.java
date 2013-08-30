package com.diguage.thinking.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * User: D瓜哥，http://www.diguage.com/
 * Date: 13-8-30
 * Time: 上午11:55
 */
public class DaemonsDontRunFinally implements Runnable {
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
