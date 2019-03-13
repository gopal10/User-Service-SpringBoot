package com.stackroute.userservice.controller;


import com.stackroute.userservice.domain.Restaurant;
import com.stackroute.userservice.service.RestaurantService;
import com.stackroute.userservice.userexception.UserAlreadyException;
import com.stackroute.userservice.userexception.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2")
@CrossOrigin
public class ResController  {

     private RestaurantService restaurantService;

     @Autowired
    public ResController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/resto")
    public ResponseEntity<?> saveResto(@RequestBody Restaurant restaurant) throws UserAlreadyException {
        ResponseEntity responseEntity;
        Restaurant res= null;
       // try {
            res = restaurantService.savedata(restaurant);
//        } catch (UserAlreadyException e) {
//
//            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
////            e.printStackTrace();
//        }
        return new ResponseEntity<Restaurant>(res, HttpStatus.OK);
    }

    @GetMapping ("/users")
    public ResponseEntity<?> getAll()
    {
        return new ResponseEntity<List<Restaurant>> ( restaurantService.getAllUsers(),  HttpStatus.OK);

    }


    @GetMapping("/user/{id}")
    public ResponseEntity<Restaurant> GetUser(@PathVariable int id)
    {
        Optional<Restaurant> getuser  = restaurantService.getById(id);

        return new ResponseEntity<Restaurant>(getuser.get() , HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id)
    {
        restaurantService.delete(id);
        return "data deleted";

    }

    @PutMapping("/update/{id}")
    public String upadte(@RequestBody Restaurant restaurant, @PathVariable int id)
    {
        restaurant.setRes_id(id);
        try {
            restaurantService.savedata(restaurant);
        } catch (UserAlreadyException e) {
            e.printStackTrace();
        }
        return "Updated successfully";

    }

    @GetMapping("/query")
    public ResponseEntity<?> getQueryAll()
    {
       List<Restaurant>res= restaurantService.getByQuery();
        return new ResponseEntity<List<Restaurant>>(res, HttpStatus.OK);
    }

    @GetMapping("/query/{name}")
    public ResponseEntity getbyname(@PathVariable String name) throws UserNotFound {
        List<Restaurant> res= null;
//        try {
            res = restaurantService.getbyname(name);
            return new ResponseEntity <List<Restaurant>> (res, HttpStatus.OK);

//        }
//        catch (UserNotFound userNotFound) {
//            return new ResponseEntity <String> (userNotFound.getMessage(), HttpStatus.OK);
//        }

    }

}
