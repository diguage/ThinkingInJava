package com.diguage.books.thinking.concurrency;

/**
 * 哲学家问题：筷子
 * <p/>
 * Coder: D瓜哥，http://www.diguage.com/
 * Date: 2013-10-01
 * Time: 17:21
 */
public class Chopstick {
    private boolean taken = false;

    public synchronized void take() throws InterruptedException {
        while (taken) {
            wait();
        }
        taken = true;
    }

    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}
