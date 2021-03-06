package com.zing.nio_study;


import org.junit.Test;
import org.junit.jupiter.api.Test;

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

        System.out.println(buffer.get(0));

//        System.out.println("容量："+buffer.capacity());
//        System.out.println("限制："+buffer.limit());
//        System.out.println("当前操作的位置："+buffer.position());


        System.out.println("\n写入模式");
        String a = "啊打还不结婚奥斯卡的骄傲克鲁塞德不出来了和";
        buffer.put(a.getBytes());
        System.out.println("容量capacity：" + buffer.capacity());
        System.out.println("限制limit：" + buffer.limit());
        System.out.println("当前操作的位置position：" + buffer.position());

//        从写模式切换到读模式
        System.out.println("\n切换到读模式 flip");
        buffer.flip();
        System.out.println("容量capacity：" + buffer.capacity());
        System.out.println("限制limit：" + buffer.limit());
        System.out.println("当前操作的位置position：" + buffer.position());

        System.out.println("\n读取之后 get(byte[])");
        byte[] data = new byte[buffer.limit()];
        buffer.get(data);
        System.out.println(new String(data, 0, data.length));
        System.out.println("容量capacity：" + buffer.capacity());
        System.out.println("限制limit：" + buffer.limit());
        System.out.println("当前操作的位置position：" + buffer.position());

        System.out.println("\n重复读取 rewind");
        buffer.rewind();
        System.out.println("容量capacity：" + buffer.capacity());
        System.out.println("限制limit：" + buffer.limit());
        System.out.println("当前操作的位置position：" + buffer.position());


//        mark和reset
        System.out.println("\nmark将位置标记，reset，将position退回到mark位置");
        data = new byte[buffer.limit()];
        buffer.get(data, 0, 4);
        System.out.println(new String(data, 0, data.length));
        System.out.println("当前操作的位置position：" + buffer.position());

        buffer.mark();
        buffer.get(data, 4, 4);
        System.out.println(new String(data, 0, data.length));
        System.out.println("当前操作的位置position：" + buffer.position());
        buffer.reset();
        System.out.println("reset 当前操作的位置position：" + buffer.position());
        buffer.get(data, 4, 4);
        System.out.println(new String(data, 0, data.length));
        System.out.println("当前操作的位置position：" + buffer.position());


        System.out.println("\n清除 clear");
//        清除之后数据在buffer中处于遗忘状态，不能被正确读取
        buffer.clear();
        System.out.println("容量capacity：" + buffer.capacity());
        System.out.println("限制limit：" + buffer.limit());
        System.out.println("当前操作的位置position：" + buffer.position());

/*  运行结果
        12

        写入模式
        容量capacity：1024
        限制limit：1024
        当前操作的位置position：64

        切换到读模式 flip
        容量capacity：1024
        限制limit：64
        当前操作的位置position：0

        读取之后 get(byte[])
                啊打还不结婚奥斯卡的骄傲克鲁塞德不出来了和
        容量capacity：1024
        限制limit：64
        当前操作的位置position：64

        重复读取 rewind
        容量capacity：1024
        限制limit：64
        当前操作的位置position：0

        mark将位置标记，reset，将position退回到mark位置
        啊                                                            
        当前操作的位置position：4
        啊打�                                                        
        当前操作的位置position：8
        reset当前操作的位置position：4
        啊打�                                                        
        当前操作的位置position：8

        清除 clear
        容量capacity：1024
        限制limit：1024
        当前操作的位置position：0

        Process finished with exit code 0*/
    }


    @Test
    public void directBufferTest() {
//        直接缓冲区和非直接缓冲区

//        非直接缓冲区是指JVM虚拟内存中，直接缓冲区是非JVM的直接物理内存

        System.out.println("获取非直接缓冲区");
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        System.out.println("获取直接缓冲区");
        ByteBuffer bufferDirect = ByteBuffer.allocateDirect(1024);

        System.out.println(buffer.isDirect());
        System.out.println(bufferDirect.isDirect());

//        长时间使用直接缓冲区容易导致内存被占满，程序被挤爆

    }

}
