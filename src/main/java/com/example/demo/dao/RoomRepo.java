package com.example.demo.dao;


import com.example.demo.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepo extends JpaRepository<Room,Integer> {

    @Query(value = "SELECT r FROM Room r where r.id=:id")
    Room getId(int id);
}
