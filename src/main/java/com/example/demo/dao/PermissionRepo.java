package com.example.demo.dao;

import com.example.demo.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepo extends PagingAndSortingRepository<Permission,Integer> {
    @Query(value = "SELECT count(p.id) as total FROM Permission p where p.page.id=:id")
    int findByPageTotal(int id);

    @Query(value = "SELECT p FROM Permission p where p.page.id=:id")
    Permission findByPageId(int id);

}
