package com.diguage.thinking.concurrency;

/**
 * 线程的使用方式：继承Thread类
 * <p/>
 * User: D瓜哥，http://www.diguage.com/
 * Date: 13-8-30
 * Time: 下午1:32
 */
public class SimpleThread extends Thread {
    private int countDown = 5;
    private static int threadCount = 0;

    public SimpleThread() {
        super(Integer.toString(++threadCount));
        start();
    }

    @Override
    public String toString() {
        return "#" + getName() + "(" + countDown + ")， ";
    }

    @Override
    public void run() {
        while (true) {
            System.out.print(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }
}
