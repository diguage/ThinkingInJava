package com.diguage.thinking.concurrency;

/**
 * 使用如下指令查看编译后的class文件结构
 * javap -c Atomicity
 * <p/>
 * User: D瓜哥，http://www.diguage.com/
 * Date: 13-9-3
 * Time: 下午3:40
 */
public class Atomicity {
    int i;

    void f1() {
        i++;
    }

    void f2() {
        i += 3;
    }
}
