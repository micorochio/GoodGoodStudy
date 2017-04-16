package com.zing.nio_study;


import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * Buffer缓冲区，大小一定的数据块。（数组）
 * <p>
 * 基本数据类型除了 boolean 其他都有buffer对应
 * <p>
 * ShortBuffer
 * ByteBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 * CharBuffer
 */
public class TestBuffer {

    @Test
    public void ByteBufferTest() {
//        开辟一块制定大小空间交给buffer

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.put((byte) 12);

        buffer.get(0);

        System.out.println(buffer);

    }


}
