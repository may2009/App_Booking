package com.example.demo.dao;

import com.example.demo.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,Integer> {



    @Query(value = " SELECT h.* FROM hotel h LEFT JOIN booking b ON h.id = b.hotel \n" +
            "  WHERE ((STR_TO_DATE(b.date_debut , '%Y-%m-%d') NOT BETWEEN STR_TO_DATE(:date_debut , '%Y-%m-%d') AND STR_TO_DATE(:date_fin , '%Y-%m-%d'))\n" +
            "  AND   (STR_TO_DATE(b.date_fin , '%Y-%m-%d') NOT BETWEEN STR_TO_DATE(:date_debut , '%Y-%m-%d') AND STR_TO_DATE(:date_fin , '%Y-%m-%d')))\n" +
            "  OR h.id NOT IN (SELECT b.hotel FROM booking b)\n" +
            "  GROUP BY h.id",nativeQuery = true)
    List<Hotel> gethotelNoReserve(String date_debut, String date_fin);
}
