package com.dream.simpletcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        OutputStream out = socket.getOutputStream();
        out.write("hello".getBytes());
        out.flush();
        out.close();
        socket.close();
    }
}
