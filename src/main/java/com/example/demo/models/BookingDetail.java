package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "booking_detail")
public class BookingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "booking")
    private Booking booking;
    @Column(name = "booking_name", nullable = true)
    private String booking_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getBooking_name() {
        return booking_name;
    }

    public void setBooking_name(String booking_name) {
        this.booking_name = booking_name;
    }
}