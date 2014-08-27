package com.diguage.books.thinking.io;

import java.io.*;

/**
 * 标准I/O重定向
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-12 9:30
 */
public class Redirecting {
    public static void main(String[] args) throws IOException {
        String outFileName = Resource.BASE_PATH + "Redirecting.txt";

        PrintStream console = System.out;
        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(Resource.CHARSET_FILE));

        PrintStream ps = new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(outFileName))
        );
        System.setIn(bis);
        System.setOut(ps);
        System.setOut(ps);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String s = null;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        bis.close();
        ps.close();
        br.close();
        System.setOut(console);


        //BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
//        PrintStream ps = new PrintStream(outFileName);
//        System.setOut(ps);
//        for (int i = 0; i < 10; i++) {
//            System.out.println("第" + (i + 1) + "行");
//        }
    }
}
