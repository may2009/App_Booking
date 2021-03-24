package com.example.demo.dao;

import com.example.demo.models.Booking;
import com.example.demo.models.User;
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


    @Query(value = "SELECT b FROM Booking b where b.users=:user order by b.id desc")
    List<Booking> findAllByUserId(Users user);
}
