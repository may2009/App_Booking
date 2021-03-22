package com.example.demo.dao;


import com.example.demo.models.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDetailRepo extends JpaRepository<BookingDetail,Integer> {


     @Query(value = "SELECT b FROM BookingDetail b order by b.id desc")
    List<BookingDetail> getAll();
}
