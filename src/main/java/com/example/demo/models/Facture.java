package com.example.demo.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "facture")
public class Facture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "datefacture", nullable = true)
    private String datefacture;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client")
    private Client client;


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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDatefacture() {
        return datefacture;
    }

    public void setDatefacture(String datefacture) {
        this.datefacture = datefacture;
    }


    @Transient
    public String getPdfPath() {
        if (name == null) return null;

        return "/pdf-file/"+ name;
    }


}