package com.example.demo.models;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "image_room")
public class Image_room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "image", nullable = true)
    private String image;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room")
    private Room room;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }




    @Transient
    public String getRoomImagePath() {
        if (image == null) return null;

        return "/room-photos/" + id + "/" + image;
    }
}
