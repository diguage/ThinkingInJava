package com.diguage.books.thinking.io;

import java.nio.ByteBuffer;

/**
 * 探究Buffer中的mark、position、limit和capacity的关系。
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-14 15:56
 */
public class InsideByteBuffer {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(10);
        insideOfByteBuffer(bb, "allocate");
        dataOfByteBuffer(bb);
        bb.put("ab".getBytes());
        insideOfByteBuffer(bb, "put");
        dataOfByteBuffer(bb);

        bb.flip();
        insideOfByteBuffer(bb, "flip");
        dataOfByteBuffer(bb);

//        bb.reset(); // 将position设置成mark的位置。
//        insideOfByteBuffer(bb, "reset");
//        dataOfByteBuffer(bb);

        bb.rewind();
        insideOfByteBuffer(bb, "rewind");
        dataOfByteBuffer(bb);

        bb.clear();
        insideOfByteBuffer(bb, "clear");
        dataOfByteBuffer(bb);
    }

    private static void dataOfByteBuffer(ByteBuffer bb) {
//        bb.flip();
//        while (bb.hasRemaining()) {
//            System.out.print(bb.get() + " ");
//        }
//        //bb.
    }

    private static void insideOfByteBuffer(ByteBuffer bb, String methodName) {
        System.out.println("\n\n--" + methodName + "-------------");
        System.out.println("mark----posi----limi----capa");
        System.out.println("\t\t" + bb.position()
                + "\t\t" + bb.limit() + "\t\t" + bb.capacity());
    }
}
