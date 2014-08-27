package com.diguage.books.thinking.io;

import java.io.IOException;
import java.io.StringReader;

/**
 * 从内存中输入字符
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-10 19:06
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader(BufferedInputFile.read(Resource.FILE_NAME));
        int c = 0;
        while ((c = reader.read()) != -1) {
            System.out.println((char) c);
        }
    }
}
