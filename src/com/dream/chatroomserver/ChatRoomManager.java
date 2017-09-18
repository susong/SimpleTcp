package com.dream.chatroomserver;

import java.util.Vector;

/**
 * Created by SuSong on 2017/6/26.
 */
public class ChatRoomManager {

    private ChatRoomManager() {
    }

    private static ChatRoomManager chatRoomManager = new ChatRoomManager();

    public static ChatRoomManager getInstance() {
        return chatRoomManager;
    }

    Vector<ChatRoom> chatRooms = new Vector<>();

    public void add(ChatRoom chatRoom) {
        if (!chatRooms.contains(chatRoom)) {
            chatRooms.add(chatRoom);
        }
    }

    public void publish(ChatRoom chatRoom, String message) {
        for (ChatRoom room : chatRooms) {
            if (!room.equals(chatRoom)) {
                room.send(message);
            }
        }
    }


}
