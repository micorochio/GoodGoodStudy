package com.zing.netty.ssy.week02.chatroom.chatserver;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * Created by zing on 2017/5/31.
 */
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    public static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        clients.forEach((ch)->{
            if(ch!=channel){
                ch.writeAndFlush(channel.remoteAddress() + ":" + msg);
            }else {
                ch.writeAndFlush(  "you:" + msg);
            }
        });
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();

        clients.writeAndFlush("[提示]：" + channel.remoteAddress() + "上线");

        clients.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();

        clients.writeAndFlush("[提示]：" + channel.remoteAddress() + "下线");

        clients.remove(channel);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();

        clients.writeAndFlush("[系统]：" + channel.remoteAddress() + "上线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();

        clients.writeAndFlush("[系统]：" + channel.remoteAddress() + "下线");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.writeAndFlush("服务故障");
        cause.printStackTrace();
        ctx.close();
    }
}
