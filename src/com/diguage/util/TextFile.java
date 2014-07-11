package com.diguage.util;

import com.diguage.books.thinking.io.Resource;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * 文件读写工具类
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-11 19:10
 */
public class TextFile extends ArrayList<String> {
    /**
     * 读取指定文件内容。
     *
     * @param fileName 文件名
     * @return 文件内容
     */
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(
                            new File(fileName).getAbsoluteFile())
            );
            try {
                String s = null;
                while ((s = br.readLine()) != null) {
                    sb.append(s).append("\n");
                }
            } finally {
                br.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void write(String fileName, String text) {
        try {
            PrintWriter pw = new PrintWriter(
                    new File(fileName).getAbsoluteFile());
            try {
                pw.print(text);
            } finally {
                pw.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals("")) {
            remove(0);
        }
    }

    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public void write(String fileName) {
        try {
            PrintWriter pw = new PrintWriter(
                    new File(fileName).getAbsoluteFile());
            try {
                for (String item : this) {
                    pw.println(item);
                }
            } finally {
                pw.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String file = read(Resource.CHARSET_FILE);
        String fileName = Resource.BASE_PATH + "test.txt";
        write(fileName, file);
        TextFile textFile = new TextFile(fileName);
        textFile.write(Resource.BASE_PATH + "test2.txt");
        TreeSet<String> words = new TreeSet<String>(
                new TextFile(Resource.FILE_NAME, "\\W+"));
        System.out.println(words.headSet("a"));

    }

}
