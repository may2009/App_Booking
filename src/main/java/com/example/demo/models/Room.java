package com.example.demo.models;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "room")
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "prix", nullable = true)
    private float prix;

    @Column(name = "description", nullable = true)
    private String description;



    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel")
    private Hotel hotel;





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
