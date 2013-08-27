package com.diguage.thinking.concurrency;

/**
 * User: D瓜哥，http://www.diguage.com/
 * Date: 13-8-27
 * Time: 下午3:18
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
