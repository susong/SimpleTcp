package com.dream.simpletcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket client = serverSocket.accept();
        InputStream in = client.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        String msg = new String(buf, 0, len);
        System.out.println(msg);

        OutputStream out = client.getOutputStream();
        out.write(msg.getBytes());
        out.flush();
    }
}
