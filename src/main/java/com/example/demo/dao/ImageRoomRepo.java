package com.example.demo.dao;


import com.example.demo.models.Image_room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRoomRepo extends JpaRepository<Image_room,Integer> {

}
