package com.diguage.books.thinking.io;

import java.nio.ByteBuffer;

/**
 * 从ByteBuffer中存取各种基本类型数据。
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-13 10:24
 */
public class GetData {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        int i = 0;
        while (i++ < bb.limit()) {
            if (bb.get() != 0) {
                System.out.println("nonzero");
            }
        }
        System.out.println("i =" + i);

        bb.rewind();

        bb.asCharBuffer().put("Howdy!");
        char c;
        while ((c = bb.getChar()) != 0) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.println("-------------");
        System.out.println(471142 + "=" + Integer.toBinaryString(471142));
        System.out.println(99471142 + "=" + Integer.toBinaryString(99471142));
        System.out.println("11000001100110" + "=" + Integer.parseInt("11000001100110", 2));
        System.out.println("-------------");

        bb.rewind();
        bb.asShortBuffer().put((short) 471142); //471142=1110011000001100110，short是2个字节，16bit数字。所以，只能取最后的15bit数字。
        System.out.println(bb.getShort());

        bb.rewind();
        bb.asIntBuffer().put(99471142);
        System.out.println(bb.getInt());

        bb.rewind();
        bb.asLongBuffer().put(99471142L);
        System.out.println(bb.getLong());

        bb.rewind();
        bb.asFloatBuffer().put(99471142);
        System.out.println(bb.getFloat());

        bb.rewind();
        bb.asDoubleBuffer().put(99471142);
        System.out.println(bb.getDouble());
    }
}
