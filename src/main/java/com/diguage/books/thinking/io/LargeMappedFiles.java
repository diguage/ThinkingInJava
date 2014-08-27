package com.diguage.books.thinking.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-15 12:15
 */
public class LargeMappedFiles {
    static int length = 0x8FFFFFFF; // 128M

    public static void main(String[] args) throws IOException {
        String fileName = Resource.FILE_NAME;//Resource.BASE_PATH + "ioLargeFile.txt";

        MappedByteBuffer mbb = new RandomAccessFile(fileName, "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);

        long start = System.currentTimeMillis();
        for (int i = 0; i < length; i++) {
            mbb.put((byte) 'x');
        }
        long end = System.currentTimeMillis();
        System.out.println("Finished writing.耗时：" + (end - start));
        for (int i = length / 2; i < length / 2 + 6; i++) {
            System.out.println((char) mbb.get(i));
        }
    }
}
