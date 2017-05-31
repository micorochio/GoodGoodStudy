package com.zing.netty.example.http.helloworld;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;


/**
 * Created by zing on 2017/5/16.
 */
public class HelloWorldServer {
    static  final boolean SSL = null != System.getProperty("ssl");
    static int PORT = Integer.parseInt(System.getProperty("port",SSL?"8843":"8080"));

    public static void main(String[] args) throws Exception {
        final SslContext sslctx ;
        if(SSL){
            SelfSignedCertificate ssc = new SelfSignedCertificate();
            sslctx = SslContextBuilder.forServer(ssc.certificate(),ssc.privateKey()).build();
        }else {
            sslctx = null;
        }
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {

        ServerBootstrap b = new ServerBootstrap();
        b.option(ChannelOption.SO_BACKLOG,1024);
        b.group(bossGroup,workerGroup)
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .childHandler(new HttpHelloWorldServerHandlerInitialize(sslctx));

        Channel ch = b.bind(PORT).channel();
        System.err.println("Open your web browser and navigate to " +
                (SSL? "https" : "http") + "://127.0.0.1:" + PORT + '/');

        ch.closeFuture().sync();

        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
