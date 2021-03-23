package com.example.demo.dao;

import com.example.demo.models.SendMail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SendMailRepo extends JpaRepository<SendMail,Integer> {
}
