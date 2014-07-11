package com.diguage.books.thinking.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * 文本输出的快捷方式
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-11 15:41
 */
public class FileOutputShortcut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new StringReader(BufferedInputFile.read(Resource.FILE_NAME))
        );

        PrintWriter pw = new PrintWriter("/Users/diguage/FileOutputShortcut.java");

        int lineCount = 0;
        String s = null;

        while ((s = br.readLine()) != null) {
            pw.write(++lineCount + "\t:" + s + "\n");
        }
        pw.flush();

        br.close();
        pw.close();

        System.out.println(BufferedInputFile.read(Resource.FILE_NAME));
    }
}
