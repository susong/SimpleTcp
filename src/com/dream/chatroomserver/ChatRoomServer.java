package com.dream.chatroomserver;

/**
 * Created by SuSong on 2017/6/26.
 */
public class ChatRoomServer {

    public static void main(String[] args) {
        new TcpServerListener().start();
        System.out.println("服务端启动");
    }
}
