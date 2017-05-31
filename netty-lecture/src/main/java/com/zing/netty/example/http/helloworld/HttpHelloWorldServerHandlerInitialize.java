package com.zing.netty.example.http.helloworld;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.HttpServerExpectContinueHandler;
import io.netty.handler.ssl.SslContext;

/**
 * Created by zing on 2017/5/16.
 */
public class HttpHelloWorldServerHandlerInitialize  extends ChannelInitializer<SocketChannel> {

    SslContext SSLContext;
    public HttpHelloWorldServerHandlerInitialize(SslContext sslContext) {
        this.SSLContext = sslContext;
    }


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline p = ch.pipeline();
        if (null!=SSLContext){
            p.addLast(SSLContext.newHandler(ch.alloc()));
        }
        p.addLast(new HttpServerCodec());
        p.addLast(new HttpServerExpectContinueHandler());
        p.addLast(new HttpHelloWorldServerHandler());
    }
}
