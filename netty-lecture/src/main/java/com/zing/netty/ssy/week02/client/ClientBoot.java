package com.zing.netty.ssy.week02.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by zing on 2017/5/31.
 */
public class ClientBoot {
    public static void main(String[] args) throws Exception {
        EventLoopGroup clientGroup = new NioEventLoopGroup();

        try {
            Bootstrap clientBootstrap = new Bootstrap();
            clientBootstrap.group(clientGroup).channel(NioSocketChannel.class)
                    .handler(new ClientInitliazer());

            ChannelFuture future = clientBootstrap.connect("localhost",8899).sync();
            future.channel().closeFuture().sync();

        }finally {
            clientGroup.shutdownGracefully();
        }
    }
}
