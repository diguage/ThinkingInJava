package com.diguage.books.thinking.util;

import com.diguage.books.thinking.io.BufferedInputFile;

import java.io.*;

/**
 * 二进制文件的读取
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-11 19:53
 */
public class BinaryFile {
    public static byte[] read(File bFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(bFile));
        try {
            byte[] data = new byte[bis.available()];
            bis.read(data);
            return data;
        } finally {
            bis.close();
        }
    }

    public static byte[] read(String bFileName) throws IOException {
        return read(new File(bFileName).getAbsoluteFile());
    }

}
