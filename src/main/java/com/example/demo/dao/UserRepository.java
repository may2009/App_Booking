package com.example.demo.dao;


import com.example.demo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
    Users findByUserName(String userName);

    @Query(value = "SELECT * FROM USERS u WHERE TIMESTAMPDIFF(YEAR,u.date_naissance, NOW())>=18",nativeQuery = true)
    List<Users> getUserByAge();
}