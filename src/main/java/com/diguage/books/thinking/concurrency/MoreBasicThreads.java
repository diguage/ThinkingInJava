package com.diguage.books.thinking.concurrency;

/**
 * User: D瓜哥，http://www.diguage.com/
 * Date: 13-8-27
 * Time: 下午3:21
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Wating for LiftOff");
    }
}
