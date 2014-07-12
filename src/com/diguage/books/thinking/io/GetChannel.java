package com.diguage.books.thinking.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 从FileInputStream、FileOutputStream、RandomAccessFile对象上
 * 获取FileChannel，对文件进行读写。
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-12 12:14
 */
public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        String channelFileName = Resource.BASE_PATH + "channel.txt";
        FileChannel fc = new FileOutputStream(channelFileName).getChannel();
        fc.write(ByteBuffer.wrap("Hello, D瓜哥，http://www.diguage.com/".getBytes()));
        fc.close();

        fc = new RandomAccessFile(channelFileName, "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("“地瓜哥”博客网".getBytes()));
        fc.close();

        fc = new FileInputStream(channelFileName).getChannel();
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        fc.read(bb);
        bb.flip();
        while (bb.hasRemaining()) {
            System.out.println((char) bb.get());
        }
    }
}
