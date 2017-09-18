package com.dream.simpletcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer4 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                Socket socket = serverSocket.accept();
                new ServerThread4(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerThread4 extends Thread {

    private Socket socket;

    public ServerThread4(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String context;
            while ((context = br.readLine()) != null) {
                System.out.println("服务端收到: " + context);

                bw.write(context + "\r\n");
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
