package com.diguage.thinking.concurrency;

/**
 * 演示volatile关键字在累加时，不保证线程安全性
 * <p/>
 * User: D瓜哥，http://www.diguage.com/
 * Date: 13-9-3
 * Time: 下午3:56
 */
public class SerialNumberGenerator{
    private static volatile int serialNumber = 0;

    public static int nextSerialNumber() {
        return serialNumber++;  // mot thread-safe
    }
}
