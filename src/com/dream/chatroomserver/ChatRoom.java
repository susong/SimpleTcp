package com.dream.chatroomserver;

import java.io.*;
import java.net.Socket;

/**
 * Created by SuSong on 2017/6/26.
 */
public class ChatRoom extends Thread {

    private Socket socket;
    private BufferedWriter bw;
    private BufferedReader br;

    public ChatRoom(Socket socket) {
        this.socket = socket;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String line;
            while ((line = br.readLine()) != null) {
                ChatRoomManager.getInstance().publish(this, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String message) {
        try {
            String newMessage = message + "\r\n";
            bw.write(newMessage, 0, newMessage.length());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
