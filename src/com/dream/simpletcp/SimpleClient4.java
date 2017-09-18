package com.dream.simpletcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient4 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            new ClientThread4(socket).start();
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

class ClientThread4 extends Thread {

    private Socket socket;

    public ClientThread4(Socket socket) {
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
