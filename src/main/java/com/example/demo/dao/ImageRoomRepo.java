package com.example.demo.dao;


import com.example.demo.models.Image_room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRoomRepo extends JpaRepository<Image_room,Integer> {

    @Query(value = "SELECT i FROM Image_room i where i.room.id=:id")
    List<Image_room> getByRoom(int id);


}
