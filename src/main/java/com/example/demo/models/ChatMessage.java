package com.example.demo.models;


import javax.persistence.*;

@Entity
@Table(name = "chatmessage")
public class ChatMessage {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "type", nullable = true)
    private MessageType type;

    @Column(name = "content", nullable = true)
    private String content;

    @Column(name = "sender", nullable = true)
    private String sender;



    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }


    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}