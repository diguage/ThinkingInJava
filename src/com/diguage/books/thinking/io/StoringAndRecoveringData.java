package com.diguage.books.thinking.io;

import java.io.*;

/**
 * 存储与恢复数据
 * <p/>
 * 注意：写入类型和读取类型的顺序以及次数必须相同，不同则报错！
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-11 16:04
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        String fileName = Resource.BASE_PATH + "Data.txt";
        DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(fileName))
        );
        dos.writeDouble(Math.PI);
        dos.writeUTF("This is pi");
        dos.writeUTF("D瓜哥");
        dos.writeDouble(1.41413);
        dos.writeUTF("Square root of 2");
        dos.close();

        DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(fileName))
        );
        System.out.println(dis.readDouble());
        System.out.println(dis.readUTF());
        System.out.println(dis.readUTF());
        System.out.println(dis.readDouble());
        System.out.println(dis.readUTF());
    }
}
