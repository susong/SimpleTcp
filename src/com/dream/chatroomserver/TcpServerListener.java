package com.dream.chatroomserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by SuSong on 2017/6/26.
 */
public class TcpServerListener extends Thread {

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                Socket socket = serverSocket.accept();
                ChatRoom chatRoom = new ChatRoom(socket);
                chatRoom.start();
                ChatRoomManager.getInstance().add(chatRoom);
                System.out.println("有新客户端加入");
//                JOptionPane.showMessageDialog(null,"有新客户端加入");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
