package com.example.demo.dao;
import com.example.demo.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ClientRepo extends JpaRepository<Client,Integer> {
    @Query(value = "SELECT u FROM Client u WHERE u.id =:id")
    Client getOneClient(@Param("id") int id);

     @Query(value = "SELECT u FROM Client u order by u.id desc")
    List<Client> getAll();

    @Query(value = "SELECT * FROM Client u WHERE TIMESTAMPDIFF(YEAR,u.date_naissance, NOW())>=18",nativeQuery = true)
    List<Client> getClientByAge();
}
