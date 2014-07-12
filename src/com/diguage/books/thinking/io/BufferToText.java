package com.diguage.books.thinking.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * 通过Channel将字符串写入到文件中，各种编码。
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-12 16:16
 */
public class BufferToText {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        String fileName = Resource.BASE_PATH + "ioBuffer.txt";
        FileChannel fc = new FileOutputStream(fileName).getChannel();
        fc.write(ByteBuffer.wrap("Some Text".getBytes()));
        fc.close();

        fc = new FileInputStream(fileName).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer()); // Don't work

        buffer.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded using " + encoding
                + " : " + Charset.forName(encoding).decode(buffer));
        fc.close();

        fc = new FileOutputStream(fileName).getChannel();
        fc.write(ByteBuffer.wrap("Hello, D瓜哥".getBytes("UTF-16BE")));
        fc.close();

        fc = new FileInputStream(fileName).getChannel();
        buffer.clear();
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
        fc.close();

        fc = new FileOutputStream(fileName).getChannel();
        buffer = ByteBuffer.allocate(24);
        buffer.asCharBuffer().put("Some text");
        fc.write(buffer);
        fc.close();

        fc = new FileInputStream(fileName).getChannel();
        buffer.clear();
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
        fc.close();
    }
}
