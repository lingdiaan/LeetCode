package com.yj.groupChat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

public class GroupChatClient {
    private final int port;
    private final String host;

    public GroupChatClient(int port, String host) {
        this.port = port;
        this.host = host;
    }

    public void run() {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        try {


        bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast("encoder", new StringEncoder());
                        pipeline.addLast("decoder", new StringDecoder());
                        pipeline.addLast(new GroupChatClientHandler());
                    }
                });
        ChannelFuture sync = bootstrap.connect(host, port).sync();
            Channel channel = sync.channel();
            System.out.println("------"+channel.localAddress()+"------");
            //客户端需要输入信息，创建扫描器
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNextLine()){
                String msg = scanner.nextLine();
                //通过channel发送服务器端
                channel.writeAndFlush(msg+"\r\n");
            }
        channel.closeFuture().sync();
    }catch (Exception e){

        }finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new GroupChatClient(7000, "127.0.0.1").run();
    }
}
