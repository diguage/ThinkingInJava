package com.diguage.books.thinking.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * 格式化的内存输入（没发现格式化到哪里去啊？！）
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-10 19:14
 */
public class FormatedMemoryInput {
    public static void main(String[] args) throws IOException {
        try {
            String filename = "/Users/diguage/develop/ruby/projects/Vagrantfile";

            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(
                            BufferedInputFile.read(filename).getBytes())
            );
            while (true) {
                System.out.println((char) in.readByte());
            }

        } catch (EOFException e) {
            System.out.println("End of stream");
        }
    }

}
