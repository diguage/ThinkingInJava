package com.diguage.books.thinking.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 测试DataInputStream的结束方式:available()
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-11 15:09
 */
public class TestEOF {
    public static void main(String[] args) throws IOException {
        String filename = "/Users/diguage/develop/ruby/projects/Vagrantfile";
        DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(filename))
        );

        while (dis.available() != 0) {
            System.out.println((char) dis.readByte());
        }
    }
}
