package com.yj.netty;

import io.netty.channel.EventLoopGroup;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class NettyTest {
    public static void main(String[] args) throws IOException {
        //创建serversocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        Selector selector = Selector.open();

        //绑定端口
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //吧serversocket 注册到 selector 关心 事件为op_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while(true){
            //等待1s
            if(selector.select(1000) == 0){
                System.out.println("服务器等待了1s，无连接");
                continue;
            }
        }
    }
}
