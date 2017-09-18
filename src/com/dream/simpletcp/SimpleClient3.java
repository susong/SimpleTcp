package com.dream.simpletcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient3 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            new ClientThread3(socket).start();
            OutputStream out = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String msg = scanner.next();
                out.write(msg.getBytes());
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientThread3 extends Thread {

    private Socket socket;

    public ClientThread3(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) != -1) {
                String msg = new String(buf, 0, len);
                System.out.println("客户端收到: " + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
