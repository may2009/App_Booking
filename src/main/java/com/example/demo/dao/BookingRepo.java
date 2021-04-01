package com.example.demo.dao;

import com.example.demo.models.Booking;
import com.example.demo.models.Client;
import com.example.demo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Integer> {


     @Query(value = "SELECT b FROM Booking b order by b.id desc")
    List<Booking> getAll();


    @Query(value = "SELECT b FROM Booking b where b.client.id=:client order by b.id desc")
    List<Booking> findAllByClientId(int client);

    @Query(value = "SELECT sum(b.prix) FROM Booking b where b.client.id=:client")
    int SumPrixBooking(int client);

    @Query(value = "SELECT count(id) FROM booking WHERE STR_TO_DATE(:date , '%Y-%m-%d') BETWEEN STR_TO_DATE(date_debut , '%Y-%m-%d') AND STR_TO_DATE(date_fin , '%Y-%m-%d')",nativeQuery = true)
    int checkdateDebut(String date);
}
