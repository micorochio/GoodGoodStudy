package com.zing.netty.ssy.week02.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by zing on 2017/5/31.
 */
public class ServerBoot {
    public static void main(String[] args) throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup() ;
        EventLoopGroup childGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,childGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ServerInitializer());

            ChannelFuture future = serverBootstrap.bind(8899).sync();
            future.channel().closeFuture().sync();
        }finally {
            childGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }
}
