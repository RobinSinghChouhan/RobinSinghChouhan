package com.example.robinsinghchouhan;

public class Chat {
    String id;
    String chat;
    int image;

    public Chat(String id, String chat, int image) {
        this.id = id;
        this.chat = chat;
       // this.from = from;
      //  this.from_image = from_image;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getChat() {
        return chat;
    }

//    public String getFrom() {
//        return from;
//    }
//
//    public String getFrom_image() {
//        return from_image;
//    }

    public int getImage() {
        return image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

//    public void setFrom(String from) {
//        this.from = from;
//    }

//    public void setFrom_image(String from_image) {
//        this.from_image = from_image;
//    }

    public void setImage(int image) {
        this.image = image;
    }
}
