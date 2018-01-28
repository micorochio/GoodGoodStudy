package com.zing.nio_study;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by zing on 2017/4/16.
 */
public class TestChannel {
    /**
     * 通道用于源节点和目标节点的链接，负责缓冲区的数据传输。Channel可以管理多个Buffer。
     * <p>
     * 常见的Channel有
     * FileChannel ： 文件
     * ByteChannel ： 二进制
     * SocketChannel ：socket网络
     * ServerSocketChannel : socket服务
     * DatagramChannel ： 套接字
     * <p>
     * 获取Channel的方式
     * RandomAccessFile
     * FileInputStream/FIleOutputStream
     * <p>
     * Socket/ServerSocket
     * DatagramSocket
     */


    @Test
    public void testChannel() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        FileChannel inChannel = null, outChannel = null;
        try {
//            RandomAccessFile file = new RandomAccessFile(","rw");
            fileInputStream = new FileInputStream("/Users/zing/Documents/workspace/Web/good-good-study/learnnio/src/main/java/com/zing/nio_study/test_file/Input");
            fileOutputStream = new FileOutputStream("/Users/zing/Documents/workspace/Web/good-good-study/learnnio/src/main/java/com/zing/nio_study/test_file/Output");

//            获取通道
            inChannel = fileInputStream.getChannel();
            outChannel = fileOutputStream.getChannel();

//            应该buffer
            ByteBuffer readBuf = ByteBuffer.allocate(1024);

//            读取和写入
            while (inChannel.read(readBuf) != -1) {
                readBuf.flip();
                outChannel.write(readBuf);
                readBuf.clear();
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) fileInputStream.close();
                if (fileOutputStream != null) fileOutputStream.close();
                if (inChannel != null) inChannel.close();
                if (outChannel != null) outChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用直接缓冲区进行文件操作
     */
    @Test
    public void testDirectChannel() throws IOException {
        FileChannel inChannal = FileChannel.open(
                Paths.get("/Users/zing/Documents/workspace/Web/good-good-study/learnnio/src/main/java/com/zing/nio_study/test_file/Input"
                ), StandardOpenOption.READ);

        FileChannel outChannel = FileChannel.open(
                Paths.get("/Users/zing/Documents/workspace/Web/good-good-study/learnnio/src/main/java/com/zing/nio_study/test_file/Output2"
                ), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);//CREATE_NEW文件存在就报错，不存在就创建


        //内存映射文件
        MappedByteBuffer inBuffer = inChannal.map(FileChannel.MapMode.READ_ONLY, 0, inChannal.size());
        MappedByteBuffer outBufer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannal.size());

        byte[] bytes = new byte[inBuffer.limit()];
        inBuffer.get(bytes);
        outBufer.put(bytes);

        inChannal.close();
        outChannel.close();

    }

    /**
     * 通道直接的传输
     */
    @Test
    public void testTransferChannel() throws IOException {
        FileChannel inChannal = FileChannel.open(
                Paths.get("/Users/zing/Documents/workspace/Web/good-good-study/learnnio/src/main/java/com/zing/nio_study/test_file/Input"
                ), StandardOpenOption.READ);

        FileChannel outChannel = FileChannel.open(
                Paths.get("/Users/zing/Documents/workspace/Web/good-good-study/learnnio/src/main/java/com/zing/nio_study/test_file/Output3"
                ), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);//CREATE_NEW文件存在就报错，不存在就创建

        inChannal.transferTo(0,inChannal.size(),outChannel);

//        inChannal.close();
        outChannel.close();

        FileChannel outChannel2 = FileChannel.open(
                Paths.get("/Users/zing/Documents/workspace/Web/good-good-study/learnnio/src/main/java/com/zing/nio_study/test_file/Output4"
                ), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);//CREATE_NEW文件存在就报错，不存在就创建
        outChannel2.transferFrom(inChannal,0,inChannal.size());


    }

}
