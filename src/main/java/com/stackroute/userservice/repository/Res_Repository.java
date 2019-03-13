package com.stackroute.userservice.repository;

import com.stackroute.userservice.domain.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Res_Repository extends CrudRepository<Restaurant, Integer> {


    @Query(value = "SELECT * FROM restaurant",nativeQuery = true)
    List<Restaurant> findalluser();

    @Query(value = "SELECT res FROM Restaurant res where res.res_name =?1")
    List<Restaurant> findByName(String name);
}
