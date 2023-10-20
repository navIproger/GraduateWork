package com.pasichnyk.techcollegebot.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "choose")
public class Choose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "chatId")
    private String chatId;

    @ManyToOne
    @JoinColumn(name = "class")
    private Group group;

    public Choose() {
    }

    public Choose(String chatId, Group group) {
        this.chatId = chatId;
        this.group = group;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
