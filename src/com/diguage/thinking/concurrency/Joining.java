package com.diguage.thinking.concurrency;

/**
 * 演示join()方法的使用：如果某个线程在另外一个线程t上调用t.join()，
 * 此线程将会被挂起，直到目标线程t结束才恢复（及t.isAlive()返回为假）。
 * <p/>
 * User: D瓜哥，http://www.diguage.com/
 * Date: 13-8-30
 * Time: 下午2:38
 */
class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted. " +
                    "isInturrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName() + "has awakened");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}

public class Joining {
    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("Sleepy", 1500),
                grumpy = new Sleeper("Grumpy", 1500);

        Joiner dopey = new Joiner("Dopey", sleepy),
                doc = new Joiner("Doc", grumpy);
        grumpy.interrupt();
    }
}
