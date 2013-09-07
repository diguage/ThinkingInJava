package com.diguage.books.thinking.util;

import java.io.PrintStream;

/**
 * 打印辅助类
 * <p/>
 * User: D瓜哥，http://www.diguage.com/
 * Date: 13-9-7
 * Time: 上午11:53
 */
public class Print {
    // Print with a newline:
    public static void print(Object obj) {
        System.out.println(obj);
    }

    // Print a newline by itself:
    public static void print() {
        System.out.println();
    }

    // Print with no line break:
    public static void printnb(Object obj) {
        System.out.print(obj);
    }

    // The new Java SE5 printf() (from C):
    public static PrintStream printf(String format, Object... args) {
        return System.out.printf(format, args);
    }
} ///:~
