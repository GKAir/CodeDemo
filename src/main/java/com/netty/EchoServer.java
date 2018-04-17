package com.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 引导服务器
 *
 * @author zhangweizhou
 * Email: zhangweizhou@wanhuchina.com
 * Date:  2018/4/14
 * Time:  18:32
 */
public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage:" + EchoServer.class.getSimpleName() + "<port>");
        }
        //设置端口值，如果端口值的格式不正确，则抛出异常
        int port = Integer.parseInt(args[0]);
        //调用服务器的start方法
        new EchoServer(port).start();
    }

    public void start() throws Exception {
        final EchoServerHandler echoServerHandler = new EchoServerHandler();
        //创建EchoServerHandler
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            //创建ServerBootstrap
            ServerBootstrap b = new ServerBootstrap();
            b.group(eventLoopGroup)
                    //指定所使用的NIO传输Channel
                    .channel(NioServerSocketChannel.class)
                    //使用指定端口设置套接字地址
                    .localAddress(port)
                    //添加一个EchoServerHandler到Channel的ChannelPipeline
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //EchoServerHandler 被标注为@Shareable，所以我们可以总是使用同样的实例
                            ch.pipeline().addLast(echoServerHandler);
                        }
                    });
            //异步地绑定服务器调用 sync()方法阻塞等待直到绑定完成
            ChannelFuture future = b.bind().sync();
            //获取 Channel 的CloseFuture，并且阻塞当前线程直到它完成
            future.channel().closeFuture().sync();
        } finally {
            //关闭EventLoopGroup，释放所有资源
            eventLoopGroup.shutdownGracefully().sync();
        }
    }
}
