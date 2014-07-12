package com.diguage.books.thinking.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 用Channel/Buffer进行文件复制
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-12 13:48
 */
public class ChannelCopy {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        String originFileName = Resource.CHARSET_FILE;
        String targetFileName = Resource.BASE_PATH + "target.txt";

        FileChannel in = new FileInputStream(originFileName).getChannel();
        FileChannel out = new FileOutputStream(targetFileName).getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while (in.read(buffer) != -1) {
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
    }
}
