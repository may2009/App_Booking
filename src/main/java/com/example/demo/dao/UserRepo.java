package com.example.demo.dao;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(value = "SELECT u FROM User u WHERE u.id =:id")
    User getOneUser(@Param("id") int id);

     @Query(value = "SELECT u FROM User u order by u.id desc")
    List<User> getAll();

    @Query(value = "SELECT * FROM USER u WHERE TIMESTAMPDIFF(YEAR,u.date_naissance, NOW())>=18",nativeQuery = true)
    List<User> getUserByAge();
}
