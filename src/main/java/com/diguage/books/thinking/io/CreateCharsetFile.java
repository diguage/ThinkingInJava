package com.diguage.books.thinking.io;


import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * 产生65536个字符
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-11 15:51
 */
public class CreateCharsetFile {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(Resource.CHARSET_FILE);
        for (int i = 0; i < 65536; i++) {
            if (i % 60 == 0) {
                pw.write("\n");
            }
            pw.write(i);
        }
        pw.close();
    }
}
