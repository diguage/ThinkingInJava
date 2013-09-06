package com.diguage.books.thinking.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * User: D瓜哥，http://www.diguage.com/
 * Date: 13-8-30
 * Time: 下午1:44
 */

// 使用内部类
class InnerThread {
    private int countDown = 5;
    private Inner inner;

    public InnerThread(String name) {
        inner = new Inner(name);
    }

    private class Inner extends Thread {
        private Inner(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) {
                        return;
                    }
                    sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }

        public String toString() {
            return getName() + ": " + countDown;
        }
    }
}

// 使用匿名内部类
class InnerThread2 {
    private int countDown = 5;
    private Thread t;

    InnerThread2(String name) {
        t = new Thread(name) {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.println("sleep() interrupted");
                }
            }
        };

        t.start();
    }
}


class InnerRunnable {
    private int countDown = 5;
    private Inner inner;

    private class Inner implements Runnable {

        Thread t;

        private Inner(String name) {
            t = new Thread(name);
            t.start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) {
                        return;
                    }
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("sleep() interrupted");
            }
        }

        @Override
        public String toString() {
            return t.getName() + ": " + countDown;
        }
    }

    InnerRunnable(String name) {
        inner = new Inner(name);
    }
}

class InnerRunable2 {
    private int countDown = 5;
    private Thread t;

    InnerRunable2(String name) {
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.println("sleep() interrupted");
                }
            }

            @Override
            public String toString() {
                return Thread.currentThread().getName() +
                        ": " + countDown;
            }
        });
        t.start();
    }
}

class ThreadMethod {
    private int countDown = 5;
    private Thread t;
    private String name;

    ThreadMethod(String name) {
        this.name = name;
    }

    public void runTask() {
        if (t == null) {
            t = new Thread(name) {
                @Override
                public void run() {
                    try {
                        while (true) {
                            System.out.println(this);
                            if (--countDown == 0) {
                                return;
                            }
                            sleep(10);
                        }
                    } catch (InterruptedException e) {
                        System.out.println("sleep() interrupted");
                    }
                }

                @Override
                public String toString() {
                    return getName() + ": " + countDown;
                }
            };

            t.start();
        }
    }
}

public class ThreadVariations {
    public static void main(String[] args) {
        new InnerThread("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable("InnerRunnable1");
        new InnerRunnable("InnerRunnable2");
        new ThreadMethod("ThreadMethod").runTask();
    }
}
