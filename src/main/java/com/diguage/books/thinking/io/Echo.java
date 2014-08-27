package com.diguage.books.thinking.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 使用标准输出进行回显
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-12 8:57
 */
public class Echo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String s = null;
        while ((s = br.readLine()) != null && s.length() != 0) {
            System.out.println(s);
        }
    }
}
