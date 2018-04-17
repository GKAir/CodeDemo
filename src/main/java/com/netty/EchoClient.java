package com.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.Inet4Address;

/**
 * @author zhangweizhou
 * Email: zhangweizhou@wanhuchina.com
 * Date:  2018/4/16
 * Time:  11:48
 */
public class EchoClient {

/*    public final String host;
    public final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception {
        //创建一个
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //创建指定的bootstrap
            Bootstrap b = new Bootstrap();

            b.group(group)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new Inet4Address(host, port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoServerHandler());
                        }
                    });
            ChannelFuture f = b.connect().sync();
            f.channel().closeFuture().sync();
        } finally {
            //关闭线程池并且释放所有资源
            group.shutdownGracefully().sync();
        }

    }*/
}
