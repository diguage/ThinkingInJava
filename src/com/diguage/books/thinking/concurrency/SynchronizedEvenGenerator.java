package com.diguage.books.thinking.concurrency;

/**
 * 经过修改，进行同步安全的代码
 * <p/>
 * User: D瓜哥，http://www.diguage.com/
 * Date: 13-9-3
 * Time: 下午2:24
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentValue = 0;

    @Override
    public synchronized int next() {
        ++currentValue;
        Thread.yield(); // Cause failure faster
        ++currentValue;
        return currentValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
