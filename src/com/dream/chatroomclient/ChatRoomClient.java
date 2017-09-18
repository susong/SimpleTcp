package com.dream.chatroomclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

// 命令行使用 telnet 127.0.0.1 8080 也可以
public class ChatRoomClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            new ChatRoomClientThread(socket).start();
            OutputStream out = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String msg = scanner.next() + "\r\n";
                out.write(msg.getBytes());
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ChatRoomClientThread extends Thread {

    private Socket socket;

    public ChatRoomClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg;
            while ((msg = br.readLine()) != null) {
                System.out.println("客户端收到: " + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
