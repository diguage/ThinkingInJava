package com.diguage.books.thinking.io;

import java.io.*;

/**
 * 基本的文件输出
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-11 15:18
 */
public class BasicFileOutput {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read(Resource.FILE_NAME))
        );

        PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                        new FileWriter("/Users/diguage/BasicFileOutput.java"))
        );

        int lineCount = 1;
        String s = null;

        while ((s = br.readLine()) != null) {
            pw.write(lineCount++ + "\t:" + s + "\n");
        }
        br.close();
        pw.close();

        System.out.println(BufferedInputFile.read(Resource.FILE_NAME));
    }
}
