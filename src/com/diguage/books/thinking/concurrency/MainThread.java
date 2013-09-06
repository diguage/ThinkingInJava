package com.diguage.books.thinking.concurrency;

/**
 * User: D瓜哥，http://www.diguage.com/
 * Date: 13-8-27
 * Time: 下午3:15
 */
public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
