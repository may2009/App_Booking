package com.example.demo.dao;

import com.example.demo.models.ChatMessage;
import com.example.demo.models.SendMail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChatMessageRepo extends JpaRepository<ChatMessage,Integer> {


    @Query(value = "SELECT c FROM ChatMessage c order by c.id desc")
    List<ChatMessage> findAllOrderBy();
}
