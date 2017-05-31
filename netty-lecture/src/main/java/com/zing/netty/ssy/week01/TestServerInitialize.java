package com.zing.netty.ssy.week01;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;


/**
 * Created by zing on 2017/5/15.
 */
public class TestServerInitialize extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("httpServerCotec", new HttpServerCodec());
        pipeline.addLast("textHttpServerHandler",new TestHttpServerHandler());
    }
}
