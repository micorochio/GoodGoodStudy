package com.zing.netty.ssy.week02.chatroom.chatclient;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.*;

/**
 * Created by zing on 2017/5/31.
 */
public class ChatClient {
    public static void main(String[] args) throws Exception {
        EventLoopGroup chatGroup = new NioEventLoopGroup();

        try {
            Bootstrap chatClient = new Bootstrap();
            chatClient.group(chatGroup).channel(NioSocketChannel.class)
                    .handler(new ChatClientInitializer());

            Channel channel = chatClient.connect("localhost", 8899).channel();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            for (; ; ) {
                channel.writeAndFlush(bufferedReader.readLine() + "\r\n");
            }

//            ChannelFuture future = chatClient.connect("localhost", 8899).sync();
//            future.channel().closeFuture().sync();

        } finally {
            chatGroup.shutdownGracefully();
        }
    }
}
