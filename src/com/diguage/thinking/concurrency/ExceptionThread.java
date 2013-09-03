package com.diguage.thinking.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程下异常演示
 * <p/>
 * User: D瓜哥，http://www.diguage.com/
 * Date: 13-9-3
 * Time: 上午10:12
 */
public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
