package com.diguage.books.thinking.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 缓冲区输入文件
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-10 11:29
 */
public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        String temp = null;
        while ((temp = bufferedReader.readLine()) != null) {
            sb.append(temp).append("\n");
        }
        bufferedReader.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String filename = "/Users/diguage/develop/ruby/projects/Vagrantfile";
        System.out.println(read(filename));
    }
}
