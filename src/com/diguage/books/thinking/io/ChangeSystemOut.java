package com.diguage.books.thinking.io;

import java.io.PrintWriter;

/**
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-12 9:24
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out, true);
        pw.println("Hello, D瓜哥");
    }
}
