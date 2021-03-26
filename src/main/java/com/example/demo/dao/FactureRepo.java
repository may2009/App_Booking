package com.example.demo.dao;


import com.example.demo.models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FactureRepo extends JpaRepository<Facture,Integer> {


}
