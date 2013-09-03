package com.diguage.thinking.concurrency;

/**
 * 整数生成器抽象类
 *
 * User: D瓜哥，http://www.diguage.com/
 * Date: 13-9-3
 * Time: 上午11:18
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    // Allow this to be canceled
    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
