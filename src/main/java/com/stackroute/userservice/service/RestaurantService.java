package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Restaurant;
import com.stackroute.userservice.repository.Res_Repository;
import com.stackroute.userservice.userexception.UserAlreadyException;
import com.stackroute.userservice.userexception.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    private Res_Repository res_repository;

    @Autowired
    public RestaurantService(Res_Repository res_repository) {
        this.res_repository = res_repository;
    }

    public RestaurantService() {
    }

    public Restaurant savedata(Restaurant restaurant) throws UserAlreadyException {
        if(res_repository.existsById(restaurant.getRes_id()))
        {
            throw new UserAlreadyException("User already present");
        }
        Restaurant restaurant1= (Restaurant) res_repository.save(restaurant);

//        if(restaurant1==null)
//        {
//            throw new UserAlreadyException("User already present");
//        }
        return restaurant1;
    }


    public List<Restaurant> getAllUsers()
    {
        return (List<Restaurant>) res_repository.findAll();
    }

    public Optional<Restaurant> getById(int id)
    {
        Optional<Restaurant> getUser= res_repository.findById(id);
        return getUser;

    }


    public void delete(int id)
    {
        res_repository.deleteById(id);
    }

    public List<Restaurant>getByQuery()
    {
       return res_repository.findalluser();
    }
    public   List<Restaurant> getbyname(String name) throws UserNotFound {
        if(res_repository.findByName(name).isEmpty())
        {
            throw  new UserNotFound("User Not Found");
        }
        List<Restaurant> restaurant1= res_repository.findByName(name);
        return restaurant1;
    }




}
