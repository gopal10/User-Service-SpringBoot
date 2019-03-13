package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Restaurant;
import com.stackroute.userservice.repository.RestaurantRepository;
import com.stackroute.userservice.exception.UserAlreadyException;
import com.stackroute.userservice.exception.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    private RestaurantRepository restaurant_repository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurant_repository) {
        this.restaurant_repository = restaurant_repository;
    }

    public RestaurantService() {
    }

    public Restaurant savedata(Restaurant restaurant) throws UserAlreadyException {
        if(restaurant_repository.existsById(restaurant.getRes_id()))
        {
            throw new UserAlreadyException("User already present");
        }
        Restaurant restaurant1= (Restaurant) restaurant_repository.save(restaurant);

//        if(restaurant1==null)
//        {
//            throw new UserAlreadyException("User already present");
//        }
        return restaurant1;
    }


    public List<Restaurant> getAllUsers()
    {
        return (List<Restaurant>) restaurant_repository.findAll();
    }

    public Optional<Restaurant> getById(int id)
    {
        Optional<Restaurant> getUser= restaurant_repository.findById(id);
        return getUser;

    }


    public void delete(int id)
    {
        restaurant_repository.deleteById(id);
    }

    public List<Restaurant>getByQuery()
    {
       return restaurant_repository.findalluser();
    }
    public   List<Restaurant> getbyname(String name) throws UserNotFound {
        if(restaurant_repository.findByName(name).isEmpty())
        {
            throw  new UserNotFound("User Not Found");
        }
        List<Restaurant> restaurant1= restaurant_repository.findByName(name);
        return restaurant1;
    }




}
