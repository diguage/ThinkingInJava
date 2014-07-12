package com.diguage.books.thinking.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 通道直连，复制文件。
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-12 16:08
 */
public class TransferTo {
    public static void main(String[] args) throws IOException {
        String originFileName = Resource.CHARSET_FILE;
        String targetFileName = Resource.BASE_PATH + "target.txt";

        FileChannel in = new FileInputStream(originFileName).getChannel();
        FileChannel out = new FileOutputStream(targetFileName).getChannel();

        in.transferTo(0, in.size(), out);
    }
}
