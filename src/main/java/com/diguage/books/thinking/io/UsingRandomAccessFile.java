package com.diguage.books.thinking.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读写随机访问文件
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-11 16:16
 */
public class UsingRandomAccessFile {

    private static String fileName = Resource.BASE_PATH + "raf.txt";

    public static void display() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(fileName, "r");
        for (int i = 0; i < 7; i++) {
            System.out.println("Value " + i + " : " + raf.readDouble());
        }
        System.out.println(raf.readUTF());
        raf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        for (int i = 0; i < 7; i++) {
            raf.writeDouble(i * 1.41413);
        }
        raf.writeUTF("D瓜哥，http://www.diguage.com/");
        raf.close();
        display();
        raf = new RandomAccessFile(fileName, "rw");
        raf.seek(5 * 8);
        raf.writeDouble(47.00001);
        raf.close();
        display();
    }
}
